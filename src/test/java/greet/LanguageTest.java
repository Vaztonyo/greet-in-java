package greet;

import greet.Language.Languages;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import greet.Language;

public class LanguageTest {

    @Test
    public void shouldBeAbleToGetLanguage() {
        Languages lang;

        lang = Languages.ENGLISH;

        assertEquals(lang.toString(), "ENGLISH");

        lang = Languages.AFRIKAANS;

        assertEquals(lang.toString(), "AFRIKAANS");

        lang = Languages.FRENCH;

        assertEquals(lang.toString(), "FRENCH");


    }

}
