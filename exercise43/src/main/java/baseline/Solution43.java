/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class Solution43 {

    private static final String MAIN_FOLDER_NAME = "data/website/";
    private static final String JS_FOLDER_NAME = "js/";
    private static final String CSS_FOLDER_NAME = "css/";
    private static final String INDEX_FILE_NAME = "index.html";


    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution43 solution = new Solution43();

        // get the site info from the user
        String siteName = solution.getStringFromUser("Site name: ");
        String authorName = solution.getStringFromUser("Author: ");

        // ask if they would like to include js or css folders
        boolean createJS = solution.getYesOrNoFromUser("Do you want a folder for JavaScript? ");
        boolean createCSS = solution.getYesOrNoFromUser("Do you want a folder for CSS? ");

        // create the site per specifications
        solution.generateWebsite(siteName, authorName, createJS, createCSS);
    }

    private String getStringFromUser(String prompt) {
        // prompt user
        System.out.print(prompt);
        // grab string from user
        // return string
        return input.nextLine();
    }

    private boolean getYesOrNoFromUser(String prompt) {
        boolean userResponse;

        // keep asking until user enters valid response
        while (true) {
            System.out.print(prompt);
            String response = input.nextLine();
            // only breaks if the response is valid
            try {
                userResponse = getBooleanFromResponse(response);
                break;
            } catch (InvalidParameterException e) {
                System.out.println("Please enter y or n");
            }
        }

        // return response as boolean
        return userResponse;
    }

    public boolean getBooleanFromResponse(String response) throws InvalidParameterException {
        // validate that response is 'y' or 'n'
        if (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n")) {
            throw new InvalidParameterException("Expected a response of 'y' or 'n'");
        }

        // if it equals y, we return true
        // otherwise it equals n, we return false
        return response.equalsIgnoreCase("y");
    }

    private void generateWebsite(String siteName, String authorName, boolean createJS, boolean createCSS) {
        // generate main directory
        generateDirectoryMain(siteName);

        if (createJS) {
            generateDirectoryJS(siteName);
        }

        if (createCSS) {
            generateDirectoryCSS(siteName);
        }

        generateIndex(siteName, authorName);
    }

    private void generateDirectoryMain(String siteName) {
        // generate a main directory in form ./website/siteName

        // have to create website/
        createFileOrDirectory(MAIN_FOLDER_NAME);

        // then create website/siteName
        String path = MAIN_FOLDER_NAME + siteName;
        createFileOrDirectory(path);
    }

    private void generateDirectoryJS(String siteName) {
        // generate a js directory
        String path = MAIN_FOLDER_NAME + siteName + File.separator + JS_FOLDER_NAME;

        createFileOrDirectory(path);
    }

    private void generateDirectoryCSS(String siteName) {
        // generate a css directory
        String path = MAIN_FOLDER_NAME + siteName + File.separator + CSS_FOLDER_NAME;
        createFileOrDirectory(path);
    }

    private void generateIndex(String siteName, String authorName) {
        // generate index content
        String content = generateIndexContent(siteName, authorName);
        String path = MAIN_FOLDER_NAME + siteName + File.separator + INDEX_FILE_NAME;
        // generate an index.html file, fill the file with specified content
        createFileOrDirectory(path, content);
    }

    private String generateIndexContent(String siteName, String authorName) {
        // generate name of site inside a <title> tag
        // generate author in a <meta> tag
        StringBuilder builder = new StringBuilder();
        String openHTML = "<!DOCTYPE html>\n<html>\n";
        String meta = String.format("<meta name=\"author\" content=\"%s\">", authorName);
        String closeHTML = "\n</html>";

        // open the HTML
        builder.append(openHTML);

        // add the title
        builder.append(getTitleHTML(siteName));

        // add the meta
        builder.append(meta);

        // close the HTML
        builder.append(closeHTML);

        // return this as a String
        return builder.toString();
    }

    public String getTitleHTML(String siteName) {
        return String.format("<title>%s</title>%n", siteName);
    }

    public void createFileOrDirectory(String path) {
        // this is for creating the directory
        File file = new File(path);
        boolean worked = file.mkdir();
        if (!worked) {
            System.out.printf("Unable to make directory at path %s%n", path);
            return;
        }

        displayCreatedPath(path);
    }

    private void createFileOrDirectory(String path, String fileContent) {
        // this is for creating the file
        File file = new File(path);

        // create the file
        try {
            boolean worked = file.createNewFile();
            if (!worked) {
                System.out.printf("Unable to create file at path %s%n", path);
            }
        } catch (IOException | SecurityException e) {
            System.out.printf("Unable to create file at path %s%n", path);
            return;
        }


        // write to the file
        try (FileWriter writer = new FileWriter(path)){
            writer.write(fileContent);
        } catch (IOException e) {
            System.out.printf("Unable to write to file at path %s%n", path);
            return;
        }

        displayCreatedPath(path);
    }

    private void displayCreatedPath(String path) {
        System.out.printf("Created ./%s%n", path);
    }
}
