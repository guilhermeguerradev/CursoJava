import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();



        System.out.print("How many students for course A?");
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter the user code: ");
            int userId  = input.nextInt();
            a.add(userId);
        }

        System.out.print("How many students for course B?");
        n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter the user code: ");
            int userId  = input.nextInt();
            b.add(userId );
        }

        System.out.print("How many students for course C?");
        n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter the user code: ");
            int userId  = input.nextInt();
            c.add(userId );
        }

        Set<Integer> total = new HashSet<>(a);
        total.addAll(b);
        total.addAll(c);

        System.out.println("Total students: " + total.size());

        input.close();
    }
}