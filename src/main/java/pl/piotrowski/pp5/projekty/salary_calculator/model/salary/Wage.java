package pl.piotrowski.pp5.projekty.salary_calculator.model.salary;

public class Wage {
    private double cost;
    private double employerCost;

    public Wage(double cost, double employerCost) {
        this.cost = cost;
        this.employerCost = employerCost;
    }


    public double getCost() {
        return cost;
    }

    public double getEmployerCost() {
        return employerCost;
    }
}
