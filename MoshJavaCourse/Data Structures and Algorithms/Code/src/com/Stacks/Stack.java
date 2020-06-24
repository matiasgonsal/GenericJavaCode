package com.Stacks;

public class Stack {
    private int[] stack;
    private int currentItem;

    public Stack (int length){
        this.currentItem = 0;
        this.stack = new int[length];
    }

    public void push (int item){
        if (isFull()){
            int[] auxStack = new int[this.stack.length * 2];
            for (int i = 0; i < stack.length; i++){
                auxStack[i] = this.stack[i];
            }
            this.stack = auxStack;
        }
        this.stack[currentItem++] = item;
    }

    public int pop (){
        if (isEmpty()){
            return -1;
        }
        return this.stack[--this.currentItem];
    }

    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return this.stack[this.currentItem - 1];
    }

    public boolean isEmpty(){
        return this.currentItem == 0;
    }

    private boolean isFull (){
        return this.currentItem == this.stack.length;
    }
}
