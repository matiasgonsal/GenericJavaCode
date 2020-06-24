package com.MultiThreading;

import java.util.ArrayList;

public class MultiThreadingMain {
    public static void main(String[] args){

        //Print the number of threads used by this application:
        System.out.println(Thread.activeCount() + " -> Main Thread Running the Main Method + Garbage Collector Thread");
        //Print the number of processor in this machine
        System.out.println(Runtime.getRuntime().availableProcessors() + " -> Numbers of available processors");


        //Implement multiThread example:
        System.out.println("-----------------------------------------------------");
        System.out.println("Current Thread From Main -> " + Thread.currentThread().getName());

        DownloadFileTask downloadFileTask = new DownloadFileTask();
        downloadFileTask.run(); //Use the same thread as the Main

        ArrayList<Thread> ThreadList = new ArrayList();
        for (int i=0; i < 10; i++){
            Thread thread = new Thread(downloadFileTask); //Open a new thread
            thread.start(); //Execute the same task as before but in a new Thread.
            ThreadList.add(thread); //We just use this list for the join method called below.
        }

        //We need to stop the current Thread (Main) to wait for the previous Downloading Thread Completion
        // to start the Scan.. We can do that using join():
        for (Thread thread : ThreadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Scanning downloaded files...");

    }
}
