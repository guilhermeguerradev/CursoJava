import model.entities.Product;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String sourcePath = "C:\\Users\\guilh\\OneDrive\\Documentos\\Java\\CursoJava-Github\\Trabalhando com arquivos\\SalesSummaryGenerator\\arquivo.csv";
        File sourceFile = new File(sourcePath);

        List<Product> productList = new ArrayList<>();

        String sourceFolder = sourceFile.getParent();

        Path outDirPath = Paths.get(sourceFolder, "out");

        try {
            if (!Files.exists(outDirPath)) {
                Files.createDirectory(outDirPath);
                System.out.println("Diretório 'out' criado com sucesso.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar diretório de saída: " + e.getMessage());
            return;
        }

        Path summaryFilePath = Paths.get(outDirPath.toString(), "summary.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");

                String name = fields[0].trim();
                Double price = Double.parseDouble(fields[1].trim());
                Integer quantity = Integer.parseInt(fields[2].trim());

                productList.add(new Product(name, price, quantity));

                line = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(summaryFilePath.toFile()))) {
                for (Product prod : productList) {
                    bw.write(prod.getName() + "," + String.format("%.2f", prod.totalValue()));
                    bw.newLine();
                }
                System.out.println("Arquivo 'summary.csv' criado com sucesso.");
            } catch (IOException e) {
                System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo original: " + e.getMessage());
        }
    }
}
