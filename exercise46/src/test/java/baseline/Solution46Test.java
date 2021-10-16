package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class Solution46Test {

    private final static String TEST_FILE_PATH = "src/test/resources/";

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesConvertFileToPath.csv", numLinesToSkip = 1)
    void convertFileToString(String fileName, String expected) {
        Solution46 solution = new Solution46();
        String path = TEST_FILE_PATH + fileName;

        String actual = solution.convertFileToString(path);

        assertEquals(expected, actual);
    }
}