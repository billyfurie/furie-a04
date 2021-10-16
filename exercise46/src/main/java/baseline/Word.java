package baseline;

public class Word {

    String wordString;
    int frequency;

    public Word(String wordString) {
        // initialize instance variables
        this.wordString = wordString;
        this.frequency = 0;
    }

    public void incrementFrequency() {
        frequency++;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        // return the Word in format as specified by our instructions

        // placeholder
        return null;
    }
}
