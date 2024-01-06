package org.example;
import java.util.List;
import java.util.stream.Collectors;

public class ECommercePlatform {
    public void displaySortedProductsByName(List<Product> products) {
        List<Product> sortedProducts = products.stream()
                .sorted(new ProductComparators.NameComparator())
                .collect(Collectors.toList());

        displayProducts(sortedProducts);
    }

    public void displaySortedProductsByPrice(List<Product> products) {
        List<Product> sortedProducts = products.stream()
                .sorted()
                .collect(Collectors.toList());

        displayProducts(sortedProducts);
    }

    public void displaySortedProductsByStock(List<Product> products) {
        List<Product> sortedProducts = products.stream()
                .sorted(new ProductComparators.StockComparator())
                .collect(Collectors.toList());

        displayProducts(sortedProducts);
    }

    public void displayAvailableProducts(List<Product> products) {
        List<Product> availableProducts = products.stream()
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());

        displayProducts(availableProducts);
    }

    public void displayRecommendedProducts(User user, List<Product> products) {
        List<Product> recommendedProducts = products.stream()
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("Recommended Products:");
        displayProducts(recommendedProducts);
    }

    private void displayProducts(List<Product> products) {
        System.out.println("Product List:");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println();
    }
}