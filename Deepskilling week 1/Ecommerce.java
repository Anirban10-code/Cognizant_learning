
import java.util.Arrays;
import java.util.Comparator;
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}
class SearchUtil {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    public static void sortById(Product[] products) {
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Shoes", "Fashion"),
            new Product(101, "Laptop", "Electronics"),
            new Product(110, "Phone", "Electronics"),
            new Product(103, "Watch", "Accessories")
        };

    
        Product result1 = SearchUtil.linearSearch(products, 110);
        System.out.println("Linear Search Result: " + result1);

        SearchUtil.sortById(products);
        Product result2 = SearchUtil.binarySearch(products, 110);
        System.out.println("Binary Search Result: " + result2);
    }
}

