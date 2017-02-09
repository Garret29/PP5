package pl.piotrowski.pp5.projekty.salary_calculator.model.salary;

public class EmploymentContractTaxCalculation {
    private final double TAX_1 = 0.18;
    private final double PENSIONABLE = 0.0976;
    private final double ANNUITIES = 0.015;
    private final double SICKNESS = 0.0245;
    private final double REVENUE_COST = 111.25;
    private final double STANDARD_DEDUCTION = 46.33;
    private final double HEALTH_INSURANCE = 0.09;
    private final double DEDUCTED_HEALTH_INSURANCE = 0.0775;
    private final double DISABILITY_INCOME_INSURANCE = 0.065;
    private final double ACCIDENT_INSURANCE = 0.018;
    private final double LABOUR_FUND = 0.0245;
    private final double FOGWA = 0.001;


    public Wage calculateFromGrossValue(double gross){
        double pension = calculatePension(gross);
        double base = gross-pension;
        double taxBase = Math.round(calculateTaxBase(gross,pension));
        double tax = calculateTaxValue(taxBase);
        double taxDowngrade = tax-STANDARD_DEDUCTION;
        double completeHealthContribution = calculateCompleteHealthContribution(base);
        double healthContributionToDeduct = calculateHealthContributionToDeduct(base);
        double depositOnIncomeTax = calculatedDeposisOnIncomeTax(taxDowngrade,healthContributionToDeduct);

        return new Wage(Math.round(gross-pension-completeHealthContribution-depositOnIncomeTax), 0);
    }

    public Wage calculateFromNetValue(double net){
        double income = ( net - STANDARD_DEDUCTION -(REVENUE_COST*TAX_1))/(1-HEALTH_INSURANCE-TAX_1+DEDUCTED_HEALTH_INSURANCE);
        double gross = income / (1 - 0.1371);
        return new Wage(Math.round(gross), 0);
    }

    public Wage calculateEmployerCost(double gross) {
        double sum = gross * PENSIONABLE + DISABILITY_INCOME_INSURANCE + ACCIDENT_INSURANCE + LABOUR_FUND + FOGWA;
        return new Wage(gross, Math.round(gross + sum));
    }

    private double calculatePension(double gross) {
        return (gross * PENSIONABLE) + (gross * SICKNESS) + (gross * ANNUITIES);
    }

    private double calculateTaxBase(double gross, double pension) {
        return gross - pension - REVENUE_COST;
    }

    private double calculateTaxValue(double taxBase) {
        return taxBase * TAX_1;
    }

    private double calculateCompleteHealthContribution(double base) {
        return base * HEALTH_INSURANCE;
    }

    private double calculateHealthContributionToDeduct(double base) {
        return base * DEDUCTED_HEALTH_INSURANCE;
    }

    private int calculatedDeposisOnIncomeTax(double taxDowngrade, double healthContributionToDeduct) {
        return (int) Math.round(taxDowngrade - healthContributionToDeduct);
    }

}
