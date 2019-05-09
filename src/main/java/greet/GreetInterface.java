package greet;

import java.sql.SQLException;

public interface GreetInterface {
    void greetPerson(String[] splitCommand) throws SQLException, ClassNotFoundException;
    void greeted(String[] splitCommand) throws SQLException, ClassNotFoundException;

}
