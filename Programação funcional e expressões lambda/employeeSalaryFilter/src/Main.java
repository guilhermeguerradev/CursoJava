import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<Employee> emp = new ArrayList<>();

        System.out.print("Enter full file path: ");
        String path = input.next();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                emp.add(new Employee(fields[0],fields[1],Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Enter Salary");
            Double salary = input.nextDouble();

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> emails = emp.stream()
                    .filter(p -> p.getSalary() > salary)
                    .map(p -> p.getEmail())
                    .sorted(comp)
                    .collect(Collectors.toList());
            Double sum = emp.stream()
                    .filter(p -> p.getName().toUpperCase().charAt(0) == 'M')
                    .map(p -> p.getSalary())
                    .reduce(0.0 , (a,b) -> a+b);

            emails.forEach(System.out::println);
            System.out.print("Sum of salary of people whose name starts with 'M': " + String.format("%.2f",sum));



        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }



        input.close();


    }
}