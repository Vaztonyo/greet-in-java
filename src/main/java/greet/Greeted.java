package greet;

import greet.Greet;

import static greet.Greet.greetedNames;

public class Greeted{

    public void greeted() {
        String myString = "These are the names that were greeted";

        System.out.println("\n" + myString);

        greetedNames.keySet().forEach(i ->
                System.out.println(i)
        );


    }
}
