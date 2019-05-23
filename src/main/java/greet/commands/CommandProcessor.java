package greet.commands;

import greet.DataBase;
import greet.GreetInterface;
import greet.Greeted;
import greet.methods.*;

import java.sql.SQLException;


public class CommandProcessor {

    CommandExtractor commandX;
    GreetInterface db;

    public CommandProcessor(GreetInterface db,CommandExtractor commandX){
        this.commandX = commandX;
        this.db = db;
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
                return  "\nPlease Enter a Valid Command(enter help to see list of possible commands)\n";
        }

    }

}
