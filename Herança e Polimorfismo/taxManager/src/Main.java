import entities.Individual;
import entities.LegalEntity;
import entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<Person> list = new ArrayList<>();

        System.out.print("Enter the number of tax players: ");
        int n = input.nextInt();

        for (int i = 1 ; i <= n ; i++) {
            System.out.println("Tax player #" + i + " data:");
            System.out.print("Individual or Company (i/c)? ");
            char ch = input.next().charAt(0);
            System.out.print("Name: ");
            String name = input.next();
            System.out.print("Annual income: ");
            Double annualIncome = input.nextDouble();

            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                Double medicalExpenses = input.nextDouble();
                list.add(new Individual(name,annualIncome,medicalExpenses));
            } else {
                System.out.print("Number of employees: ");
                Integer employeeCount = input.nextInt();
                list.add(new LegalEntity(name,annualIncome,employeeCount));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID: ");
        Double sum = 0.0;

        for ( Person person : list ) {
            System.out.println(person.getName() + ": $ " + String.format("%.2f", person.calculateTax()));
            sum += person.calculateTax();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f" , sum));

        input.close();
    }
}