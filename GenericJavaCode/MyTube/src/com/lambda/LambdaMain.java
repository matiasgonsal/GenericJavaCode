package com.lambda;

public class LambdaMain {
    public static void main(String[] args){
        //The ConsolePrinter Class implements the Printer interface
        ConsolePrinter consolePrinter = new ConsolePrinter();
        greet (consolePrinter);

        //Another way to do the code which is above is to use the Anonymous inner classes.
        //We don't need to declare a java class which implements an interface and use that object to call the greet method.
        //We can implement the interface method inside the greet call ->

        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message + " Implemented in Anonymous inner Class");
            }
        });

        //Another way to do this is implementing Lambda Expressions:
        greet((String message) -> {
            System.out.println(message + " From a Lambda Implementation");
        });
    }

    //The greet method is developed against the Printer interface. We could pass any Object class which implements the Printer interface.
    public static void greet (Printer printer){
        printer.print("Hello World From Greet Function");
    }
}
