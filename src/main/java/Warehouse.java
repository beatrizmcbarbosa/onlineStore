import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> priceOfProduct;
    private Map<String, Integer> stockOfProducts;

    public Warehouse() {
        this.priceOfProduct = new HashMap<>();
        this.stockOfProducts = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.priceOfProduct.put(product, price);
        this.stockOfProducts.put(product, stock);
    }

    public int price(String product) {
        if (!priceOfProduct.containsKey(product)) {
            return -99;
        }
        return this.priceOfProduct.get(product);
    }

    public int stock(String product) {
        if (!stockOfProducts.containsKey(product)) {
            return 0;
        }
        return this.stockOfProducts.get(product);
    }

    public boolean take(String product) {
        boolean inStock = false;

        if (this.stockOfProducts.containsKey(product)) {
            if (this.stockOfProducts.get(product) >= 1) {
                this.stockOfProducts.put(product, (this.stockOfProducts.get(product)) - 1);
                inStock = true;
            }
        }
        return inStock;
    }

    public Set<String> products() {
        return this.priceOfProduct.keySet();
    }
}
