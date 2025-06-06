package entities;

public class Individual extends Person  {

    private Double medicalExpenses;

    public Individual() {
        super();
    }

    public Individual(String name, Double annualIncome, Double medicalExpenses) {
        super(name, annualIncome);
        this.medicalExpenses = medicalExpenses;
    }

    public Double getMedicalExpenses() {
        return medicalExpenses;
    }

    public void setMedicalExpenses(Double medicalExpenses) {
        this.medicalExpenses = medicalExpenses;
    }

    @Override
    public Double calculateTax() {
        if (getAnnualIncome() < 20000) {
            return ( getAnnualIncome() * 15 / 100 ) - (medicalExpenses * 50 / 100);
        } else {
            return ( getAnnualIncome() * 25 / 100 ) - (medicalExpenses * 50 / 100);
        }
    }

}
