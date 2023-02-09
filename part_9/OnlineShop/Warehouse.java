import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> productsPrice;
    private Map<String, Integer> productsStock;

    public Warehouse() {
        this.productsPrice = new HashMap<>();
        this.productsStock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.productsPrice.put(product, price);
        this.productsStock.put(product, stock);
    }

    public int price(String product) {
        // for (String key : this.productsPrice.keySet()) {
        //     if (key.equals(product)) {
        //         return this.productsPrice.get(key);
        //     }
        // }
        // return -99;

        // better
        return this.productsPrice.getOrDefault(product, -99);
    }

    public int stock(String product) {
        // for (String key : this.productsStock.keySet()) {
        //     if (key.equals(product)) {
        //         return this.productsStock.get(key);
        //     }
        // }
        // return 0;

        // better
        return this.productsStock.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        int value = this.productsStock.getOrDefault(product, 0);
        if (value > 0) {
            // value -= 1;
            this.productsStock.put(product, value - 1);
            return true;
        }
        return false;
    }

    public Set<String> products() {
        return this.productsPrice.keySet();
    }
}
