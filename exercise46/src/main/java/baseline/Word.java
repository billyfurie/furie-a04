package baseline;

public class Word {

    // used for spacing on output
    private static final int MINIMUM_SPACING_AMOUNT = 2;

    // used across all words
    private static int longestWordLength = 0;
    private String wordString;
    private int frequency;

    public Word(String wordString) {
        // initialize instance variables
        this.wordString = wordString;
        this.frequency = 0;

        // this is used for formatting purposes
        if (wordString.length() > longestWordLength) {
            longestWordLength = wordString.length();
        }
    }

    public void incrementFrequency() {
        frequency++;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getWordString() {
        return wordString;
    }

    @Override
    public String toString() {
        // return the Word in format as specified by our instructions
        // word: ***
        // frequency number of * characters
        String formattedWord = wordString + ":";

        // didn't use built in tabular formatting since I wanted the width to vary based on the longest word
        return String.format("%s%s%s", formattedWord,
                " ".repeat(longestWordLength + MINIMUM_SPACING_AMOUNT - formattedWord.length()), "*".repeat(frequency));
    }
}
