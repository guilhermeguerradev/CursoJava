# 🗄️ Acesso ao Banco de Dados com JDBC

Este projeto faz parte dos meus estudos de **Java com acesso a banco de dados** utilizando **JDBC (Java Database Connectivity)**. Aqui eu aprendi como conectar uma aplicação Java a um banco MySQL, realizar operações de CRUD (Create, Read, Update, Delete), e aplicar boas práticas como uso de DAO (Data Access Object), padrão Factory, e tratamento de exceções.

---

## 📌 Objetivo

Implementar um sistema de acesso a dados com:

- Conexão segura com banco de dados MySQL.
- Inserção, busca, atualização e remoção de dados.
- Uso de classes DAO para encapsular a lógica de acesso.
- Tratamento robusto de erros com exceções personalizadas.
- Uso de boas práticas como reaproveitamento de conexões e separação de responsabilidades.

---

## 📚 O que eu aprendi

### 🔌 Conexão com o Banco de Dados

✅ Como usar o `DriverManager.getConnection()` para estabelecer uma conexão com o banco de dados MySQL.  
✅ Criação e uso correto de `PreparedStatement` para evitar SQL Injection e tornar o código mais seguro.  
✅ Criação e uso de `Statement` e recuperação de chaves primárias geradas com `RETURN_GENERATED_KEYS`.  
✅ Leitura de dados usando `ResultSet`, com comandos como:  
- `next()` — percorre os resultados linha por linha.  
- `first()` e `beforeFirst()` — controlam a posição do cursor.  
- `absolute(n)` — acessa diretamente uma linha específica.  

---

### 🧹 Boas práticas com recursos

✅ Como fechar corretamente conexões, statements e result sets utilizando métodos utilitários da classe `DB`.  
✅ Criação de uma classe `DB` com métodos estáticos reutilizáveis para gerenciar recursos de conexão.  

---

### ⚠️ Tratamento de erros

✅ Como capturar e tratar erros usando `try-catch` com `SQLException`.  
✅ Criação de exceções personalizadas como `DbException` e `DbIntegrityException`, para melhorar a legibilidade e o controle de erros do sistema.  
✅ Implementação de controle de transações com `setAutoCommit(false)`, `commit()` e `rollback()` para garantir integridade dos dados.

---

### 🗃️ Padrão DAO e boas práticas de arquitetura

✅ Implementação do padrão de projeto **DAO (Data Access Object)**, que organiza a lógica de acesso a dados separadamente da lógica de negócio.  
✅ Criação de uma **interface DAO** para cada entidade (`SellerDao`, `DepartmentDao`), com métodos como `insert`, `update`, `deleteById`, `findById` e `findAll`.  
✅ Implementação concreta dessas interfaces (`SellerDaoJDBC`, `DepartmentDaoJDBC`) com código SQL.  
✅ Uso do padrão **Factory** para criar instâncias de DAO com a classe `DaoFactory`, permitindo desacoplamento e facilidade de manutenção.  

---

### 🧠 Mapeamento Objeto-Relacional (ORM Manual)

✅ Como transformar linhas de uma tabela SQL (por exemplo, `seller`) em objetos Java.  
✅ Como associar objetos relacionados, como `Seller` contendo um `Department`.  
✅ Como escrever consultas SQL com `JOIN` para carregar objetos compostos a partir de múltiplas tabelas.  
✅ Entendimento de que o SQL retorna os dados em formato de **tabela**, com linhas e colunas, mas que no paradigma da **programação orientada a objetos**, precisamos transformar essas linhas em **objetos associados**.  
Por exemplo: uma consulta que retorna dados de `seller` e `department` (usando `JOIN`) será transformada em um objeto `Seller` que possui internamente um objeto `Department`.  
Esse processo de "tradução" é chamado de **mapeamento objeto-relacional manual** e é feito programaticamente com `ResultSet` e os métodos setters.

---

### 🧱 Boas práticas com entidades Java

✅ Como criar classes de entidade completas com:
- Atributos privados  
- Construtores (com e sem argumentos)  
- Métodos `get` e `set`  
- Implementação de `hashCode()` e `equals()` para uso em coleções  
- Método `toString()` para facilitar debug  
- Interface `Serializable` para suporte a serialização

---

### 🛠️ Organização do projeto

✅ Separação do projeto em pacotes lógicos:
- `db` para utilitários de banco e exceções  
- `model.entities` para as classes de domínio  
- `model.dao` para as interfaces DAO  
- `model.dao.impl` para as implementações com JDBC  
- `application` para o programa principal  
- `DaoFactory` para gerar instâncias dos DAOs de forma centralizada

---


---

## 🧩 Por que usar o padrão DAO e DaoFactory

### 📌 O que é o padrão DAO (Data Access Object)?

O DAO é um padrão de projeto que separa a **lógica de acesso ao banco de dados** da **lógica de negócio** da aplicação.

> Em vez de misturar comandos SQL espalhados pelo código da aplicação, centralizamos tudo em classes responsáveis só por acessar e manipular os dados.

---

### ✅ Vantagens de usar DAO:

- **Organização e manutenção**: toda lógica de banco fica isolada em um único lugar.
- **Reutilização**: o mesmo DAO pode ser usado em várias partes do sistema.
- **Facilidade de teste**: podemos simular (mockar) DAOs para testar a lógica de negócio sem depender de banco.
- **Troca de tecnologia**: se quiser trocar JDBC por JPA no futuro, só as implementações DAO mudam — a lógica do programa continua igual.

---

### 🏗️ Estrutura aplicada no projeto:


```
dao/
├── impl/
│   ├── DepartmentDaoJDBC.java
│   └── SellerDaoJDBC.java
├── DaoFactory.java
├── DepartmentDao.java
└── SellerDao.java
```

Essa estrutura segue boas práticas:

- As **interfaces** `DepartmentDao` e `SellerDao` definem **o contrato** de cada operação (ex: `findById`, `insert`, `deleteById`).
- As classes em `impl/` (`DepartmentDaoJDBC` e `SellerDaoJDBC`) são **as implementações concretas usando JDBC**.
- Isso permite que futuramente você crie outras implementações (ex: `DepartmentDaoHibernate`) sem mudar a lógica principal do sistema.

---

### 🏭 Por que usar uma DaoFactory?

A classe `DaoFactory` centraliza a criação dos objetos DAO, encapsulando as dependências e facilitando a **injeção de dependência manual**.

```java
public class DaoFactory {
    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
```

#### Benefícios da DaoFactory:

- **Evita acoplamento direto** entre a camada de aplicação e as implementações concretas dos DAOs.
- Permite **instanciar as dependências** em um único ponto de entrada.
- Facilita a troca da implementação sem alterar a aplicação principal.
- Segue o princípio SOLID de **inversão de dependência** (DIP).

---

### 📌 Conclusão

Ao aplicar o padrão DAO + Factory, o projeto fica mais limpo, modular, reutilizável e pronto para crescer sem virar uma bagunça. Essa é uma das arquiteturas mais utilizadas em sistemas corporativos que usam JDBC e serve de base para frameworks mais robustos como JPA e Spring Data.


## 💡 Exemplo de funcionamento

### Inserção com recuperação do ID gerado:

```java
PreparedStatement st = conn.prepareStatement(
    "INSERT INTO department (Name) VALUES (?)", 
    Statement.RETURN_GENERATED_KEYS);

st.setString(1, obj.getName());
int rowsAffected = st.executeUpdate();

if (rowsAffected > 0) {
    ResultSet rs = st.getGeneratedKeys();
    if (rs.next()) {
        int id = rs.getInt(1);
        obj.setId(id);
    }
}
```

### Mapeamento de objetos com relacionamento:

Consulta SQL com `JOIN`:

```sql
SELECT seller.*, department.Name as DepName
FROM seller
INNER JOIN department ON seller.DepartmentId = department.Id
WHERE seller.Id = ?
```

Resultado transformado em objetos associados:

- Um objeto `Seller` contendo um objeto `Department` correspondente.

---

## 🧠 Estrutura do projeto

```
Acesso ao banco de dados com JDBC/
├── db/
│   ├── DB.java
│   ├── DbException.java
│   └── DbIntegrityException.java
├── model/
│   ├── dao/
│   │   ├── DepartmentDao.java
│   │   └── SellerDao.java
│   ├── entities/
│   │   ├── Department.java
│   │   └── Seller.java
│   └── dao/impl/
│       ├── DepartmentDaoJDBC.java
│       └── SellerDaoJDBC.java
├── application/
│   └── Program.java
├── DaoFactory.java
```

---

## 🛠️ Tecnologias usadas

- Java 17+
- JDBC
- MySQL
- DAO Pattern
- Padrão Factory
- Programação Orientada a Objetos
- Tratamento de Exceções

---

## 📎 Link do projeto

🔗 [Acesse no GitHub](https://github.com/guilhermeguerradev/CursoJava/tree/main/Acesso%20ao%20banco%20de%20dados%20com%20JDBC)

---

## 👨‍💻 Autor

Desenvolvido por [Guilherme Guerra](https://github.com/guilhermeguerradev)