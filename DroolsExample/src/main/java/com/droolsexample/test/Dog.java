package com.droolsexample.test;

public class Dog {
    private String name;
    private String breed;
    private String age;
    private int age_expectancy;
    private boolean longLife;

    public Dog(String name, String breed, String age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getAge_expectancy() {
        return age_expectancy;
    }

    public void setAge_expectancy(int age_expectancy) {
        this.age_expectancy = age_expectancy;
    }

    public boolean isLongLife() {
        return longLife;
    }

    public void setLongLife(boolean longLife) {
        this.longLife = longLife;
    }
}
