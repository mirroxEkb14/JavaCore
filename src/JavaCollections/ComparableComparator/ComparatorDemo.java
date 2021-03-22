package JavaCollections.ComparableComparator;

import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args) {
        Set<Product> productSet = new TreeSet<>(new NameComparator());
        productSet.add(new Product("C", 3L));
        productSet.add(new Product("B", 2L));
        productSet.add(new Product("A", 1L));

        for (Product product: productSet) {
            System.out.println(product.getBrand());
        }

        System.out.println();

        /*  if we have a list  */

        List<Product> productList = Arrays.asList(
                new Product("C", 3L),
                new Product("B", 2L),
                new Product("A", 1L)
        );
        Collections.sort(productList, new NameComparator());
        for (Product product: productList) {
            System.out.println(product.getBrand());
        }

    }

    public static class NameComparator implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            return Long.compare(o1.getSerialNumber(), o2.getSerialNumber()); // o1.getBrand().compareTo(o2.getBrand())
        }
    }
}

class Product {
    private final String brand;
    private final long serialNumber;

    public Product(String brand, long serialNumber) {
        this.brand = brand;
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}