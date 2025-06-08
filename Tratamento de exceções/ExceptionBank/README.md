# 💳 ExceptionBank - Projeto de Tratamento de Exceções em Java

Este projeto foi desenvolvido como parte do meu aprendizado em **Java**, com foco no uso de **tratamento de exceções** utilizando as estruturas `try`, `catch` e exceções personalizadas.

## 📌 Objetivo

Simular um sistema bancário simples onde o usuário pode criar uma conta e realizar saques, respeitando:

- O **limite de saque** definido pela conta.
- O **saldo disponível** na conta.

O projeto captura e trata erros de forma amigável ao usuário, utilizando exceções personalizadas.

---

## 📚 O que eu aprendi

✅ Como utilizar `try` e `catch` para tratar exceções.  
✅ Como criar e lançar **exceções personalizadas** (custom exceptions).  
✅ Como exibir mensagens de erro claras para o usuário.  
✅ Organização de código orientado a objetos (classes `Account`, `DomainException`, e `Main`).

---

## 💡 Exemplos de funcionamento

### ✅ Saque válido
```
Enter account data
Number: 8021
Holder: Bob Brown
Initial balance: 500.00
Withdraw limit: 300.00

Enter amount for withdraw: 100.00
New balance: 400.00
```

### ❌ Saque acima do limite
```
Enter amount for withdraw: 400.00
Withdraw error: The amount exceeds withdraw limit
```

### ❌ Saque acima do saldo
```
Enter amount for withdraw: 250.00
Withdraw error: Not enough balance
```

### ❌ Saque maior que o limite e o saldo
```
Enter amount for withdraw: 800.00
Withdraw error: The amount exceeds withdraw limit
```

---

## 🧠 Estrutura do projeto

```
Tratamento de exceções/
├── model/
│   ├── entities/
│   │   └── Account.java
│   └── exceptions/
│       └── DomainException.java
├── Main.java
```

---

## 🚀 Como executar

1. Clone o repositório:
```bash
git clone https://github.com/guilhermeguerradev/CursoJava.git
```

2. Navegue até a pasta do projeto:
```bash
cd CursoJava/Tratamento\ de\ exceções/ExceptionBank
```

3. Compile e execute com o Java:
```bash
javac model/entities/Account.java model/exceptions/DomainException.java Main.java
java Main
```

---

## 🛠️ Tecnologias usadas

- Java 17+
- Paradigma Orientado a Objetos
- Tratamento de Exceções

---

## 📎 Link do projeto

🔗 [Acesse no GitHub](https://github.com/guilhermeguerradev/CursoJava/tree/main/Tratamento%20de%20exce%C3%A7%C3%B5es/ExceptionBank)

---

## 👨‍💻 Autor

Desenvolvido por [Guilherme Guerra](https://github.com/guilhermeguerradev)