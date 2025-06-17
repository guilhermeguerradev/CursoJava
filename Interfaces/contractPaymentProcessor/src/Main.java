import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

/**
 * Programa principal que lê os dados de um contrato,
 * processa as parcelas com juros e taxas via serviço de pagamento,
 * e exibe o cronograma de pagamentos (parcelas).
 */

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");

        System.out.print("Numero: ");
        Integer contractNumber = input.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(input.next(), formatter);

        System.out.print("Valor do contrato: ");
        Double contractValue = input.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        Integer installmentCount = input.nextInt();

        Contract contract = new Contract(contractNumber,contractDate,contractValue);

        ContractService contractService = new ContractService(contract, new PaypalService());

        contractService.processContract(installmentCount);

        System.out.println("Parcelas:");

        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment.getDueDate() + " - " + String.format("%.2f", installment.getAmount()));
        }

        input.close();



    }
}