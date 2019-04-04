package greet;

import java.util.HashMap;
import java.util.Scanner;

import greet.Languages;
import greet.Greeted;

public class Greet {
    static int greetCount = 0;
    static String name;
    static String language;
    static String greetCommand;

    public static HashMap<String, Integer> greetedNames = new HashMap<String, Integer>();


    public static void main(String[] args) {
        Scanner greet = new Scanner(System.in);

        String getCommand;
        int persCount = 0;

        while (greetCount >= 0) {
            System.out.println("\n************************** !Welcome To My Greeting Program! **************************");

            System.out.println("\n Enter a command, " +
                    "\n Or Enter help for the help menu \n");


            getCommand = greet.nextLine();

            String splitCommand[] = getCommand.split(" ");

            for (int i = 0; i < splitCommand.length; i++) {
                greetCommand = splitCommand[0];
                name = splitCommand[1];
            }

            if (greetCommand.toLowerCase().equals("greet")) {
                System.out.println("\nEnter one of the following Languages: French, " +
                        " English or " +
                        " Afrikaans\n");

                language = greet.nextLine().toUpperCase();

                if (language == ""){
                    System.out.println("\nHello, how are you " + name + "!\n");
                }else {
                    System.out.println("\n" + Languages.valueOf(language).getGreeting() + name + "!\n");
                }

                persCount++;

                greetedNames.put(name, persCount);

                persCount = 0;

                System.out.println(greetedNames);
//            if (language.toLowerCase().equals("english")) {
//                System.out.println("Hi, how are you " + name + "?");
//            } else if (language.toLowerCase().equals("afrikaans")) {
//                System.out.println("Hallo hoe gaan dit met jou " + name + "?");
//            } else if (language.toLowerCase().equals("french")) {
//                System.out.println("Salut " + name + " comment vas-tu?");
//            } else {
//                System.out.println("Hi, how are you " + name + "?");
//            }
            }
        }


    }

    public int counter(){
        greetCount = greetedNames.size();

        System.out.println("\n" + greetCount);
        return greetCount;
    }

    public void clear() {
        greetedNames.clear();
    }

    public void exit(int exitCode) {
        System.exit(exitCode);
    }

}
