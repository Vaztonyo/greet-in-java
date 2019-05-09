package greet;

import greet.methods.Counter;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {

    Greeted greeted = new Greeted();


    @Test
    public void shouldGreetUserAndCountTheNumOfNamesGreeted() throws SQLException, ClassNotFoundException {
        String[] splitCommand = new String[]{"greet", "Tony", "english"};

        Counter count = new Counter();
        greeted.greetPerson(splitCommand);

        assertEquals(1, count.counter());
    }

    @Test
    public void shouldAddNewUserAndUpdateTheNumOfNamesGreeted() throws SQLException, ClassNotFoundException {
        String[] splitCommand;

        Counter count = new Counter();

        splitCommand = new String[]{"greet", "Toby", "afrikaans"};
        greeted.greetPerson(splitCommand);

        assertEquals(2, count.counter());
    }

    @Test
    public void shouldGetUserAndHowMuchTimesThatUserHaveBeenGreeted() throws SQLException, ClassNotFoundException {
        String[] splitCommand = new String[]{"greeted", "Tony"};
        greeted.greeted(splitCommand);
    }

    @Test
    public void shouldGetAllUsersAndHowMuchTimesTheyHaveBeenGreeted() throws SQLException, ClassNotFoundException {
        String[] splitCommand = new String[]{"greeted"};
        greeted.greeted(splitCommand);
    }
}
