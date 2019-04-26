package com.exams;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorControllerTest {
    private CalculatorController controller;
//    private CalculatorEntryRepository calculatorEntryRepository ;

    @Before
    public void setUp() throws Exception {
//        controller = new CalculatorController(calculatorEntryRepository);
        controller = new CalculatorController();

    }

    @Test
    public void testPLUS() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.PLUS.name();
        double expectedResult = 5;
        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);
        ResponseEntity response = controller.operation(calculatorEntry);
        //   verify(timeEntryRepository).create(timeEntryToCreate);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(String.valueOf(expectedResult));
    }

    @Test
    public void testMINUS() throws Exception {
        double leftOperand = 8;
        double rightOperand = 3;
        String operator = Operation.MINUS.name();
        double expectedResult = 5;

        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);
        ResponseEntity response = controller.operation(calculatorEntry);
     //   verify(timeEntryRepository).create(timeEntryToCreate);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(String.valueOf(expectedResult));
    }

    @Test
    public void testTIMES() throws Exception {
        double leftOperand = 8;
        double rightOperand = 3;
        String operator = Operation.TIMES.name();
        double expectedResult = 24;

        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);
        ResponseEntity response = controller.operation(calculatorEntry);
        //   verify(timeEntryRepository).create(timeEntryToCreate);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(String.valueOf(expectedResult));
    }

    @Test
    public void testDIVIDE() throws Exception {
        double leftOperand = 8;
        double rightOperand = 3;
        String operator = Operation.DIVIDE.name();
        double expectedResult = leftOperand / rightOperand;

        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);
        ResponseEntity response = controller.operation(calculatorEntry);
        //   verify(timeEntryRepository).create(timeEntryToCreate);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(String.valueOf(expectedResult));
    }
}
