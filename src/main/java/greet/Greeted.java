package greet;

import greet.Greet;

import java.util.HashMap;

import static greet.Greet.greetedNames;

public class Greeted{
    HashMap<String, Integer> greetedNames = new HashMap<String, Integer>();

    public void greetPerson(String[] splitCommand) {
        String name;
         String language;
         String getCommand;
        try {
            if(splitCommand.length == 2){
                name = splitCommand[1];
                language = "ENGLISH";
                System.out.println("\n" + Languages.valueOf(language).getGreeting() + name + "\n");
            } else if(splitCommand.length == 3) {
                name = splitCommand[1];
                language = splitCommand[2].toUpperCase();
                System.out.println("\n" + Languages.valueOf(language).getGreeting() + name + "\n");

            } else {
                System.out.println("\nInvalid\n");
                return;
            }
        } catch (IllegalArgumentException e) {
            name= splitCommand[1];
            System.out.println("\n" + Languages.valueOf("ENGLISH").getGreeting() + name + "\n");
        }
            name = splitCommand[1];
                if(!greetedNames.containsKey(name)){
                    greetedNames.put(name, 1);
                } else {
                    greetedNames.computeIfPresent(name, (k, v) -> v + 1);
                }

                System.out.println("\n" + greetedNames + "\n");
    }

    public void greeted() {
        String myString = "These are the names that were greeted: ";

        System.out.println("\n" + myString + "\n");


        for (String name: greetedNames.keySet()){
            String key = name.toString();
            String value = greetedNames.get(name).toString();
            System.out.println("\nName: " + key + " Times Greeted: " + value + "\n");
        }
    }
}
