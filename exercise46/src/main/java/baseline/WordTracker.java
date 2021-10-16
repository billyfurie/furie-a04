package baseline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordTracker {

    // use an ArrayList to keep track of the Word objects
    // use a hashmap to determine if we have already made an object for a word we come across

    List<Word> words;
    HashMap<String, Word> wordAddedMap;

    public WordTracker() {
        words = new ArrayList<>();
    }

    public void addWord(String word) {
        // check if the word has been added to our map
        // if it hasn't, we create a Word object and add to the list, then update our map with this Word object
        // increment the Word frequency
    }

    public void sortList() {
        // sort the list of words by frequency
        // might need to use comparator here
    }

    @Override
    public String toString() {
        // append the frequency output of each Word to our output String
        // return the String we built

        // placeholder
        return null;
    }
}
