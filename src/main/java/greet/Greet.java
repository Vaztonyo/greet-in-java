package greet;

import java.util.HashMap;
import java.util.Scanner;
import java.util.SplittableRandom;

import greet.Languages;
import greet.Greeted;

import static greet.Greeted.greeted;

public class Greet {
    static int greetCount = 0;
    static String name;
    static String language;
    static String getCommand;
    static boolean run = true;

    public static HashMap<String, Integer> greetedNames = new HashMap<String, Integer>();
    private static String[] splitCommand;
    static String currentCommand;
    static Scanner greet = new Scanner(System.in);



    public static void main(String[] args) {

        int persCount = 0;


        System.out.println("\n***************************** !Welcome To My Greeting Program! *****************************");

        System.out.println("\n Enter a command, " +
                "\n Or Enter help for the help menu \n");

        while (run) {

            currentCommand = greet.nextLine();

            splitCommand = currentCommand.split(" ");

            getCommand = splitCommand[0];

            switch (getCommand.toLowerCase()) {

                case "greet":
                System.out.println("\nEnter one of the following Languages: French, " +
                        " English or " +
                        " Afrikaans\n");

                    System.out.println(splitCommand.length);

                if(splitCommand.length == 2) {
                    for (int i = 0; i < splitCommand.length; i++) {
                        getCommand = splitCommand[0];
                        name = splitCommand[1];
                    }
                }
                language = greet.nextLine().toUpperCase();

                if (language.isEmpty()){
                    System.out.println("Hi how are you " + name + "!");
                }else {
                    System.out.println("\n" + Languages.valueOf(language).getGreeting() + name + "!\n");
                }

                persCount++;
                if(!greetedNames.containsKey(name)){
                    greetedNames.put(name, persCount);
                    greetCount++;
                } else {
                    greetedNames.computeIfPresent(name, (k, v) -> v + 1);
                }

                persCount = 0;
                System.out.println("\n" + greetedNames + "\n");
                break;

                case "greeted":
                    greeted();
                    break;
                case "counter":
                    counter();
                    break;
                case "clear":
                    clear();
                    System.out.println("Cleared!");
                    break;
                case "exit":
                    exit();
                    break;
                case "help":
                    help();
                    break;
            }

        }


    }

    public static int counter(){
        greetCount = greetedNames.size();

        System.out.println("\n" + greetCount + "\n");
        return greetCount;
    }

    public static void clear() {
//        currentCommand = greet.nextLine();
         splitCommand = currentCommand.split(" ");

        if(splitCommand.length == 2) {
            for (int i = 0; i < splitCommand.length; i++) {
                getCommand = splitCommand[0];
                name = splitCommand[1];
            }
            greetedNames.remove(name);
        } else if (splitCommand.length ==1){
            greetedNames.clear();
        }
    }

    public static void help() {
        System.out.println("\nHelp Menu: \n" +
                "\nThe following are commands you are able to enter in this program: \n" +
                "\n1.greet + your/or anyone's name(this will prompt a language choice and display a greeting of the selected language), " +
                "\n2.greeted will display a list of all people that has been greeted and how many time each person has been greeted, " +
                "\n3.greeted + your/or anyone's name will display how many times you/that person have been greeted " +
                "\n4.counter displays a count of how many people has been greeted " +
                "\n5.clear deletes all people that were greeted and then resets the greet counter to 0 " +
                "\n6.clear + your/or anyone's name will delete the greet counter for that person and decrement the greet counter by 1 " +
                "\n7.exit exits the program " +
                "\n8.help shows a person an overview of all possible commands(which is this help menu)\n");
    }

    public static boolean exit() {
        System.out.println("\n**************************************** !Good Bye! ****************************************");
        return run =false;
    }

}
