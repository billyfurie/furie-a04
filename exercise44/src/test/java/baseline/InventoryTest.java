package baseline;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesIsProductInInventory.csv", numLinesToSkip = 1)
    void isProductInInventory(String name, double price, int quantity, String searchName, boolean expectedInSearch) {
        Product product = new Product(name, price, quantity);
        Product[] products = new Product[1];
        products[0] = product;

        // create an inventory with the product
        Inventory inventory = new Inventory(products);

        // see if the product we search for is in the inventory
        boolean actual = inventory.isProductInInventory(searchName);

        assertEquals(expectedInSearch, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sourcesGetProductFromSearch.csv", numLinesToSkip = 1)
    void getProductFromSearch(String name1, double price1, int quantity1, String name2, double price2, int quantity2,
                              String searchName) {

        // ** searchName must be same as name1 or name2

        Product product1 = new Product(name1, price1, quantity1);
        Product product2 = new Product(name2, price2, quantity2);
        Product expectedProductFromSearch;

        // this is to determine which product we expect
        if (name1.equals(searchName)) {
            expectedProductFromSearch = product1;
        } else {
            expectedProductFromSearch = product2;
        }

        Product[] products = new Product[2];
        products[0] = product1;
        products[1] = product2;

        // create an inventory with the product
        Inventory inventory = new Inventory(products);

        Product productFromSearch = inventory.getProductFromSearch(searchName);

        assertEquals(expectedProductFromSearch.getName(), productFromSearch.getName());
    }
}