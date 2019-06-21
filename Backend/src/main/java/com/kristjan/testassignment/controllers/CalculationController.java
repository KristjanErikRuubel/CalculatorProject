package com.kristjan.testassignment.controllers;

import com.kristjan.testassignment.dto.CalculationDTOJson;
import com.kristjan.testassignment.dto.CalculationList;

import com.kristjan.testassignment.services.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CalculationController {

    private final CalculationService calculationService;

    @Autowired
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping(value = "hello")
    public String getHello() {
        return "Hello World!";
    }

    @CrossOrigin
    @GetMapping(value = "/calculate")
    public Map<String, Double> addCalculation(@RequestParam Double num1, @RequestParam Double num2, @RequestParam String op){
        return calculationService.addOperation(num1, num2, op);
    }

    @CrossOrigin
    @PostMapping(value = "/calculate")
    public Map<String, Double> calculateJson(@RequestBody CalculationDTOJson calculationDTO){
        return calculationService.addOperation(calculationDTO.getNum1(), calculationDTO.getNum2(), calculationDTO.getOp());
    }

    @CrossOrigin
    @GetMapping(value = "/getResults")
    public CalculationList getAllCalculations() {
        return calculationService.getAllCalculations();
    }

}
