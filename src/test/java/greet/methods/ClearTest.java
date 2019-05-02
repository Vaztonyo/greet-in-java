package greet.methods;
import greet.Greeted;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClearTest {

    @Test
    public void shouldBeAbleToClearAName() throws SQLException, ClassNotFoundException {
        String[] splitCommand = {"greet", "Tony", "english"};

        Greeted greeted = new Greeted();
        Clear clear = new Clear();
        Counter count = new Counter();

        greeted.greetPerson(splitCommand);
        assertEquals(1, count.counter());

        splitCommand = new String[]{"greet", "Mike", "french"};
        greeted.greetPerson(splitCommand);
        assertEquals(2, count.counter());

        splitCommand = new String[]{"clear", "Tony"};

        clear.clear(splitCommand);
        assertEquals(1, count.counter());
    }

    @Test
    public void shouldBeAbleToClearAllNames() throws SQLException, ClassNotFoundException {
        String[] splitCommand = {"greet", "Tony", "english"};

        Greeted greeted = new Greeted();
        Clear clear = new Clear();
        Counter count = new Counter();

        greeted.greetPerson(splitCommand);
        assertEquals(1, count.counter());

        splitCommand = new String[]{"greet", "Mike", "french"};
        greeted.greetPerson(splitCommand);
        assertEquals(2, count.counter());

        splitCommand = new String[]{"clear"};

        clear.clear(splitCommand);
        assertEquals(0, count.counter());
    }

}
