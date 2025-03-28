import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cartItems = new LinkedHashMap<>(); // Maintains insertion order
    private TreeMap<Double, List<String>> productsByPrice = new TreeMap<>();

    // Add product to catalog
    public void addProduct(String name, double price) {
        productPrices.put(name, price);
        productsByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(name);
    }

    // Add item to cart
    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            throw new IllegalArgumentException("Product not found");
        }
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
    }

    // Get cart total
    public double getTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    // Display products sorted by price
    public void displayProductsByPrice() {
        for (Map.Entry<Double, List<String>> entry : productsByPrice.entrySet()) {
            System.out.printf("$%.2f: %s\n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        // Add products
        cart.addProduct("Laptop", 999.99);
        cart.addProduct("Mouse", 25.50);
        cart.addProduct("Keyboard", 49.99);
        
        // Add items to cart
        cart.addToCart("Laptop", 1);
        cart.addToCart("Mouse", 2);
        
        System.out.println("Cart items in order added: " + cart.cartItems);
        System.out.println("Total: $" + cart.getTotal());
        System.out.println("Products by price:");
        cart.displayProductsByPrice();
    }
}