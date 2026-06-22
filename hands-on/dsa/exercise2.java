class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class exercise2 {

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search (Array must be sorted by productName)
    public static Product binarySearch(Product[] products, String name) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int result = products[mid].productName.compareToIgnoreCase(name);

            if (result == 0)
                return products[mid];
            else if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobile", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories")
        };

        Product result1 = linearSearch(products, "Shoes");

        if (result1 != null)
            System.out.println("Linear Search Found: " + result1.productName);

        Product result2 = binarySearch(products, "Watch");

        if (result2 != null)
            System.out.println("Binary Search Found: " + result2.productName);
    }
}