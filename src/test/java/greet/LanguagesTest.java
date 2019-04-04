package greet;

import greet.Languages;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LanguagesTest {

    @Test
    public void shouldBeAbleToGetLanguage() {
        Languages lang;

        lang = Languages.ENGLISH;

        assertEquals("english".toUpperCase(), lang.toString());

        lang = Languages.AFRIKAANS;

        assertEquals("afrikaans".toUpperCase(), lang.toString());

        lang = Languages.FRENCH;

        assertEquals("french".toUpperCase(), lang.toString());


    }

}
