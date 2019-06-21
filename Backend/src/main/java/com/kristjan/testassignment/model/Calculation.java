package com.kristjan.testassignment.model;


import javax.persistence.*;


@Entity
@Table(name = "calulations")
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "number1", nullable = false)
    private Double number1;

    @Column(name = "number2", nullable = false)
    private Double number2;

    @Column(name = "operand", nullable = false)
    private String operand;

    @Column(name = "calculationResult", nullable = false)
    private Double calculationResult;

    public Calculation() {
    }
    public Calculation(
                     Double number1,
                     Double number2,
                     String operand,
                     Double calculationResult) {

        this.number1 = number1;
        this.number2 = number2;
        this.operand = operand;
        this.calculationResult = calculationResult;
    }

    public Double getCalculationResult() {
        return calculationResult;
    }

    public void setCalculationResult(Double calculationResult) {
        this.calculationResult = calculationResult;
    }

    public Double getNumber1() {
        return number1;
    }

    public void setNumber1(Double number1) {
        this.number1 = number1;
    }

    public Double getNumber2() {
        return number2;
    }

    public void setNumber2(Double number2) {
        this.number2 = number2;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand = operand;
    }



}
