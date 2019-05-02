package greet.methods;

import greet.DataBase;

import java.sql.SQLException;

public class Clear {

DataBase db = new DataBase();

    public void clear(String[] splitCommand) throws SQLException, ClassNotFoundException {
        String name = null;

        if(splitCommand.length == 2) {
            for (int i = 0; i < splitCommand.length; i++) {
                name = splitCommand[1];
            }
            db.deleteOneName(name);
            System.out.println("\nRemoved: " + name + "\n");
        } else if (splitCommand.length ==1){
            db.deleteData();
            System.out.println("\nCleared!\n");
        }
    }
}
