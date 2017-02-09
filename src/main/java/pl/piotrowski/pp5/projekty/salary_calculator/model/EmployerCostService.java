package pl.piotrowski.pp5.projekty.salary_calculator.model;


import pl.piotrowski.pp5.projekty.salary_calculator.model.salary.ContractTaxCalculation;
import pl.piotrowski.pp5.projekty.salary_calculator.model.salary.OrderContractTaxCalculation;
import pl.piotrowski.pp5.projekty.salary_calculator.model.salary.Wage;
import pl.piotrowski.pp5.projekty.salary_calculator.model.salary.EmploymentContractTaxCalculation;

public class EmployerCostService {
    public Wage calculateEmployerCost(String dealType, double gross)
    {
        Wage wage;

        if (dealType.equals("contract")) {
            ContractTaxCalculation calc = new ContractTaxCalculation();
            wage = calc.calculateFromGrossValue(gross);
        } else if (dealType.equals("order contract")) {
            OrderContractTaxCalculation calc = new OrderContractTaxCalculation();
            wage = calc.calculateFromGrossValue(gross);
        } else if (dealType.equals("employment contract")) {
            EmploymentContractTaxCalculation calc = new EmploymentContractTaxCalculation();
            wage = calc.calculateFromGrossValue(gross);
        } else {
            wage = null;
        }

        return wage;
    }
}
