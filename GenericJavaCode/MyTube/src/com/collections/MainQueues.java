package com.collections;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class MainQueues {

    public static void main(String[] args) {

        //ArrayDeque is a Queue that allows to add items from both sides of the queue.
        Queue<Integer> myQueue = new ArrayDeque<>();

        myQueue.add(5);
        myQueue.add(1);
        myQueue.add(10);

        System.out.println(myQueue.peek()); //The peek method grab the first element without taking it out from the Queue.
        System.out.println(myQueue.poll()); //The poll method take out the first element.
        System.out.println(myQueue);

        //----------------------------------------------------------

        //PriorityQueue is a queue that allows to add items and order it by a priority.
        Queue<Integer> myPriorityQueue = new PriorityQueue<>();


        myPriorityQueue.add(5);
        myPriorityQueue.add(1);
        myPriorityQueue.add(10);

        System.out.println(myPriorityQueue);





    }
}
