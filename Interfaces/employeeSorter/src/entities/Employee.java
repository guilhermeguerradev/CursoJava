package entities;

// A classe Employee implementa a interface Comparable<Employee>,
// o que permite que objetos dessa classe sejam comparados entre si
// com base em uma lógica de ordenação definida no método compareTo.
public class Employee implements Comparable<Employee> {

    private String name;
    private Double salary;

    // Construtor da classe que recebe nome e salário.
    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters e setters padrão para acessar e modificar os atributos.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // Este é o método exigido pela interface Comparable.
    // Ele define a forma como dois objetos Employee serão comparados.
    // Neste caso, a comparação é feita com base no nome, em ordem alfabética.
    @Override
    public int compareTo(Employee other) {
        // name.compareTo(...) retorna:
        // - valor negativo se o nome atual vem antes do outro;
        // - zero se são iguais;
        // - valor positivo se vem depois.
        return name.compareTo(other.getName());
    }
}
