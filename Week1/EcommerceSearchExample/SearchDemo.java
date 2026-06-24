import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

   
    static Product linearSearch(Product[] products, int id) {

        for (Product p : products) {
            if (p.productId == id) {
                return p;
            }
        }

        return null;
    }

   
    static Product binarySearch(Product[] products, int id) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (products[mid].productId == id)
                return products[mid];

            if (products[mid].productId < id)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(103, "Laptop", "Electronics"),
                new Product(101, "Phone", "Electronics"),
                new Product(105, "Shoes", "Fashion"),
                new Product(102, "Watch", "Accessories"),
                new Product(104, "Bag", "Fashion")
        };


        Product p1 = linearSearch(products, 102);

        System.out.println("Linear Search Result:");
        if (p1 != null)
            p1.display();

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        Product p2 = binarySearch(products, 102);

        System.out.println("Binary Search Result:");
        if (p2 != null)
            p2.display();
    }
}