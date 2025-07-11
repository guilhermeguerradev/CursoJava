import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        Double sum = list.stream()
                .filter(p -> p.getName().toUpperCase().charAt(0) == 'T')
                .map(p -> p.getPrice())
                .reduce(0.0, (x,y) -> x + y);

        System.out.println(String.format("%.2f", sum));
    }
}