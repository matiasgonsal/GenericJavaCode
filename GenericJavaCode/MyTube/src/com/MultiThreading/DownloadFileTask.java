package com.MultiThreading;

public class DownloadFileTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Downloading file ... Using Thread -> " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Download Completed Using Thread -> " + Thread.currentThread().getName());

    }
}
