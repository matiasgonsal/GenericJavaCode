package com.mytube;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Video video = new Video();
        video.setFileName("birthday.mp4");
        video.setTitle("Jennifer's birthday");
        video.setUser(new User("john@domain.com", "9257911708"));


        VideoProcessor processor = new VideoProcessor(
                new VideoEncoder(),
                new SqlDataBase(),
                new SmsService());

        processor.process(video);

        processor.setNotificationService(new EmailService());
        processor.process(video);

    }
}
