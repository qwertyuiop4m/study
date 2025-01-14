import java.util.*;
import java.util.stream.Collectors;

public class Main {
    @FunctionalInterface
    interface Mydiscount{
        double getDiscount(double price);
    }
    public static void main(String[] args) {
        List<Map<String, Object>> products = Arrays.asList(
                Map.of("name", "Laptop", "price", 1200.0),
                Map.of("name", "SmartPhone", "price", 800.0),
                Map.of("name", "Tablet", "price", 1000.0)
        );
        Mydiscount mydiscount = price->price * 0.9;

        List<String> discountProducts=products.stream()
                .map(product->Map.of(
                        "name",product.get("name"),
                        "discountPrice",mydiscount.getDiscount((Double)product.get("price"))
                )).sorted(Comparator.comparingDouble(product->(double)product.get("discountPrice")))
                .map(product->product.get("name")+": " +String.format("%.2f",product.get("discountPrice"))+"원")
                .toList();
        System.out.println(discountProducts);
    }
}