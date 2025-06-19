# 💳 Contract Payment Processor em Java

Projeto voltado para o uso de **interfaces como contratos**, aplicando os conceitos de **injeção de dependência via construtor** e **inversão de controle (IoC)** para criar um sistema flexível de processamento de pagamentos.

---

## 📌 Objetivo

Demonstrar como usar interfaces para desacoplar a lógica de pagamento da implementação concreta, facilitando:

- Reutilização de código
- Substituição de comportamentos sem alterar o código principal

---

## 📚 O que eu aprendi

✅ Criação de **interfaces** para definir contratos de comportamento (`OnlinePaymentService`)  
✅ Implementação concreta de regras de negócio (`PaypalService`)  
✅ **Interface para processador de pagamentos** (`PaymentProcessor`)  
✅ Implementação múltipla de interfaces  
✅ **Injeção de dependência via construtor** para fornecer os serviços de forma flexível  
✅ Aplicação prática do princípio de **Inversão de Controle (IoC)**  
✅ Criação de entidades com **encapsulamento** (`Contract`, `Installment`)  
✅ Organização da lógica de negócio em **serviços reutilizáveis** (`ContractService`)  
✅ Separação clara entre **entidades**, **serviços** e **código de aplicação**

---

## 🛠️ Tecnologias e conceitos usados

- Java 17+  
- Programação orientada a objetos (POO)  
- Interfaces como contratos  
- **Injeção de dependência via construtor**  
- **Inversão de controle (IoC)**  
- Separação de responsabilidades

---

## 👨‍💻 Autor

Desenvolvido por **Guilherme Guerra**