/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Solution41 {

    public static void main(String[] args) {
        Solution41 solution = new Solution41();

        // read list of names from file, creating a name object for each name
        List<Name> names = solution.getListOfNamesFromFile();

        // sort the list of names in alphabetical order by last name
        List<Name> sorted = solution.getSortedListOfNamesByLastName(names);

        // write the sorted list to a file
        //test
        solution.writeListToFile(sorted);

        // unit testing
            // test list being sorted
            // test the output file for correctness
    }

    private List<Name> getListOfNamesFromFile() {
        List<Name> names = new ArrayList<>();

        // open and parse through the file
        try (Scanner input = new Scanner(Paths.get("src/main/resources/exercise41_input.txt"))) {
            while (input.hasNext()) {
                // each name is comma separated (first and last), linebreak for each name
                input.useDelimiter(", |\\R");

                // file must have a first name and a last name!
                String last = input.next();

                String first = input.next();


                // create name objects for each name
                Name name = new Name(first, last);

                // add name objects to a list
                names.add(name);
            }
        } catch (IOException | NoSuchElementException | IllegalStateException e) {
            e.printStackTrace();
        }

        // return list of names
        return names;
    }

    public List<Name> getSortedListOfNamesByLastName(List<Name> names) {
        List<Name> sorted = names;

        // sort the list of names by last name
        // if last name is the same, it will go by first name
        // this uses compareTo in Name class
        sorted.sort(Comparator.comparing(Name::getLastName).thenComparing(Name::getFirstName));

        // return the sorted list
        return sorted;
    }

    private void writeListToFile(List<Name> names) {
        // open and write to file
        try (Formatter output = new Formatter("output/exercise41_output.txt")) {
            // go through the list, writing each name on a line in the file

            // create the header
            String numNames = String.format("Total of %d names%n", names.size());
            String divider = "----------------";
            output.format("%s%s%n", numNames, divider);

            // write each name
            for (Name name : names) {
                output.format("%s%n", name.toString());
            }
        } catch (SecurityException | FileNotFoundException | FormatterClosedException e) {
            e.printStackTrace();
        }
    }


}
