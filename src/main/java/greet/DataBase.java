package greet;

import greet.methods.DbMethods;

import java.sql.*;

public class DataBase implements GreetInterface {
   DbMethods db = new DbMethods();

    @Override
    public String greetPerson(String name, String language) throws SQLException, ClassNotFoundException {
        String greeting;

        db.addToDataBase(name, 1);
        try {
            greeting = "\n" + Languages.valueOf(language).getGreeting() + name + "\n";
        } catch (IllegalArgumentException e){
            greeting = "\n" + Languages.valueOf("ENGLISH").getGreeting() + name + "\n";
        }

        return greeting;
    }

    @Override
    public String greeted(String userName) throws SQLException, ClassNotFoundException {
        String message = "";
        String value = "";
        String key = "";

        try{
            if(userName.isEmpty()) {

                for (String name: db.getAllDataInDB().keySet()){
                    key = name;
                    value = db.getAllDataInDB().get(name).toString();
                    message += "\nName: " + key + ", Times Greeted: " + value + "\n";
                }
            }
            else {
                key = userName;
                value = db.getAllDataInDB().get(userName).toString();
                message = "\nName: " + key + ", Times Greeted: " + value + "\n";
            }
        } catch (NullPointerException e){
            if (userName.isEmpty()){
                message = "Nobody has been greeted yet";
            } else {
                message = "\nSorry " + userName + " you have not been greeted yet.\n";
            }
        }

        return message;
    }

    @Override
    public String clear(String userName) throws SQLException, ClassNotFoundException {
        String clearMsg;

        if(userName.isEmpty()) {
            db.deleteData();
            clearMsg = "\nCleared!\n";
        } else{
            db.deleteOneName(userName);
            clearMsg = "\nRemoved: " + userName + "\n";
        }
        return clearMsg;
    }

    @Override
    public String counter() throws SQLException, ClassNotFoundException {
        int greetCount;
        greetCount = db.countDataInDB();
        return ("Total number of people greeted: " + greetCount + "\n");
    }

}
