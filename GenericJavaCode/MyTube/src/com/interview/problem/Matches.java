package com.interview.problem;

import java.util.ArrayList;
import java.util.List;

public class Matches {
    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> weekendMatches = new ArrayList<>();
        ArrayList<Integer> match1 = new ArrayList<>();
        ArrayList<Integer> match2 = new ArrayList<>();
        ArrayList<Integer> match3 = new ArrayList<>();

        //Match 1:
        match1.add(10);
        match1.add(15);

        //Match 2:
        match2.add(15);
        match2.add(20);

        //Match 3:
        match3.add(15);
        match3.add(30);

        weekendMatches.add(match1);
        weekendMatches.add(match2);
        weekendMatches.add(match3);

        System.out.println(weekendMatches);
        System.out.println(canWatchAllMatches(weekendMatches));

    }


    static boolean canWatchAllMatches (ArrayList matches){
        Integer currentEndTime = 0;
        ArrayList<Integer> currentMatch;

        for (int i=0; i < matches.size(); i++){
            currentMatch = (ArrayList<Integer>) matches.get(i);
            if (currentMatch.get(0) >= currentEndTime){
                currentEndTime = currentMatch.get(1);
            }
            else{
                return false;
            }
        }

        return true;
    }
}
