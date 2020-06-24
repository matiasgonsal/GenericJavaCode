package com.streams;

public class Movie {
    private String name;
    private int likes;

    public Movie(String name, int likes){
        this.name = name;
        this.likes = likes;
    }

    public int getLikes (){
        return this.likes;
    }
    public String getName() { return name; }
}
