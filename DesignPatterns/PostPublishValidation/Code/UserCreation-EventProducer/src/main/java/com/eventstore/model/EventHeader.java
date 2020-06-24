package com.eventstore.model;

public class EventHeader {
    private String eventStatus;

    public EventHeader (String eventStatus){
        this.eventStatus = eventStatus;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

}
