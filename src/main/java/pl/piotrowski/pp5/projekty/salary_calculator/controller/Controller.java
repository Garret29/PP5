package pl.piotrowski.pp5.projekty.salary_calculator.controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import pl.piotrowski.pp5.projekty.salary_calculator.model.EmployerCostService;
import pl.piotrowski.pp5.projekty.salary_calculator.model.SalaryService;
import pl.piotrowski.pp5.projekty.salary_calculator.model.salary.Wage;

public class Controller {
    public Label nettoLabel;
    public Label bruttoLabel;
    public Label kosztLabel;


    public MenuItem contractButton;
    public MenuItem employmentButton;
    public MenuItem orderButton;
    public TextField grossField;


    public void calculateAction(ActionEvent actionEvent) {
        String dealType=null;
        Double gross;
        Wage result;
        Wage employerCost;
        SalaryService salaryService = new SalaryService();
        EmployerCostService employerCostService = new EmployerCostService();
        Object source = actionEvent.getSource();


        if (source.equals(contractButton)){
            dealType="contract";
        } else if (source.equals(employmentButton)){
            dealType="order contract";
        } else if (source.equals(orderButton)){
            dealType="employment contract";
        }

        gross = Double.parseDouble(grossField.getText());


        result = salaryService.calculateSalaryGrossToNet(dealType, gross);
        employerCost = employerCostService.calculateEmployerCost(dealType, gross);

        nettoLabel.setText(String.valueOf(result.getCost()));
        bruttoLabel.setText(String.valueOf(gross));
        kosztLabel.setText(String.valueOf(employerCost.getCost()));

    }
}
