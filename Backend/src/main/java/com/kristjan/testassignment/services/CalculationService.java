package com.kristjan.testassignment.services;

import com.kristjan.testassignment.dto.CalculationDTO;
import com.kristjan.testassignment.repository.CalculationDataAccessService;
import com.kristjan.testassignment.dto.CalculationList;
import com.kristjan.testassignment.model.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalculationService {

    @Autowired
    private final CalculationDataAccessService calculationDataAccessService;

    public CalculationService(CalculationDataAccessService calculationDataAccessService) {
        this.calculationDataAccessService = calculationDataAccessService;
    }


    public Map<String, Double> addOperation(Double num1, Double num2, String op){
        double calculationResult;
        switch (op) {
            case "sum":
                calculationResult = num1 + num2;
                break;
            case "sub":
                calculationResult = num1 - num2;
                break;
            case "div":
                calculationResult = num1 / num2;
                break;
            case "prod":
                calculationResult = num1 * num2;
                break;
            default:
                throw new IllegalArgumentException("No operand found");
        }
        Calculation calculation = new Calculation(num1, num2, op, calculationResult);
        calculationDataAccessService.save(calculation);
        HashMap<String, Double> result = new HashMap<>();
        result.put("calculationResult", calculationResult);
        return result;
    }


    public CalculationList getAllCalculations() {
        ArrayList<Calculation> calculationsQuery = new ArrayList<>();
        calculationDataAccessService.findAll().forEach(calculationsQuery::add);
        CalculationList calculationList = new CalculationList();
        for (int i = 0; i < calculationsQuery.size(); i++) {
            CalculationDTO currentCalculation = new CalculationDTO(i, calculationsQuery.get(i).getNumber1(), calculationsQuery.get(i).getOperand(), calculationsQuery.get(i).getNumber2(), calculationsQuery.get(i).getCalculationResult());
            calculationList.add(currentCalculation);
        }
        return calculationList;

    }

}
