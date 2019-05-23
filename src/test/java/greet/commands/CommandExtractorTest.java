package greet.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandExtractorTest {

    CommandExtractor commandX = new CommandExtractor("greet Tony english");

    @Test
    public void shouldBeAbleToTakeGreetCommand(){
        CommandExtractor commandExtractor = new CommandExtractor("counter");
        assertEquals("counter", commandExtractor.getCommand());
        assertEquals("ENGLISH", commandExtractor.getLang());
        assertEquals("", commandExtractor.getName());
    }

    @Test
    public  void shouldBeAbleTotakeGreetWithName(){
        CommandExtractor commandExtractor = new CommandExtractor("greet Tony");
        assertEquals("greet Tony", commandExtractor.getCommand() + " " + commandExtractor.getName());
    }
    @Test
    public void shouldBeableToGetCommand(){


        assertEquals("greet", commandX.getCommand());
    }

    @Test
    public void shouldBeableToGetName(){

        assertEquals("Tony", commandX.getName());
    }

    @Test
    public void shouldBeableToGetLanguage(){

        assertEquals("ENGLISH", commandX.getLang());
    }
}
