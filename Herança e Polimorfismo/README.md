# 🧬 Herança e Polimorfismo em Java

Este projeto faz parte dos meus estudos de **Programação Orientada a Objetos (POO)** em Java. O foco principal foi o aprendizado dos conceitos de **herança** e **polimorfismo**, aplicados de forma prática através de exemplos simples e claros.

---

## 📌 Objetivo

Demonstrar como **classes genéricas (superclasses)** podem ser estendidas por **classes específicas (subclasses)**, aproveitando e sobrescrevendo comportamentos.

O projeto também mostra o uso do **polimorfismo**, permitindo que métodos possam se comportar de maneiras diferentes dependendo do tipo de objeto que os invoca, mesmo que esses objetos sejam tratados de forma genérica.

---

## 📚 O que eu aprendi

✅ Como criar **superclasses** e **subclasses**.  
✅ O uso da palavra-chave `extends`.  
✅ A sobrescrita de métodos com `@Override`.  
✅ O conceito de **upcasting** e **downcasting**.  
✅ O uso do **polimorfismo dinâmico**, com listas de objetos do tipo genérico chamando métodos específicos.

---

## 💡 Exemplo de funcionamento

No projeto, existe uma classe base `Person`, com os atributos comuns:

```java
public abstract class Person {
    private String name;
    private Double annualIncome;

    public abstract Double calculateTax();
}
```

E as classes que herdam de `Person`:

```java
public class Individual extends Person {
    private Double medicalExpenses;

    @Override
    public Double calculateTax() {
        // cálculo de imposto para pessoa física
    }
}
```

```java
public class Company extends Person {
    private Integer numberOfEmployees;

    @Override
    public Double calculateTax() {
        // cálculo de imposto para pessoa jurídica
    }
}
```

Ao armazenar objetos `Individual` e `Company` em uma lista de `Person`, o polimorfismo permite chamar o método `calculateTax()` corretamente, sem saber o tipo exato do objeto:

```java
List<Person> people = new ArrayList<>();
people.add(new Individual(...));
people.add(new Company(...));

for (Person p : people) {
    System.out.println(p.getName() + ": $ " + String.format("%.2f", p.calculateTax()));
}
```

---

## 🧠 Estrutura do projeto

```
Herança e Polimorfismo/
├── entities/
│   ├── Person.java
│   ├── Individual.java
│   └── Company.java
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
cd CursoJava/Herança\ e\ Polimorfismo
```

3. Compile e execute com:
```bash
javac entities/*.java Main.java
java Main
```

---

## 🛠️ Tecnologias usadas

- Java 17+
- Programação Orientada a Objetos (POO)
- Herança
- Polimorfismo

---

## 📎 Link do projeto

🔗 [Acesse no GitHub](https://github.com/guilhermeguerradev/CursoJava/tree/main/Heran%C3%A7a%20e%20Polimorfismo)

---

## 👨‍💻 Autor

Desenvolvido por [Guilherme Guerra](https://github.com/guilhermeguerradev)