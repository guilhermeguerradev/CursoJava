import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = input.nextInt();

        List<Employee> list = new ArrayList<>();


        for ( int i = 1 ; i <= n ; i ++) {
            System.out.print("Outsourced (y/n):  ");
            char ch = input.next().charAt(0);
            System.out.print("Name: ");
            String name = input.next();
            System.out.print("Hours: ");
            int hours = input.nextInt();
            System.out.print("Value per hour: ");
            Double valuehour = input.nextDouble();
            if ( ch == 'y') {
                System.out.print("Additional charge: ");
                Double additional = input.nextDouble();
                list.add(new OutsourcedEmployee(name,hours,valuehour,additional));
            } else {
                list.add(new Employee(name,hours,valuehour));
            }




        }
        System.out.println();
        System.out.println("Payments");
        for (Employee emp : list) {
            System.out.println(emp.getName() + " - $" + String.format("%.2f" , emp.payment()));
        }

        input.close();

    }
}