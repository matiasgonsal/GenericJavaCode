package com.Stacks;

public class Main {
    public static void main(String[] args) {
        //String operation = "((1 + 1))";
        //System.out.println(ExpressionEvaluation.isBalancedString(operation));

        Stack myStack = new Stack(1);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);

        System.out.println(myStack.peek());
        System.out.println(myStack.pop());





    }
}
