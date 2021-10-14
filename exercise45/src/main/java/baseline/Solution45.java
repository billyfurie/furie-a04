/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution45 {

    private static final String INPUT_PATH = "data/exercise45_input.txt";
    private static final String OUTPUT_PATH = "data/";
    private static final String REPLACE_ME = "utilize";
    private static final String REPLACEMENT = "use";

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();

        // read the file as a String
        String content = solution45.readFileToString(INPUT_PATH);

        // get the name for output file
        String fileName = solution45.getOutputFileNameFromUser();

        // go through string and replace utilize with use, return this String
        String updated = solution45.replaceWordInString(content, REPLACE_ME, REPLACEMENT);

        // write the string to a new file
        solution45.writeStringToFile(OUTPUT_PATH, fileName, updated);
    }

    public String readFileToString(String inputPath) {
        // if file exists, open it
        Path path = Paths.get(inputPath);

        // files can not exceed 2gb -- we are good.
        try {
            // Return the text of the file as a String
            return Files.readString(path);
        } catch (IOException e) {
            System.out.printf("Unable to read file %s%n", inputPath);
        }

        // if we cannot read the file, return the empty string
        return "";
    }

    private String getOutputFileNameFromUser() {
        // prompt the user for the name of the output file
        System.out.print("Enter the name for the output file: ");
        // return the name
        return input.nextLine();
    }

    public String replaceWordInString(String content, String replaceMe, String replacement) {
        // parse through the content String, building a new String as we go
        StringBuilder replacedBuilder = new StringBuilder();

        // this splits at spaces and ""
        // uses look after and look before in order to keep the spaces and "" in the text when converting
        String[] words = content.split("(?<=\\s)|(?=\\s)|(?<=\")|(?=\")");

        for (String word : words) {
            // if we come across the word replaceMe, we replace it with replacement, then add that to our String
            // also handles when the words have an "s"
            if (word.equals(replaceMe)) {
                replacedBuilder.append(replacement);
            } else if (word.equals(replaceMe + "s")) {
                replacedBuilder.append(replacement).append("s");
            } else {
                replacedBuilder.append(word);
            }
        }

        // return the String with the word replaceMe
        return replacedBuilder.toString();
    }

    public void writeStringToFile(String outputPath, String fileName, String content) {
        // write a file with our content to our path with the fileName specified by the user
        String pathName = outputPath + fileName;
        Path path = Paths.get(pathName);

        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            System.out.printf("Unable to write to file %s%n", pathName);
        }
    }
}
