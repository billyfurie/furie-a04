/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 William Furie
 */

package baseline;

import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution44 {

    private static final String INVENTORY_PATH = "data/exercise44_input.json";

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Solution44 solution = new Solution44();

        // get our inventory from the json file
        Inventory inventory = solution.getInventoryFromJSON(INVENTORY_PATH);

        // this is for our loop
        boolean productInStock = false;

        while (!productInStock) {
            // keep getting product name from user
            String productName = solution.getProductNameFromUser();

            // if this is false, we keep asking user until they give a product that is in stock
            productInStock = inventory.isProductInInventory(productName);

            if (productInStock) {
                // search for product in inventory
                // if we find the product, display the appropriate data
                Product product = inventory.getProductFromSearch(productName);
                System.out.println(product.toString());
            } else {
                // we didn't find the product
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        }
    }

    private String getProductNameFromUser() {
        // prompt user for a product name
        System.out.print("What is the product name? ");
        // return the product name
        return input.nextLine();
    }

    public Inventory getInventoryFromJSON(String path) {
        // parse the json file for the inventory
        Gson gson = new Gson();
        // get the json as a string
        String json = getInventoryFileAsString(path);

        // return an inventory object using the json data
        return gson.fromJson(json, Inventory.class);
    }

    private String getInventoryFileAsString(String path) {
        // return the text of the inventory file
        File inventoryFile = new File(path);
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(inventoryFile));
            return fileElement.toString();

        } catch (FileNotFoundException e) {
            System.out.printf("Unable to find the inventory file. Should be located at %s%n", INVENTORY_PATH);
            return "";
        }
    }
}
