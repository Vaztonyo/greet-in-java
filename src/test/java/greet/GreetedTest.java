package greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetedTest {

    GreetInterface greet = new Greeted();

    @BeforeEach
    public void setupTests() throws SQLException, ClassNotFoundException {
        greet.clear("");
    }

    @Test
    public void shouldTestGreetingForMap() throws SQLException, ClassNotFoundException {
        assertEquals("\nMolo Wale\n" , greet.greetPerson("Wale", "xhosa".toUpperCase()));
    }

    @Test
    public void shouldTestGreetedForMap() throws SQLException, ClassNotFoundException {
        greet.greetPerson("Wale", "english".toUpperCase());

        assertEquals("\nName: Wale, Times Greeted: 1\n", greet.greeted("Wale"));

        greet.greetPerson("Kevin", "english".toUpperCase());

        assertEquals("\nName: Kevin, Times Greeted: 1\n", greet.greeted("Kevin"));
    }

    @Test
    public void shouldTestCounterForMap() throws SQLException, ClassNotFoundException {
        greet.greetPerson("Wale", "english".toUpperCase());

        assertEquals("Number of people that were greeted: 1", greet.counter());

        greet.greetPerson("Kevin", "english".toUpperCase());

        assertEquals("Number of people that were greeted: 2", greet.counter());
    }

    @Test
    public void shouldTestClearOneNameForMap() throws SQLException, ClassNotFoundException {
        greet.greetPerson("Boosie", "english".toUpperCase());
        greet.greetPerson("Wale", "english".toUpperCase());

        assertEquals("Number of people that were greeted: 2", greet.counter());
        assertEquals("\nRemoved: Wale\n", greet.clear("Wale"));
        assertEquals("Number of people that were greeted: 1", greet.counter());
    }

    @Test
    public void shouldTestClearAllForMap() throws SQLException, ClassNotFoundException {
        greet.greetPerson("Wale", "english".toUpperCase());
        greet.greetPerson("Kevin", "english".toUpperCase());

        assertEquals("Number of people that were greeted: 2", greet.counter());
        assertEquals("\nCleared!\n", greet.clear(""));
        assertEquals("Number of people that were greeted: 0", greet.counter());
    }

}
