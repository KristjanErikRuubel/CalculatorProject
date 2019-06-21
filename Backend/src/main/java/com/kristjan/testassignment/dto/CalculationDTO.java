package com.kristjan.testassignment.dto;

import java.io.Serializable;

public class CalculationDTO implements Serializable {

    private int id;

    private Double number1;

    private Double number2;

    private String operand;

    private Double calculationResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getNumber1() {
        return number1;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }

    public Double getCalculationResult() {
        return calculationResult;
    }

    public void setCalculationResult(Double calculationResult) {
        this.calculationResult = calculationResult;
    }

    public Double getNumber2() {
        return number2;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }


    public CalculationDTO() {
    }

    public CalculationDTO(int id, Double number1, String operand, Double number2, Double calculationResult) {
        this.id = id;
        this.number1 = number1;
        this.number2 = number2;
        this.operand = operand;
        this.calculationResult = calculationResult;
    }

}
