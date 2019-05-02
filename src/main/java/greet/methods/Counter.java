package greet.methods;
import greet.DataBase;

import java.sql.SQLException;

public class Counter {
    int greetCount;
    DataBase db = new DataBase();

    public int counter() throws SQLException, ClassNotFoundException {
        greetCount = db.countDataInDB();
        System.out.println("\nTotal number of people greeted: " + greetCount + "\n");
        return greetCount;
    }
}
