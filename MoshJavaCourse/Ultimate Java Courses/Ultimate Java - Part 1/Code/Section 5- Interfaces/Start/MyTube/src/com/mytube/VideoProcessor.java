package com.mytube;

public class VideoProcessor {
    private IVideoEncoder encoder;
    private IVideoDatabase database;
    private INotificationService notificationService;

    public VideoProcessor(IVideoEncoder encoder, IVideoDatabase database, INotificationService notificationService){
        this.encoder = encoder;
        this.database = database;
        this.notificationService = notificationService;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notificationService.notify(video.getUser());
    }

    public void setNotificationService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }
}

