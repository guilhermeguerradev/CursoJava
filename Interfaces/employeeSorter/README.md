# 👥 Employee Sorter em Java

Projeto simples para demonstrar ordenação de objetos `Employee` utilizando `Comparable` e `Comparator`.

---

## 📌 Objetivo

Permitir ordenar listas de funcionários (`Employee`) por diferentes critérios:

- Por nome (alfabeticamente)
- Por salário (crescente ou decrescente)

---

## ⚙️ Estrutura do projeto

```
employeeSorter/
├── entities/
│   └── Employee.java         // classe com nome e salário
├── comparators/
│   ├── EmployeeNameComparator.java
│   └── EmployeeSalaryComparator.java
├── application/
│   └── Program.java         // demonstra diferentes ordenações
└── README.md                // este arquivo
```

---

## 🛠️ Tecnologias e conceitos usados

- Java 17+  
- Interface `Comparable<Employee>`  
- Interfaces `Comparator<Employee>` para múltiplos critérios  
- Coleções (`List`) e `Collections.sort()`

---

## 🚀 Como executar

1. Compile os arquivos Java:
   ```bash
   javac application/Program.java
   ```
2. Execute o programa:
   ```bash
   java application.Program
   ```
3. Observe no console a lista de `Employee` ordenada por nome e salário.

---

## 👨‍💻 Autor

Desenvolvido por **Guilherme Guerra**