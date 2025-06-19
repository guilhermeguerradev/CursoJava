# 🧩 Interfaces em Java

Este projeto faz parte dos meus estudos sobre **interfaces e orientação a objetos em Java**. O foco foi entender como **interfaces podem ser usadas para definir contratos de comportamento**, além de aplicar os conceitos de **polimorfismo**, **injeção de dependência** e resolver problemas de herança múltipla.

---

## 📌 Objetivo

Explorar as capacidades modernas das interfaces em Java:

- Definição de contratos via interfaces
- Uso de `default`, `static` e métodos `private` em interfaces
- Implementação de comportamentos reutilizáveis e extensíveis
- Aplicação prática de interfaces em diferentes projetos
- Entendimento e resolução do **problema do diamante**

---

## 📚 O que eu aprendi

✅ Criação de **interfaces** para definir comportamentos genéricos  
✅ Interfaces com **métodos default** para fornecer implementação reutilizável  
✅ Uso de **métodos estáticos** em interfaces como utilitários de contexto  
✅ Aplicação de **métodos privados** em interfaces para encapsular lógica auxiliar (Java 9+)  
✅ Implementação de **herança múltipla** de interfaces sem ambiguidade  
✅ **Problema do Diamante** resolvido com sobrescrita explícita  
✅ Interface `Comparable<T>` aplicada para ordenações customizadas  
✅ **Inversão de controle (IoC)** para desacoplar serviços de suas implementações  
✅ **Injeção de dependência via construtor** para fornecer os serviços de forma flexível  
✅ **Injeção de dependência** como prática para aumentar flexibilidade e testabilidade  

---

## 🛠️ Tecnologias usadas

- Java 17+  
- Programação orientada a objetos (POO)  
- Polimorfismo e interfaces  
- Métodos `default`, `static` e `private` em interfaces  
- Interface funcional `Comparable`  
- Reuso de código com interfaces  
- Princípios de Injeção de Dependência

---

## 📂 Projetos dentro da pasta `Interfaces`

Cada subpasta explora um aspecto específico:

- `comboDeviceDiamondProblem` → Herança múltipla e problema do diamante  
- `contractPaymentProcessor` → Inversão de controle, contrato de pagamento e **injeção de dependência via construtor**  
- `employeeSorter` → Uso da interface `Comparable` e ordenação customizada  
- `interestServiceApp` → Interface com método `default` para cálculo de juros  

---

## 👨‍💻 Autor

Desenvolvido por **Guilherme Guerra**
