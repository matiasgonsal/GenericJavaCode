package com.collections;

import java.util.ArrayList;
import java.util.Collections;

public class MainCollections {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList();

        numbers.add(10);
        numbers.add(11);
        numbers.add(9);
        numbers.add(5);
        numbers.add(1);

        //Both of the next method could be used to sort a list of objects.
        Collections.sort(numbers);
        numbers.sort(Integer::compareTo);

        for (Integer number : numbers){
            System.out.println(number);
        }

    }
}
