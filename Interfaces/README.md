# 🧩 Interfaces em Java

Este projeto faz parte dos meus estudos sobre **interfaces e orientação a objetos em Java**. O foco foi entender como **interfaces podem ser usadas para definir contratos de comportamento**, além de aplicar os conceitos de **injeção de dependência** e **inversão de controle (IoC)** na prática.

---

## 📌 Objetivo

Implementar um sistema que calcula parcelas de um contrato usando diferentes estratégias de pagamento. A lógica de pagamento é abstraída por meio de uma **interface**, permitindo flexibilidade e baixo acoplamento entre as classes.

---

## 📚 O que eu aprendi

✅ Criação de **interfaces** para definir comportamentos genéricos (`OnlinePaymentService`)  
✅ Implementação concreta de regras de negócio (`PaypalService`)  
✅ **Inversão de controle (IoC)** para desacoplar serviços de suas implementações  
✅ **Injeção de dependência via construtor** para fornecer os serviços de forma flexível  
✅ Organização da lógica de negócio em serviços (`ContractService`)  
✅ Criação de entidades com encapsulamento (`Contract`, `Installment`)  


---

## 💡 Exemplo de funcionamento

**Entrada via console:**
```
Número: 123
Data (dd/MM/yyyy): 01/07/2025
Valor do contrato: 600.00
Número de parcelas: 3
```

**Saída esperada:**
```
Parcelas:
01/08/2025 - 206.04
01/09/2025 - 208.08
01/10/2025 - 210.12
```

---

## 🧠 Estrutura do projeto

```
Interfaces/
├── model/
│   └── services/
│       ├── OnlinePaymentService.java
│       ├── PaypalService.java
│       └── ContractService.java
├── model/
│   └── entities/
│       ├── Contract.java
│       └── Installment.java
└── Main.java
```

---

## 🚀 Como executar

Compile os arquivos:
```bash
javac model/entities/*.java model/services/*.java Main.java
```

Execute o programa:
```bash
java Main
```

---

## 🛠️ Tecnologias usadas

- Java 17+  
- Programação orientada a objetos (POO)  
- Interfaces e polimorfismo  
- Injeção de dependência  
- API de datas (`java.time.LocalDate`)

---

## 👨‍💻 Autor

Desenvolvido por **Guilherme Guerra**