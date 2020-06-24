package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainSets {
    public static void main(String[] args) {
        ArrayList<String> letters = new ArrayList();
        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("c");

        //The set removes the repeated values...
        Set lettersSet = new HashSet(letters);
        System.out.println(lettersSet);

        System.out.println("---------------------------------");

        Set set1 = new HashSet(Arrays.asList("a", "b", "c"));
        Set set2 = new HashSet(Arrays.asList("c", "d", "e"));

        //Set operations:

        //Union
        set1.addAll(set2);
        System.out.println("Union of sets: " + set1);

        //Intersection
        set1.retainAll(set2);
        System.out.println("Intersection of sets: " + set1);

        //Difference
        set1.removeAll(set2);
        System.out.println("Difference of sets: " + set1);


    }
}
