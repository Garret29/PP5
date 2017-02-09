package pl.piotrowski.pp5.projekty.salary_calculator.model;

import pl.piotrowski.pp5.projekty.salary_calculator.model.salary.ContractTaxCalculation;
import pl.piotrowski.pp5.projekty.salary_calculator.model.salary.EmploymentContractTaxCalculation;
import pl.piotrowski.pp5.projekty.salary_calculator.model.salary.OrderContractTaxCalculation;
import pl.piotrowski.pp5.projekty.salary_calculator.model.salary.Wage;

import java.util.Objects;

public class SalaryService {
    public Wage calculateSalaryGrossToNet(String dealType, double gross) {
        Wage wage;

        if (Objects.equals(dealType, "contract")) {
            ContractTaxCalculation calculation = new ContractTaxCalculation();
            wage = calculation.calculateFromGrossValue(gross);
        } else if (Objects.equals(dealType, "order contract")) {
            OrderContractTaxCalculation calculation = new OrderContractTaxCalculation();
            wage = calculation.calculateFromGrossValue(gross);
        } else if (Objects.equals(dealType, "employment contract")) {
            EmploymentContractTaxCalculation calculation = new EmploymentContractTaxCalculation();
            wage = calculation.calculateFromGrossValue(gross);
        } else {
            wage = null;
        }
        return wage;
    }
}
