/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution46 {

    private static final String INPUT_PATH = "data/exercise46_input.txt";

    public static void main(String[] args) {
        Solution46 solution = new Solution46();

        // parse the input file and convert it to a String
        String content = solution.convertFileToString(INPUT_PATH);

        // use the WordTracker to do the following:
        // parse String to create an ArrayList of Word objects
        // sort the Word objects by their frequency
        // build an output String from the sorted array of Words

        // build our WordTracker and let it do its thing
        WordTracker tracker = solution.buildWordTrackerFromString(content);

        // display the histogram
        solution.displayHistogram(tracker);
    }

    public String convertFileToString(String pathName) {
        // convert the file to a String

        // if file exists, open it
        Path path = Paths.get(pathName);

        // files can not exceed 2gb -- we are good.
        try {
            // Return the text of the file as a String
            return Files.readString(path);
        } catch (IOException e) {
            System.out.printf("Unable to read file %s%n", pathName);
        }

        // if we cannot read the file, return the empty string
        return "";
    }

    private WordTracker buildWordTrackerFromString(String content) {
        // create a WordTracker
        WordTracker tracker = new WordTracker();

        String[] words = content.split("\\s");

        // parse through our content string word by word, passing each into our WordTracker
        for (String word : words) {
            tracker.addWord(word);
        }

        // sort the list
        tracker.sortList();

        // return the WordTracker
        return tracker;
    }

    private void displayHistogram(WordTracker tracker)
    {
        System.out.println(tracker);
    }
}
