package com.eventstore.model;

public class EventStoreMessage <T>{
    private EventHeader eventHeader;
    private T eventPayload;

    public EventStoreMessage(EventHeader eventHeader, T eventPayload) {
        this.eventHeader = eventHeader;
        this.eventPayload = eventPayload;
    }
}
