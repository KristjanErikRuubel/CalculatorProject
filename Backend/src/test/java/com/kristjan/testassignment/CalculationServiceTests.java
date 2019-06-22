package com.kristjan.testassignment;

import com.kristjan.testassignment.services.CalculationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculationServiceTests {

    @Autowired
    private CalculationService calculationService;

    @Test
    public void testCalculationSum() {
        Map<String, Double> calculationResult = new HashMap<>(calculationService.addOperation(1.0, 2.0, "sum"));
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("calculationResult", 3.0);
        assertEquals(calculationResult, expectedResult);
    }


    @Test
    public void testCalculationSubtract() {
        Map<String, Double> calculationResult = new HashMap<>(calculationService.addOperation(12.0, 2.0, "sub"));
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("calculationResult", 10.0);
        assertEquals(calculationResult, expectedResult);
    }


    @Test
    public void testCalculationDivide() {
        Map<String, Double> calculationResult = new HashMap<>(calculationService.addOperation(2.0, 2.0, "prod"));
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("calculationResult", 4.0);
        assertEquals(calculationResult, expectedResult);
    }

    @Test
    public void testCalculationMultiplyBy0() {
        Map<String, Double> calculationResult = new HashMap<>(calculationService.addOperation(1.0, 0.0, "prod"));
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("calculationResult", 0.0);
        assertEquals(calculationResult, expectedResult);
    }
    @Test
    public void testCalculationDivideBy0() {
        Map<String, Double> calculationResult = new HashMap<>(calculationService.addOperation(1.0, 0.0, "div"));
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("calculationResult", Double.POSITIVE_INFINITY);
        assertEquals(calculationResult, expectedResult);
    }

    @Test
    public void testCalculationDivide0By0() {
        Map<String, Double> calculationResult = new HashMap<>(calculationService.addOperation(0.0, 0.0, "div"));
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("calculationResult", Double.NaN);
        assertEquals(calculationResult, expectedResult);
    }


    @Test
    public void testCalculationSubtractNegativeNumbers() {
        Map<String, Double> calculationResult = new HashMap<>(calculationService.addOperation(-2.0, -2.0, "sub"));
        Map<String, Double> expectedResult = new HashMap<>();
        expectedResult.put("calculationResult", 0.0);
        assertEquals(calculationResult, expectedResult);
    }
}
