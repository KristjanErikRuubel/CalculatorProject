package com.kristjan.testassignment.dto;
import java.util.ArrayList;
import java.util.List;


public class CalculationList {
    private List<CalculationDTO> calculations;

    public List<CalculationDTO> getCalculations() {
        return calculations;
    }

    public CalculationList() {
        calculations = new ArrayList<>();
    }

    public void add(CalculationDTO currentOperation) {
        calculations.add(currentOperation);

    }
}
