import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void add(String product, int price) {
        if (cart.containsKey(product)) {
            cart.get(product).increaseQuantity();
            return;
        }
        cart.put(product, new Item(product, 1, price));

        // alt
        // this.cart.putIfAbsent(product, new Item(product, 0, price));
        // this.cart.get(product).increaseQuantity();
    }

    public int price() {
        int total = 0;
        for (String item : this.cart.keySet()) {
            total += cart.get(item).price();
        }
        return total;
    }

    public void print() {
        for (String item : this.cart.keySet()) {
            System.out.println(this.cart.get(item));
        }
    }
}
