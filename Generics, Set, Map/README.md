# 🧩 Generics, Set e Map em Java

Este projeto faz parte dos meus estudos de **coleções e programação genérica** em Java. Aqui explorei o uso de `Generics`, `Set` e `Map` para escrever código mais reutilizável, seguro e eficiente.

---

## 📌 Objetivo

Demonstrar de forma prática o uso de **tipos genéricos**, coleções do tipo **Set** (sem elementos repetidos) e estruturas do tipo **Map** (pares chave/valor), além de destacar a importância de `equals` e `hashCode` em coleções.

---

## 📚 O que eu aprendi

✅ Como criar **métodos e classes genéricas**  
✅ Diferença entre `HashSet`, `TreeSet` e `LinkedHashSet`  
✅ Uso de `Map` com diferentes tipos de chave/valor  
✅ Implementação e importância de `equals` e `hashCode`  
✅ Métodos úteis para manipular `Set` e `Map`  
✅ Como funcionam wildcards (`?`), bounded wildcards, covariância e contravariância  
✅ Princípio Get/Put para collections  

---

## 💡 Exemplos práticos

### 🔹 Classe Genérica

```java
public class PrintService<T> {
    private List<T> list = new ArrayList<>();

    public void addValue(T value) {
        list.add(value);
    }

    public T first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }

    public void print() {
        System.out.println(list);
    }
}


## 🧬 Generics

Os **Generics** permitem que classes, interfaces e métodos sejam **parametrizados por tipo**.

### ✅ Benefícios:
- ♻️ **Reuso**
- 🔒 **Type safety**
- ⚡ **Performance**
- 📦 **Uso comum**: coleções (`List<T>`, `Set<T>`, `Map<K,V>`)

---

## ⚠️ Generics são invariantes

- `List<Object>` **não é** supertipo de `List<String>`, `List<Integer>`, etc.
- O supertipo correto é `List<?>` (tipo curinga).

```java
public void imprimirLista(List<?> lista) {
    for (Object item : lista) {
        System.out.println(item);
    }
}
```

> 🔴 Não é possível adicionar elementos a `List<?>`

---

## ❓ Tipos Curinga (`?`)

Permitem métodos que recebem listas de qualquer tipo:

```java
public void exibir(List<?> lista) {
    for (Object obj : lista) {
        System.out.println(obj);
    }
}
```

🔴 **Não é possível adicionar** elementos (exceto `null`)  
🟢 Útil para leitura de dados genéricos

---

## 🧭 Genéricos Delimitados (Bounded Types)

Você pode restringir o tipo genérico com `extends`:

```java
public static <T extends Comparable<T>> T max(List<T> list) {
    T maior = list.get(0);
    for (T item : list) {
        if (item.compareTo(maior) > 0) {
            maior = item;
        }
    }
    return maior;
}
```

---

## 🔄 Curingas Delimitados

### 🔹 Covariância – `? extends T`

- ✅ Leitura segura
- ❌ Escrita não permitida
- Exemplo: `List<? extends Number>` aceita `List<Integer>`, `List<Double>`

```java
public double soma(List<? extends Number> lista) {
    double soma = 0.0;
    for (Number n : lista) {
        soma += n.doubleValue();
    }
    return soma;
}
```

---

### 🔸 Contravariância – `? super T`

- ✅ Escrita segura (pode adicionar `T`)
- ❌ Leitura insegura (retorna como `Object`)
- Exemplo: `List<? super Integer>` aceita `List<Integer>`, `List<Number>`, `List<Object>`

```java
public void inserir(List<? super Integer> lista) {
    lista.add(10);
}
```

---

### 📌 Princípio Get/Put

```text
<? extends T> → só leitura (get)
<? super T>   → só escrita (put)
```

---

## 🔍 Detalhes sobre `Set` e `Map`

### 🔸 `Set<T>`

- Não permite repetições
- Usa `equals` e `hashCode` para comparar
- Se não sobrescrever, compara por **referência (ponteiro)**

#### Métodos úteis:
- `add`, `remove`, `contains`, `clear`, `size`, `removeIf`
- `addAll` (união), `retainAll` (interseção), `removeAll` (diferença)

---

### 🔸 `Map<K, V>`

- Coleção de pares **chave/valor**
- **Chave não pode se repetir**
- Também usa `equals` e `hashCode`

#### Métodos úteis:
- `put`, `get`, `remove`, `containsKey`, `clear`, `size`
- `keySet()` → retorna `Set<K>`
- `values()` → retorna `Collection<V>`

---

## 🧠 hashCode e equals

### 📌 Para coleções funcionarem corretamente:

- `hashCode()` → rápido, mas pode colidir  
- `equals()` → mais lento, mas garante comparação precisa  

```java
@Override
public boolean equals(Object obj) { ... }

@Override
public int hashCode() { ... }
```

🔒 Tipos como `String`, `Integer`, `Double` já implementam corretamente.  
📌 **Classes personalizadas devem sobrescrever ambos**.

---

### 🧪 Como coleções Hash comparam objetos

- Primeiro comparam o **hashCode**
- Se iguais, comparam usando **equals**
- Se `equals/hashCode` não forem implementados, comparam por **referência**

---

### 🟨 Regra de ouro do `hashCode`

```text
hashCode diferente → objetos diferentes ✔️
hashCode igual     → pode ser iguais (usa equals para confirmar)
```

> Pode haver **colisão**: dois objetos diferentes com mesmo `hashCode`

---

## 🛠️ Tecnologias usadas

- Java 17+
- Generics
- Collections Framework (`Set`, `Map`)
- Programação Orientada a Objetos

---

## 📎 Link do projeto

🔗 [Acesse no GitHub](https://github.com/guilhermeguerradev/CursoJava/tree/main/Generics%2C%20Set%2C%20Map)

---

## 👨‍💻 Autor

Desenvolvido por [Guilherme Guerra](https://github.com/guilhermeguerradev)
