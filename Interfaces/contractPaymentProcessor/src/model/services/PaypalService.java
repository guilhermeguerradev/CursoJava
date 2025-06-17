package model.services;

/**
 * Implementação do serviço de pagamento online usando regras do Paypal.
 * - Taxa de pagamento: 2% do valor.
 * - Juros simples: 1% ao mês.
 */

public class PaypalService implements OnlinePaymentService {
    @Override
    public Double paymentFee(Double amount) {
        return amount * 0.02;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * 0.01 * months;
    }
}
