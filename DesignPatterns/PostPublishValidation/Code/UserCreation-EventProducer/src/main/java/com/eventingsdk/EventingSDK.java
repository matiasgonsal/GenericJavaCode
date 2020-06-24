package com.eventingsdk;

import com.eventstore.RedisEventStore;
import com.eventstore.model.EventHeader;
import com.eventstore.model.EventStoreMessage;
import com.eventingsdk.model.User;
import com.eventstore.EventStore;
import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class EventingSDK implements EventingProducer {

    private ProducerRecord<String, String> record;
    private Properties config;

    public EventingSDK(ProducerRecord<String, String> record, Properties config) {
        this.record = record;
        this.config = config;
    }

    @Override
    public void produceMessage() {
        try {
            KafkaProducer producer = new KafkaProducer(this.config);
            Future<RecordMetadata> future = producer.send(this.record);

            RecordMetadata metadata = future.get();
            System.out.println(metadata.offset());
        } catch (Exception e) {
            System.out.println("WARNING: " + e.getMessage());
            storeMessage();
        }
    }


    private void storeMessage() {
        Gson gson = new Gson();
        User payload = (User) gson.fromJson(this.record.value(), User.class);

        EventStoreMessage<User> eventStoreMessage = new EventStoreMessage<>(
                new EventHeader("TO_SEND"), payload);

        EventStore redisEventStore = new RedisEventStore<User>(this.config, this.record.key(), eventStoreMessage);
        redisEventStore.store();
    }
}
