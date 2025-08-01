package com.guilhermeguerradev.estudoDeSpring.entities.enums;

// Enumeração que define os possíveis status de um pedido.
public enum OrderStatus {

    // Cada constante do enum possui um código numérico associado.
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    // Atributo que guarda o código numérico do status.
    private int code;

    // Construtor privado para associar o código numérico a cada constante.
    private OrderStatus(int code) {
        this.code = code;
    }

    // Método getter para obter o código numérico do status.
    public int getCode() {
        return code;
    }

    // Método estático para obter um OrderStatus a partir de um código numérico.
    public static OrderStatus valueOf(int code) {
        // Percorre todas as constantes do enum.
        for (OrderStatus value : OrderStatus.values()) {
            // Se encontrar o código correspondente, retorna o status.
            if (value.getCode() == code) {
                return value;
            }
        }
        // Se não encontrar, lança uma exceção informando código inválido.
        throw new IllegalArgumentException("Invalid OrderStatus Code");
    }

}
