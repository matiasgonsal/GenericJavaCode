package com.arrays;

import java.util.Arrays;

public class Array {
    private int array[];
    private int currentIndex;

    public Array (int length){
        this.array = new int[length];
        this.currentIndex = -1;
    }


    public void insert (int item){
        this.currentIndex ++;
        if (this.currentIndex == this.array.length){
            int auxArray[] = new int[this.array.length + 1];
            for (int i = 0; i < this.array.length; i++){
                auxArray[i] = this.array[i];
            }
            this.array = auxArray;
        }
        this.array[currentIndex] = item;
    }

    public int indexOf (int item){
        for (int i=0; i < this.array.length; i++){
            if (this.array[i] == item){
                return i;
            }
        }
        return -1;
    }

    public void removeAt (int index){
        if (index < 0 || index > currentIndex){
            throw new IllegalArgumentException();
        }

        int auxArray[] = new int [this.array.length - 1];
        for (int i=0; i < auxArray.length; i++){
            if (i >= index){
                auxArray[i] = this.array[i+1];
            }
            else{
                auxArray[i] = this.array[i];
            }
        }
        this.array = auxArray;
        this.currentIndex --;
    }

    public int max(){
        int max = 0;
        for (int item : this.array){
            if (item > max){
                max = item;
            }
        }
        return max;
    }

    public void print(){
        System.out.println(Arrays.toString(this.array));
    }

}
