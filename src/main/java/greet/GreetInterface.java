package greet;

import java.sql.SQLException;

public interface GreetInterface {
    String greetPerson(String name, String language) throws SQLException, ClassNotFoundException;
    String greeted(String splitCommand) throws SQLException, ClassNotFoundException;
    String counter() throws SQLException, ClassNotFoundException;
    String clear(String userName) throws SQLException, ClassNotFoundException;

}
