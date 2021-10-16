package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordTrackerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesAddWord.csv", numLinesToSkip = 1)
    void sortList(String mostFrequent, String leastFrequent) {
        WordTracker tracker = new WordTracker();

        // create a tracker with the same words
        tracker.addWord(mostFrequent);
        tracker.addWord(mostFrequent);
        tracker.addWord(leastFrequent);

        // sort the tracker
        tracker.sortList();

        List<Word> list = tracker.getList();


        // make sure our sort is in the right order
        assert(list.get(0).getWordString().equals(mostFrequent));
        assert(list.get(1).getWordString().equals(leastFrequent));
    }
}