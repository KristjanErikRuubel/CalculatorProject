package com.kristjan.testassignment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculationDTOJson {

    public Double getNum1() {
        return num1;
    }

    public String getOp() {
        return op;
    }

    public Double getNum2() {
        return num2;
    }

    private Double num1;


    private String op;


    private Double num2;

    public CalculationDTOJson(@JsonProperty("num1") Double num1,
                              @JsonProperty("op") String operand,
                              @JsonProperty("num2") Double number2) {
        this.num1 = num1;
        this.op = operand;
        this.num2 = number2;
    }
}
