package greet;

import greet.methods.Counter;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetTest {


    @Test
    public void shouldGreetUserAndCountTheNumOfNamesGreeted() throws SQLException, ClassNotFoundException {
        String[] splitCommand = new String[]{"greet", "Tony", "english"};

        Greeted greeted = new Greeted();

        Counter count = new Counter();
        greeted.greetPerson(splitCommand);

//        assertEquals(1, count.counter());

        splitCommand = new String[]{"greet", "Mike", "french"};
        greeted.greetPerson(splitCommand);

//        assertEquals(2, count.counter());

        splitCommand = new String[]{"greet", "Vaz", "afrikaans"};
        greeted.greetPerson(splitCommand);

        assertEquals(4, count.counter());

    }

}
