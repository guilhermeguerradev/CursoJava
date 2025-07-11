
# 🧠 Programação Funcional e Expressões Lambda em Java

Este projeto faz parte dos meus estudos de **Programação Funcional** em Java. O foco principal foi entender e aplicar **expressões lambda**, **interfaces funcionais** e o uso de **streams** para manipulação de dados de forma concisa e eficiente.

---

## 📌 Objetivo

Demonstrar como utilizar os recursos da programação funcional em Java para escrever código mais limpo, enxuto e expressivo. O projeto mostra como aplicar funções diretamente em coleções de dados com **streams**, **métodos de referência**, **funções anônimas**, entre outros recursos modernos da linguagem.

---

## 📚 O que eu aprendi

✅ O que são **expressões lambda** e como utilizá-las.  
✅ Como declarar e usar **interfaces funcionais**.  
✅ O uso da **interface Predicate**, **Function**, **Consumer**, etc.  
✅ Como usar **métodos de referência** (`Class::method`) para deixar o código mais limpo.  
✅ Como utilizar o **Stream API** para filtragem, transformação e agregação de dados.  
✅ Fundamentos do **paradigma funcional**.  
✅ Conceito de **pipeline** e **short-circuit** no fluxo de dados.

---

## 🧬 Fundamentos da Programação Funcional

A **programação funcional** é baseada no **Cálculo Lambda** (Church, 1930) e trata a computação como a avaliação de funções matemáticas, evitando mudanças de estado e dados mutáveis.

### 🔄 Comparativo entre Paradigmas

| Característica                            | Programação Imperativa | Programação Funcional |
|------------------------------------------|-------------------------|------------------------|
| Estilo                                   | "Como fazer"            | "O que fazer"          |
| Elemento principal                       | Comandos                | Expressões             |
| Transparência referencial                | Fraca                   | Forte                  |
| Objetos imutáveis                        | Raro                    | Comum                  |
| Funções como objetos de primeira ordem   | Não                     | Sim                    |
| Expressividade / código conciso          | Baixa                   | Alta                   |
| Tipagem dinâmica / inferência de tipos   | Raro                    | Comum                  |

---

## 🧩 Interfaces Funcionais e Stream API na prática

#### ✅ `Predicate<T>`

Representa uma **função que recebe um valor e retorna `true` ou `false`**. Muito usada com `filter()` ou `removeIf()`:

```java
Predicate<Product> expensive = p -> p.getPrice() >= 2000.0;
list.removeIf(expensive);
```

---

#### 🔄 `Function<T, R>`

Recebe um valor do tipo `T` e **retorna um valor do tipo `R`**. Usada em transformações como `map()`:

```java
Function<Product, String> getName = p -> p.getName();
List<String> names = list.stream().map(getName).collect(Collectors.toList());
```

---

#### 🔁 `Consumer<T>`

Recebe um valor do tipo `T` e **executa uma ação** (sem retorno). Usada com `forEach()`:

```java
Consumer<Product> printUpper = p -> System.out.println(p.getName().toUpperCase());
list.forEach(printUpper);
```

---

### 📌 Métodos de referência

Métodos de referência (`Class::method`) são uma forma mais limpa e direta de escrever funções já existentes.

```java
// Lambda tradicional
.map(p -> p.getName())

// Método de referência
.map(Product::getName)
```

```java
// Lambda
.forEach(p -> System.out.println(p))

// Referência
.forEach(System.out::println)
```

---

## 🌊 Trabalhando com Streams

- Uma **stream** é uma sequência de elementos derivada de uma fonte de dados (coleção, array, E/S, etc.).
- Características:
  - ✅ **Declarativa** (itera internamente)
  - ✅ **Parallel-friendly** (imutável e thread-safe)
  - ✅ **Sem efeitos colaterais**
  - ✅ **Lazy evaluation** (sob demanda)
  - ✅ **Single-use**
  - ✅ **Acesso sequencial**
  - ✅ **Encadeável via pipeline**

---

### 🔗 O que é Pipeline?

Um **pipeline** é uma sequência encadeada de operações em uma stream, onde **cada etapa transforma ou filtra os dados** até que uma operação terminal seja chamada.

As etapas do pipeline são divididas em:
- **Operações intermediárias** (ex: `filter`, `map`, `sorted`) → retornam uma nova stream
- **Operação terminal** (ex: `forEach`, `collect`, `reduce`) → finaliza o pipeline e produz um resultado

Exemplo:
```java
List<String> result = list.stream()
    .filter(s -> s.startsWith("A"))
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());
```

---

### ⚡ O que é *Short-circuit*?

Uma operação **short-circuit** interrompe o fluxo da stream **antes de processar todos os elementos**, assim que uma condição é satisfeita — o que melhora a performance.

#### Exemplos:

```java
// anyMatch: para ao encontrar o primeiro que satisfaz
products.stream().anyMatch(p -> p.getPrice() > 3000.0);

// limit: pega os 5 primeiros apenas
list.stream().limit(5).forEach(System.out::println);

// findFirst: retorna o primeiro resultado que passa no filtro
Optional<Product> result = products.stream()
    .filter(p -> p.getPrice() > 2000.0)
    .findFirst();
```

---

### 🧪 Filtrar, Transformar e Agregar com Stream API

#### 🎯 Filtrar (`filter`)
```java
List<Product> cheap = list.stream()
    .filter(p -> p.getPrice() < 1000.0)
    .collect(Collectors.toList());
```

#### 🔄 Transformar (`map`)
```java
List<String> names = list.stream()
    .map(Product::getName)
    .collect(Collectors.toList());
```

#### ➕ Agregar (`reduce`)
```java
double total = list.stream()
    .map(Product::getPrice)
    .reduce(0.0, Double::sum);
```

---

## 💡 Exemplo de funcionamento

```java
List<Product> products = new ArrayList<>();
products.add(new Product("Notebook", 2500.0));
products.add(new Product("Smartphone", 1800.0));

// Filtra produtos com preço abaixo de 2000
products.removeIf(p -> p.getPrice() >= 2000.0);

// Converte para nomes
List<String> names = products.stream()
    .map(Product::getName)
    .collect(Collectors.toList());

// Exibe os nomes em maiúsculas
products.forEach(p -> System.out.println(p.getName().toUpperCase()));
```

---

## 🛠️ Tecnologias usadas

- Java 17+
- Expressões Lambda
- Programação Funcional
- Stream API
- Interfaces Funcionais

---

## 📎 Link do projeto

🔗 [Acesse no GitHub](https://github.com/guilhermeguerradev/CursoJava/tree/main/Programa%C3%A7%C3%A3o%20funcional%20e%20express%C3%B5es%20lambda)

---

## 👨‍💻 Autor

Desenvolvido por [Guilherme Guerra](https://github.com/guilhermeguerradev)
