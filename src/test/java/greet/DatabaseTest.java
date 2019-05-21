package greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {

    GreetInterface db = new DataBase();

    @BeforeEach
    public void setupTests() throws SQLException, ClassNotFoundException {
        db.clear("");
    }

    @Test
    public void shouldTestGreetingInDb() throws SQLException, ClassNotFoundException {
        assertEquals("\nBonjour, comment vas-tu Mike\n" ,db.greetPerson("Mike", "french".toUpperCase()));
    }

    @Test
    public void shouldTestGreetedInDb() throws SQLException, ClassNotFoundException {
        db.greetPerson("Boosie", "english".toUpperCase());

        assertEquals("\nName: Boosie, Times Greeted: 1\n", db.greeted("Boosie"));
    }

    @Test
    public void shouldTestCounterInDb() throws SQLException, ClassNotFoundException {
        db.greetPerson("Boosie", "english".toUpperCase());
        db.greetPerson("Tony", "english".toUpperCase());

        assertEquals("Total number of people greeted: 2\n", db.counter());

        db.greetPerson("Gillie", "afrikaans".toUpperCase());

        assertEquals("Total number of people greeted: 3\n", db.counter());
    }

    @Test
    public void shouldTestClearOneNameInDb() throws SQLException, ClassNotFoundException {
        db.greetPerson("Boosie", "english".toUpperCase());
        db.greetPerson("Tony", "english".toUpperCase());

        assertEquals("\nRemoved: Tony\n", db.clear("Tony"));
    }

    @Test
    public void shouldTestClearAllInDb() throws SQLException, ClassNotFoundException {
        db.greetPerson("Boosie", "english".toUpperCase());
        db.greetPerson("Tony", "english".toUpperCase());

        assertEquals("\nCleared!\n", db.clear(""));
        assertEquals("Total number of people greeted: 0\n", db.counter());
    }
}
