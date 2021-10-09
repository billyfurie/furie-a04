package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution41Test {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetSortedListOfNamesByLastName.csv", numLinesToSkip = 1)
    void getSortedListOfNamesByLastName(String first1, String last1, String first2, String last2, String first3, String last3) {
        Solution41 solution = new Solution41();

        // User gives the names in order
        List<Name> expected = new ArrayList<>();
        expected.add(new Name(first1, last1));
        expected.add(new Name(first2, last2));
        expected.add(new Name(first3, last3));

        // create list with wrong order
        List<Name> wrongOrder = new ArrayList<>();
        wrongOrder.add(new Name(first2, last2));
        wrongOrder.add(new Name(first1, last1));
        wrongOrder.add(new Name(first3, last3));

        // sort the random one, and we should get our original
        List<Name> actual = solution.getSortedListOfNamesByLastName(wrongOrder);

        // make sure the sort worked
        assertEquals(expected.get(0).getLastName(), actual.get(0).getLastName());
        assertEquals(expected.get(1).getLastName(), actual.get(1).getLastName());
        assertEquals(expected.get(2).getLastName(), actual.get(2).getLastName());
    }
}