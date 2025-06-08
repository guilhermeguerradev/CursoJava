import model.entities.Account;
import model.exceptions.DomainExceptions;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            Integer number = input.nextInt();
            System.out.print("Holder: ");
            input.next();
            String holder = input.nextLine();
            System.out.print("Initial balance: ");
            Double balance = input.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLimit = input.nextDouble();

            Account acc = new Account(number,holder,balance,withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            Double amount = input.nextDouble();
            acc.withdraw(amount);

            System.out.println();
            System.out.println("New balance: " + acc.getBalance());
        }
        catch (DomainExceptions e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("Unexpected error");
        }





        input.close();
    }
}