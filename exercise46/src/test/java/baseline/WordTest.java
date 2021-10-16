package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesToStringWord.csv", numLinesToSkip = 1)
    void testToString(String word1, int frequency) {
        Word word = new Word(word1);

        for (int i = 0; i < frequency; i++) {
            word.incrementFrequency();
        }

        String expected = String.format("%s: %s", word1, "*".repeat(frequency));
        String actual = word.toString();

        assertEquals(expected, actual);
    }
}