package baseline;

import java.util.HashMap;

public class Inventory {

    private final Product[] products;
    private HashMap<String, Product> productsMap;

    // this is NOT called when initialized from GSON parse
    public Inventory(Product[] products) {
        this.products = products;
    }

    // map each product to its name so that we can allow for quick lookup!
    private void createSearchMap() {
        productsMap = new HashMap<>();

        for (Product product : products) {
            productsMap.put(product.getName(), product);
        }
    }

    public boolean isProductInInventory(String name) {
        // check that the search map is in place
        if (productsMap == null) {
            createSearchMap();
        }

        // if the name is not in map, we don't have the product
        return productsMap.get(name) != null;
    }

    public Product getProductFromSearch(String name) {
        // check that the search map is in place
        if (productsMap == null) {
            createSearchMap();
        }

        return productsMap.get(name);
    }
}
