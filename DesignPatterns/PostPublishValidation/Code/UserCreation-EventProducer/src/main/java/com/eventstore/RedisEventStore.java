package com.eventstore;
import com.eventstore.model.EventStoreMessage;
import com.google.gson.Gson;

import java.util.Properties;

public class RedisEventStore<T> implements EventStore{
    private Properties config;
    private String key;
    private EventStoreMessage<T> eventStoreMessage;

    public RedisEventStore (Properties config, String key, EventStoreMessage<T> eventStoreMessage) {
        this.config = config;
        this.key = key;
        this.eventStoreMessage = eventStoreMessage;
    }

    @Override
    public void store() {
        try {
            Gson gson = new Gson();
            RedisEventConnection.GetInstance(this.config.getProperty("redis.url"))
                    .getConnection().set(this.key, gson.toJson(this.eventStoreMessage));
        } catch (Exception e){
            System.out.println("WARNING: " + e.getMessage());
        }
    }

}
