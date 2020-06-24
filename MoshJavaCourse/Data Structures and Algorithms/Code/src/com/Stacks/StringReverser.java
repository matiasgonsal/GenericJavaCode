package com.Stacks;

import java.util.Stack;

public class StringReverser {

    public static String reverse (String input){
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()){
            stack.push(ch);
        }

        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.empty()){
            stringBuffer.append(stack.pop());
        }

        return stringBuffer.toString();
    }
}
