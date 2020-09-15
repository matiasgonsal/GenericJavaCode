package com.droolsexample.test;
import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.rule.Package;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, DroolsParserException {

        //Read rules files
        PackageBuilder packageBuilder = new PackageBuilder();
        String ruleFile = "/drools/life_expectancy.drl";
        String ruleFile2 = "/drools/long_life.drl";

        Reader reader = getRuleFileAsReader(ruleFile);
        packageBuilder.addPackageFromDrl(reader);

        reader = getRuleFileAsReader(ruleFile2);
        packageBuilder.addPackageFromDrl(reader);

        //Add rules to working memory
        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        Package rulesPackage = packageBuilder.getPackage();
        ruleBase.addPackage(rulesPackage);


        WorkingMemory workingMemory = ruleBase.newStatefulSession();


        String dogBreed = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your dog breed: ");
        dogBreed = scanner.nextLine();

        while (!dogBreed.equals("exit")){
            //Creating the POJO object to be used as Facts in drools.
            Dog dog = new Dog("Astor", dogBreed, "7");
            System.out.println("Age expectancy before rules: " + dog.getAge_expectancy());
            System.out.println("Long life before rules: " + dog.isLongLife());

            //Insert POJO to working memory
            workingMemory.insert(dog);

            workingMemory.fireAllRules();
            System.out.println("Age expectancy after rules: " + dog.getAge_expectancy());
            System.out.println("Long life after rules: " + dog.isLongLife());


            System.out.print("Enter your dog breed: ");
            dogBreed = scanner.nextLine();
        }
    }
    private static Reader getRuleFileAsReader(String ruleFile) {
        InputStream resourceAsStream = Main.class.getResourceAsStream(ruleFile);
        return new InputStreamReader(resourceAsStream);
    }
}
