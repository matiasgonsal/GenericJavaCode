package com.streams;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class StreamsMain {
    public static void main(String[] args){
        ArrayList<Movie> movies = new ArrayList();
        movies.add(new Movie("The Lord Of The Rings", 10));
        movies.add(new Movie("Fast And Furious", 20));
        movies.add(new Movie("Happy Feet", 35));

        //We need to count the numbers of movies that have more than 15 likes.
        int counter = 0;
        for (Movie movie : movies){
            if (movie.getLikes() > 15){
                counter ++;
            }
        }
        System.out.println("Number of movies with more than ten likes: " + counter);

        //The same result with Streams.
        counter = (int) movies.stream()
                              .filter(movie -> movie.getLikes() > 15)
                              .count();
        System.out.println("Number of movies with more than ten likes (Streams): " + counter);

        //MAP operator
        //We use the MAP operator to transform each object of an stream to another object:
        //Imagine that we don't need the likes of the Movies, but we only need the names:
        //In this example we are transforming each movie object of the stream to a String.
        System.out.println("--------------------------------------------");
        System.out.println("Streams MAP Operator: ");
        movies.stream()
                .map(movie -> movie.getName())
                .forEach(name -> System.out.println(name));
        System.out.println("--------------------------------------------");

    }
}
