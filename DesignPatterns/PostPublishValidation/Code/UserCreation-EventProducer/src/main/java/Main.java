import com.eventingsdk.EventingProducer;
import com.eventingsdk.EventingSDK;
import com.eventstore.RedisEventConnection;
import com.eventingsdk.model.User;
import com.eventingsdk.model.Users;
import com.google.gson.Gson;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){

        Properties config = readPropertiesConfig();
        Users users = readJsonFile();
        Gson gson = new Gson();

        long startTime = System.currentTimeMillis();
        for (User user: users.getUsers()) {
            //Create Message Record:
            String key = user.getUserId();
            String value = gson.toJson(user);
            ProducerRecord<String, String> record = new ProducerRecord<>(config.getProperty("topic"), key, value);

            //Kafka Event Producer:
            EventingProducer eventingProducer = new EventingSDK(record, config);
            eventingProducer.produceMessage();
        }
        long endTime = System.currentTimeMillis();

        long timeElapsed = endTime - startTime;
        System.out.println("Execution Time in Milliseconds: " + timeElapsed);

        RedisEventConnection.CloseConnectionPool();
    }


    public static Users readJsonFile(){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        StringBuilder contentBuilder = new StringBuilder();
        Gson gson = new Gson();

        try (Stream<String> stream = Files.lines(Paths.get(classloader.getResource("users.json").getFile()),
                StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Users users = (Users) gson.fromJson(contentBuilder.toString(), Users.class);
        return users;
    }

    public static Properties readPropertiesConfig(){
        Properties config = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return config;
            }
            config.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }
}