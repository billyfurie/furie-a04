/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

public class Solution43 {

    public static void main(String[] args) {
        // get the site info from the user
        // ask if they would like to include js or css folders
        // create the site per specifications
    }

    String getStringFromUser(String prompt) {
        // prompt user
        // grab string from user
        // return string

        // placeholder
        return null;
    }

    boolean getYesOrNoFromUser(String prompt) {
        // prompt user
        // get user response
        // validate that it is a char and is yes or no
        // return response as boolean

        // placeholder
        return false;
    }

    boolean isValidYesOrNoResponse(String response) {
        // validate that response is char
        // validate it is either 'y' or 'n'
        // return whether it is valid

        // placeholder
        return false;
    }

    void generateWebsite(String siteName, String authorName, boolean createJS, boolean createCSS) {
        // generate main directory
        // generate js directory (if requested)
        // generate css directory (if requested)
        // generate index file (with name of site and author)
    }

    void generateDirectoryMain(String siteName) {
        // generate a main directory in form ./website/`siteName`
    }

    void generateDirectoryJS(String siteName) {
        // generate a js directory
    }

    void generateDirectoryCSS(String siteName) {
        // generate a css directory
    }

    void generateIndex(String siteName) {
        // generate an index.html file
        // fill the file with specified content
    }

    String generateIndexContent(String siteName, String authorName) {
        // generate name of site inside a <title> tag
        // generate author in a <meta> tag
        // return this as a String

        // placeholder
        return null;
    }

    void createFileOrDirectory(String path) {
        // this is for creating the directory
    }

    void createFileOrDirectory(String path, String fileContent) {
        // this is for creating the file
        // we also need the content for the file
    }
}
