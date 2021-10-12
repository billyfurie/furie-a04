package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution44Test {

    private static final String TEST_PATH = "data/test_input.json";

    @Test
    void getInventoryFromJSON() {
        Solution44 solution = new Solution44();

        Inventory inventory = solution.getInventoryFromJSON(TEST_PATH);

        // **PRODUCTS ARE FOUND IN JSON FILE

        // Check to make sure JSON file is being read properly
        assertTrue(inventory.isProductInInventory("Ben and Jerry's"));
        assertTrue(inventory.isProductInInventory("Milk"));
        assertTrue(inventory.isProductInInventory("Graphics Card"));
        assertTrue(inventory.isProductInInventory("Money"));
        assertTrue(inventory.isProductInInventory("Friends"));
    }
}