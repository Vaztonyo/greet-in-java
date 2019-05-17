package greet;

import greet.commands.CommandExtractor;

import java.sql.SQLException;
import java.util.Scanner;
import  greet.commands.CommandProcessor;


public class Greet {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner greetInput = new Scanner(System.in);
        System.out.println("\n***************************** !Welcome To My Greeting Program! *****************************");


        boolean run = true;

        while (run) {

            System.out.println("\n Enter a command, " +
                    "\n Or Enter help for the help menu \n");
            String currentCommand = greetInput.nextLine();
            if (currentCommand.equals("exit")){
                run = false;
                System.out.println("\n**************************************** !Good Bye! ****************************************");
                break;
            }

                new CommandProcessor(new CommandExtractor(currentCommand)).execute();
        }
    }
}
