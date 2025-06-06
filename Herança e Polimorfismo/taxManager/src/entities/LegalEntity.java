package entities;

public class LegalEntity extends Person{
    private Integer employeeCount;

    public LegalEntity(){
        super();
    }

    public LegalEntity(String name, Double annualIncome, Integer employeeCount) {
        super(name, annualIncome);
        this.employeeCount = employeeCount;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public Double calculateTax() {
        if (employeeCount > 10) {
            return (getAnnualIncome() * 14 / 100);
        } else {
            return (getAnnualIncome() * 16 / 100);
        }
    }
}
