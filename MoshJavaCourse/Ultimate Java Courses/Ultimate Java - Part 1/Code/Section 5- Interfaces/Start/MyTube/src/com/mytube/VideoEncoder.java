package com.mytube;

public class VideoEncoder implements IVideoEncoder{
    public void encode(Video video) {
        System.out.println("Encoding video...");
        System.out.println("Done!\n");
    }
}
