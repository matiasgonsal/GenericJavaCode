package com.Stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExpressionEvaluation {
    private static final List<Character> openingCharacters = Arrays.asList('(', '<', '[', '{');
    private static final List<Character> closingCharacters = Arrays.asList(')', '>', ']', '}');

    public static boolean isBalancedString (String input){
        Stack<Character> stack = new Stack<>();
        char openingCharacter;

        for (char ch : input.toCharArray()){
            if (isOpeningCharacter(ch)){
                stack.push(ch);
            }
            if (isClosingCharacter(ch)){
                if (stack.empty())
                    return false;
                openingCharacter = stack.pop();
                if (!isBalancedOperation(openingCharacter, ch)){
                    return false;
                }
            }
        }

        if (!stack.empty()){
            return false;
        }
        return true;
    }

    private static boolean isOpeningCharacter(char input){
        return openingCharacters.contains(input);
    }

    private static boolean isClosingCharacter(char input){
        return closingCharacters.contains(input);
    }

    private static boolean isBalancedOperation(char openingCharacter, char closingCharacter){
        return openingCharacters.indexOf(openingCharacter) == closingCharacters.indexOf(closingCharacter);
    }
}
