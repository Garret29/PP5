package pl.piotrowski.pp5.projekty.salary_calculator.model.salary;

public class ContractTaxCalculation {
    private final double TAX_1 = 0.18;
    private final double COST_1 = 0.5;

    public Wage calculateFromGrossValue(double gross) {

        double costs = calculateIncomeCosts(gross);
        double taxBase = calculateTaxBase(gross, costs);
        double tax = calculateTaxValue(taxBase);

        return new Wage((double) Math.round(gross-tax), gross);
    }

    private double calculateIncomeCosts(double gross) {
        return gross * COST_1;
    }

    private double calculateTaxValue(double taxBase) {
        return taxBase * TAX_1;
    }

    private double calculateTaxBase(double gross, double costs) {
        return gross - costs;
    }
}
