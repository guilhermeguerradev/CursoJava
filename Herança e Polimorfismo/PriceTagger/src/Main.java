import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = input.nextInt();

        List<Product> list = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)?");
            char ch = input.next().charAt(0);
            System.out.print("Name: ");
            String name = input.next();
            System.out.print("Price: ");
            Double price = input.nextDouble();
            if (ch == 'i') {
                System.out.print("Customs fee: ");
                Double customsfee = input.nextDouble();
                list.add(new ImportedProduct(name,price,customsfee));
            } else if (ch == 'c') {
                list.add(new Product(name,price));
            } else {
                System.out.print("Manufacture date (DD/MM/YYYY)");
                String date = input.next();
                LocalDate data = LocalDate.parse(date,dtm);
                list.add(new UsedProduct(name,price,data));
            }
        }
        System.out.println();
        System.out.println("Price Tags:");

        for (Product product : list) {
            System.out.println(product.priceTag());
        }

        input.close();
    }
}