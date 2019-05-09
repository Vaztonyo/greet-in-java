package greet.methods;
import greet.Greeted;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClearTest {

    @BeforeEach
    public void setup() throws SQLException, ClassNotFoundException {
        Greeted greet = new Greeted();

        String[] person1 = new String[]{"greet", "Toby", "afrikaans"};
        
        greet.greetPerson(person1);

        String[] person2 = new String[]{"greet", "Tony", "french"};

        greet.greetPerson(person2);
    }

    @Test
    public void shouldBeAbleToClearAGreetedName() throws SQLException, ClassNotFoundException {
        String[] splitCommand ;

        Clear clear = new Clear();
        Counter count = new Counter();


        splitCommand = new String[]{"clear", "Toby"};

        clear.clear(splitCommand);
        assertEquals(1, count.counter());
    }

    @Test
    public void shouldBeAbleToClearAllNamesInDB() throws SQLException, ClassNotFoundException {
        String[] splitCommand;

        Clear clear = new Clear();
        Counter count = new Counter();

        splitCommand = new String[]{"clear"};

        clear.clear(splitCommand);
        assertEquals(0, count.counter());
    }

}
