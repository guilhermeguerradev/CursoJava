import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = input.nextLine();

        Map<String, Integer> voteMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Integer quantity = Integer.parseInt(fields[1]);

                if(voteMap.containsKey(name)) {
                    int total = voteMap.get(name) + quantity;
                    voteMap.put(name,total);
                } else {
                    voteMap.put(name,quantity);
                }

                line = br.readLine();
            }

            for(String key : voteMap.keySet()) {
                System.out.println(key + " : " + voteMap.get(key));
            }

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        for(String key : voteMap.keySet()) {
            System.out.println(key + " : " + voteMap.get(key));
        }



        input.close();
    }
}