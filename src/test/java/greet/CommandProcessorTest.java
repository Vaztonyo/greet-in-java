package greet;

import greet.commands.CommandExtractor;
import greet.commands.CommandProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTest {

    CommandExtractor xtractor;
    CommandProcessor xProcessor;

    @BeforeEach
    public void setupTests() throws SQLException, ClassNotFoundException {
        xtractor = new CommandExtractor("clear");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);

        xProcessor.execute();

        xtractor = new CommandExtractor("greet Tony");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);

        xProcessor.execute();
    }

    @Test
    public void shouldTestGreetedCommand() throws SQLException, ClassNotFoundException {
        xtractor = new CommandExtractor("greeted");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);

        assertEquals("\nName: Tony, Times Greeted: 1\n", xProcessor.execute());
    }

    @Test
    public void shouldTestGreetCommand() throws SQLException, ClassNotFoundException {
        xtractor = new CommandExtractor("greet tyler xhosa");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);

        assertEquals("\nMolo Tyler\n", xProcessor.execute());
    }

    @Test
    public void shouldTestCounterCommand() throws SQLException, ClassNotFoundException {
        xtractor = new CommandExtractor("greet tyler");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);
        xProcessor.execute();

        xtractor = new CommandExtractor("counter");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);

        assertEquals("Total number of people greeted: 2\n", xProcessor.execute());
    }

    @Test
    public void shouldBeAbleAddNewNamesInDb() throws SQLException, ClassNotFoundException {
        xtractor = new CommandExtractor("counter");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);

        assertEquals("Total number of people greeted: 1\n", xProcessor.execute());


        xtractor = new CommandExtractor("greet Mike");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);
        xProcessor.execute();

        xtractor = new CommandExtractor("counter");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);

        assertEquals("Total number of people greeted: 2\n", xProcessor.execute());
    }

    @Test
    public void shouldTestClearCommand() throws SQLException, ClassNotFoundException {
        xtractor = new CommandExtractor("clear");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);

        assertEquals("\nCleared!\n", xProcessor.execute());

        xtractor = new CommandExtractor("counter");
        xProcessor = new CommandProcessor(new DataBase(),xtractor);
        assertEquals("Total number of people greeted: 0\n", xProcessor.execute());

    }
}
