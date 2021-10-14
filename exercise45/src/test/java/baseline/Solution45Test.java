package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution45Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesReadFileToString.csv", numLinesToSkip = 1)
    void readFileToString(String fileName, String expected) {
        Solution45 solution = new Solution45();

        String actual = solution.readFileToString("src/test/resources/" + fileName);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesReplaceWordInString.csv", numLinesToSkip = 1)
    void replaceWordInString(String content, String replaceMe, String replacement, String expected) {
        Solution45 solution = new Solution45();

        String actual = solution.replaceWordInString(content, replaceMe, replacement);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesWriteStringToFile.csv", numLinesToSkip = 1)
    void writeStringToFile(String fileName, String content) {
        Solution45 solution = new Solution45();

        solution.writeStringToFile("src/test/resources/", fileName, content);

        // this will also do some testing for our read file to string
        String actual = solution.readFileToString("src/test/resources/" + fileName);

        assertEquals(content, actual);
    }
}