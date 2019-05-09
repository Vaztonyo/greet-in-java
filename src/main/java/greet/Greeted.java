package greet;

import java.sql.SQLException;

public class Greeted implements GreetInterface {

    DataBase db = new DataBase();

    @Override
    public void greetPerson(String[] splitCommand) throws SQLException, ClassNotFoundException {
        String name;
         String language;
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
            db.addToDataBase(name, 1);
    }

    @Override
    public void greeted(String[] splitCommand) throws SQLException, ClassNotFoundException {
        try{
            if(splitCommand.length == 2){
                String name;
                name = splitCommand[1];
                String key = name;
                String value = db.getAllDataInDB().get(name).toString();
                System.out.println("\nName: " + key + ", Times Greeted: " + value + "\n");
            } else {
                String myString = "These are the names that were greeted: ";

                System.out.println("\n" + myString + "\n");

                for (String name: db.getAllDataInDB().keySet()){
                    String key = name;
                    String value = db.getAllDataInDB().get(name).toString();
                    System.out.println("\nName: " + key + ", Times Greeted: " + value + "\n");
                }
            }
        } catch (NullPointerException e){
            String name = splitCommand[1];
            System.out.println("\nSorry " + name + " you have not been greeted yet.\n");
        }

    }

}
