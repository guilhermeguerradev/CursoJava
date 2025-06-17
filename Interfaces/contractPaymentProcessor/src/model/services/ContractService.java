package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

/**
 * Serviço responsável por processar contratos e gerar as parcelas com base
 * em um serviço de pagamento online (como Paypal).
 */

public class ContractService {

    private final Contract contract;
    private final OnlinePaymentService onlinePaymentService;

    public ContractService(Contract contract, OnlinePaymentService onlinePaymentService) {
        this.contract = contract;
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Integer months) {

        Double basicQuota  = (contract.getTotalValue() / months );

        for (int i = 1; i <= months; i++) {
            // Data de vencimento da parcela (acrescenta i meses)
            LocalDate dueDate = contract.getDate().plusMonths(i);

            // Calcula os juros proporcionais ao mês
            double interest = onlinePaymentService.interest(basicQuota, i);

            // Valor atualizado com juros
            double updatedQuota = basicQuota + interest;

            // Calcula a taxa sobre o valor atualizado
            double fee = onlinePaymentService.paymentFee(updatedQuota);

            // Valor total da parcela com juros + taxa
            double fullInstallment = updatedQuota + fee;

            // Adiciona a parcela ao contrato
            contract.addInstallment(new Installment(dueDate, fullInstallment));
        }
    }

}
