package greet.commands;

import greet.DataBase;
import greet.GreetInterface;
import greet.Greeted;
import greet.methods.*;

import java.sql.SQLException;


public class CommandProcessor {

    CommandExtractor commandX;

    public CommandProcessor(CommandExtractor commandX){
        this.commandX = commandX;
    }

    public String getCommandX() {
        return commandX.getCommand();
    }
    public String getCommandXName() {
        return commandX.getName();
    }
    public String getCommandXLang() {
        return commandX.getLang();
    }

     GreetInterface db = new DataBase();
//    GreetInterface db = new Greeted();

    public String execute() throws SQLException, ClassNotFoundException {
         Help help = new Help();

        switch (getCommandX().toLowerCase()) {
            case "greet":
                return db.greetPerson(getCommandXName(), getCommandXLang());
            case "greeted":
                return db.greeted(getCommandXName());
            case "counter":
                return db.counter();
            case "clear":
                return db.clear(getCommandXName());
            case "help":
                return help.help();
            default:
                System.out.println("\nPlease Enter a Valid Command(enter help to see list of possible commands)\n");
                return  "\nPlease Enter a Valid Command(enter help to see list of possible commands)\n";
        }

    }

}
