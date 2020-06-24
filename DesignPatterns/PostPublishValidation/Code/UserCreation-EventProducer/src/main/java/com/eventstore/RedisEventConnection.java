package com.eventstore;

import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;

import java.util.HashMap;
import java.util.Map;

public class RedisEventConnection {
    private static Map<String, RedisEventConnection> redisEventConnectionSingleMap = null;
    private RedisConnection<String, String> connection;

    private RedisEventConnection(String redisURI) {
        this.connection = RedisEventClient.GetInstance(redisURI).connect();
    }

    public static RedisEventConnection GetInstance(String redisURI){
        if (redisEventConnectionSingleMap == null){
            redisEventConnectionSingleMap = new HashMap();
            redisEventConnectionSingleMap.put(redisURI, new RedisEventConnection(redisURI));
        }
        else if (!redisEventConnectionSingleMap.containsKey(redisURI)){
            redisEventConnectionSingleMap.put(redisURI, new RedisEventConnection(redisURI));
        }

        return redisEventConnectionSingleMap.get(redisURI);
    }

    public static void CloseConnectionPool (){
        if (redisEventConnectionSingleMap != null) {
            for(Map.Entry<String, RedisEventConnection> redisEventConnection : redisEventConnectionSingleMap.entrySet()) {
                redisEventConnection.getValue().getConnection().close();
            }
        }
        RedisEventClient.ShutDownRedisEventClient();
    }

    public RedisConnection<String, String> getConnection() {
        return this.connection;
    }

    private static class RedisEventClient{
        private static Map<String, RedisClient> redisClient = new HashMap<>();

        private static RedisClient GetInstance(String redisURI){
            if (!redisClient.containsKey(redisURI)){
                redisClient.put(redisURI, new RedisClient(RedisURI.create(redisURI)));
            }
            return redisClient.get(redisURI);
        }

        private static void ShutDownRedisEventClient (){
            for(Map.Entry<String, RedisClient> redisClientInstance : redisClient.entrySet()) {
                redisClientInstance.getValue().shutdown();
            }
        }
    }
}


