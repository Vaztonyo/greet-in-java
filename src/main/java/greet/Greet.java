package greet;

import java.util.HashMap;
import java.util.Scanner;

public class Greet {

    public HashMap<String, Integer> greetedNames= new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner greet = new Scanner(System.in);
        int greetCount = 0;

        while (greetCount >= 0) {
            System.out.println("\n************************* !Welcome To My Greeting Program! *************************");

            System.out.println("  Enter a command " +
                    "\n  Or Enter help for the help menu \n");


            String name = greet.nextLine();

            System.out.println("\nEnter one of the following Languages: French, " +
                    " English or " +
                    " Afrikaans");

            String language = greet.nextLine();

            if (language.toLowerCase().equals("english")) {
                System.out.println("Hi, how are you " + name + "?");
            } else if (language.toLowerCase().equals("afrikaans")) {
                System.out.println("Hallo hoe gaan dit met jou " + name + "?");
            } else if (language.toLowerCase().equals("french")) {
                System.out.println("Salut " + name + " comment vas-tu?");
            } else {
                System.out.println("Hi, how are you " + name + "?");
            }
            System.out.println("\n************************************************************************************\n");
        }


    }

}
