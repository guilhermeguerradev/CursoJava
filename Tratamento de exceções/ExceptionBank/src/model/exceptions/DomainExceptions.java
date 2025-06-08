// Define o pacote onde essa classe está localizada
package model.exceptions;

// Cria uma classe chamada DomainExceptions que herda da classe Exception (classe de exceções do Java)
public class DomainExceptions extends Exception {

    // Construtor da classe que recebe uma mensagem como argumento
    // Essa mensagem será usada como o detalhe da exceção
    public DomainExceptions(String msg) {
        // Chama o construtor da classe Exception, passando a mensagem recebida
        super(msg);
    }
}
