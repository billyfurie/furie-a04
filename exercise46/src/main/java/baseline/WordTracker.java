package baseline;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class WordTracker {

    // use an ArrayList to keep track of the Word objects
    // use a hashmap to determine if we have already made an object for a word we come across

    private List<Word> words;
    private HashMap<String, Word> wordAddedMap;

    public WordTracker() {
        words = new ArrayList<>();
        wordAddedMap = new HashMap<>();
    }

    public void addWord(String word) {
        // check if word is word
        if (word.length() == 0) {
            return;
        }

        // check if the word has been added to our map
        if (!wordAddedMap.containsKey(word)) {
            // if it hasn't, we create a Word object and add to the list, then update our map with this Word object
            Word wordObject = new Word(word);
            words.add(wordObject);
            wordAddedMap.put(word, wordObject);
        }

        // increment the Word frequency
        wordAddedMap.get(word).incrementFrequency();
    }

    public void sortList() {
        // sort the list of words by frequency
        // use a comparator
        words.sort(Comparator.comparing(Word::getFrequency).reversed());
    }

    public List<Word> getList() {
        return words;
    }

    @Override
    public String toString() {
        // append the frequency output of each Word to our output String
        StringBuilder builder = new StringBuilder();

        for (Word word : words) {
            builder.append(word.toString()).append("\n");
        }

        // return the String we built
        return builder.toString();
    }
}
