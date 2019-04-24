package greet;

import greet.methods.*;

import java.util.Scanner;


public class Greet {
    static String getCommand;
    static boolean run = true;

    private static String[] splitCommand;
    static String currentCommand;
    static Scanner greet = new Scanner(System.in);

    static Greeted greeted = new Greeted();

    static Clear clear = new Clear();
    static Help help = new Help();
    static Counter count = new Counter();


    public static void main(String[] args) {



        System.out.println("\n***************************** !Welcome To My Greeting Program! *****************************");

        System.out.println("\n Enter a command, " +
                "\n Or Enter help for the help menu \n");

        while (run) {

            currentCommand = greet.nextLine();

            splitCommand = currentCommand.split(" ");

            getCommand = splitCommand[0];

            switch (getCommand.toLowerCase()) {

                case "greet":
                    System.out.println(splitCommand.length);
                    getCommand = splitCommand[0];
                    greeted.greetPerson(splitCommand);

                break;

                case "greeted":
                    greeted.greeted(splitCommand);
                    break;
                case "counter":
                    count.counter();
                    break;
                case "clear":
                    clear.clear(splitCommand);
                    break;
                case "exit":
                    exit();
                    break;
                case "help":
                    help.help();
                    break;
                    default:
                        System.out.println("\nPlease Enter a Valid Command(enter help to see list of possible commands)\n");
            }

        }

    }


    public static boolean exit() {
        System.out.println("\n**************************************** !Good Bye! ****************************************");
        return run =false;
    }

}
