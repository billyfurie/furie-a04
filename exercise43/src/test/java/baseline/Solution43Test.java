package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class Solution43Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetBooleanFromResponse.csv", numLinesToSkip = 1)
    void getBooleanFromResponse(String response, boolean expected) {
        Solution43 solution43 = new Solution43();

        boolean actual = solution43.getBooleanFromResponse(response);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetTitleHTML.csv", numLinesToSkip = 1)
    void getTitleHTML(String siteName, String expectedTitleHTML) {
        Solution43 solution = new Solution43();

        String actual = solution.getTitleHTML(siteName);

        // using contains because of weird line separation
        assertTrue(actual.contains(expectedTitleHTML));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesCreateFileOrDirectory.csv", numLinesToSkip = 1)
    void createFileOrDirectory(String path) {

        Solution43 solution = new Solution43();

        solution.createFileOrDirectory(path);
        
        File file = new File(path);
        boolean worked = file.isDirectory();

        assertTrue(worked);

        file.delete();
    }
}