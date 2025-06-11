
# 🧾 Sales Summary Generator em Java

Este projeto faz parte dos meus estudos sobre **manipulação de arquivos em Java**. O foco principal foi o aprendizado prático da leitura e escrita de arquivos CSV, criação de diretórios dinamicamente e processamento de dados com listas.

---

## 📌 Objetivo

Ler um arquivo CSV contendo os dados de produtos (nome, preço e quantidade), calcular o valor total de cada item e gerar um novo arquivo `summary.csv` com os resultados finais organizados.

O projeto também demonstra como criar um diretório de saída (`out`) e armazenar o novo arquivo com os valores já processados.

---

## 📚 O que eu aprendi

✅ Leitura de arquivos linha a linha com `BufferedReader`  
✅ Escrita de arquivos com `BufferedWriter`  
✅ Criação de diretórios com `Files.createDirectory(...)`  
✅ Uso de `ArrayList` para armazenar objetos dinamicamente  
✅ Processamento de strings com `.split(",")`  
✅ Conversão de valores e formatação com `String.format("%.2f", ...)`  
✅ Uso do bloco `try-with-resources` para garantir o fechamento automático dos arquivos  
✅ Uso da classe `File` para manipular diretórios e arquivos (getPath, getParent, getName)  
✅ Listagem de arquivos e pastas com `listFiles()` e filtros (`File::isDirectory`, `File::isFile`)  
✅ Criação de diretórios com `mkdir()` usando caminhos dinâmicos  
✅ Diferença entre `FileReader` e `BufferedReader` (bufferização melhora performance de leitura)  
✅ Leitura de arquivos usando `Scanner(file)` como alternativa ao `BufferedReader`  
✅ Acesso à documentação oficial da Oracle e ao StackOverflow para consulta de dúvidas

---

## 💡 Exemplo de funcionamento

**Entrada (`arquivo.csv`)**:

```
TV LED,1290.99,1
Video Game Chair,350.50,3
Iphone X,900.00,2
Samsung Galaxy 9,850.00,2
```

**Saída (`summary.csv`)**:

```
TV LED,1290.99
Video Game Chair,1051.50
Iphone X,1800.00
Samsung Galaxy 9,1700.00
```

> O valor total é calculado com a fórmula: `preço * quantidade`.

---

## 🧠 Estrutura do projeto

```
SalesSummaryGenerator/
├── src/
│   ├── model/
│   │   └── entities/
│   │       └── Product.java
│   └── Main.java
├── arquivo.csv
└── out/
    └── summary.csv
```

---

## 🚀 Como executar

Clone o repositório:  
```bash
git clone https://github.com/guilhermeguerradev/CursoJava.git
```

Navegue até a pasta do projeto:  
```bash
cd CursoJava/Trabalhando\ com\ arquivos/SalesSummaryGenerator
```

Compile e execute com:  
```bash
javac src/model/entities/Product.java src/Main.java
java Main
```

---

## 🛠️ Tecnologias usadas

- Java 17+  
- Manipulação de arquivos (`java.io`)  
- Estruturas de dados (`ArrayList`)  
- Formatação e parsing (`String`, `Double`, `Integer`)  
- Leitura com `Scanner`, `BufferedReader`, `FileReader`  
- Criação de diretórios e listagem com `File`

---

## 📎 Link do projeto

🔗 Acesse no GitHub: [SalesSummaryGenerator](https://github.com/guilhermeguerradev/CursoJava/tree/main/Trabalhando%20com%20arquivos/SalesSummaryGenerator)

---

## 👨‍💻 Autor

Desenvolvido por **Guilherme Guerra**
