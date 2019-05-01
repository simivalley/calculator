package com.exams;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorControllerTest {
    private CalculatorController controller;


    @Before
    public void setUp() throws Exception {

        controller = new CalculatorController();

    }

    @Test
    public void testPLUS() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.PLUS.toString();
        String expectedResult = String.valueOf(leftOperand + rightOperand);

        ResponseEntity response = controller.operation(String.valueOf(leftOperand), String.valueOf(rightOperand), operator);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(expectedResult);
    }

    @Test
    public void testMINUS() throws Exception {
        double leftOperand = 8;
        double rightOperand = 3;
        String operator = Operation.MINUS.toString();
        String expectedResult = String.valueOf(leftOperand - rightOperand);

        ResponseEntity response = controller.operation(String.valueOf(leftOperand), String.valueOf(rightOperand), operator);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(expectedResult);
    }

    @Test
    public void testTIMES() throws Exception {
        double leftOperand = 8;
        double rightOperand = 3;
        String operator = Operation.TIMES.toString();
        String expectedResult = String.valueOf(leftOperand * rightOperand);

        ResponseEntity response = controller.operation(String.valueOf(leftOperand), String.valueOf(rightOperand), operator);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(expectedResult);
        assertThat(response.getBody()).isEqualTo(expectedResult);
    }

    @Test
    public void testDIVIDE() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.DIVIDE.toString();
        String expectedResult = String.valueOf(leftOperand / rightOperand);
        ResponseEntity response = controller.operation(String.valueOf(leftOperand), String.valueOf(rightOperand), operator);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(expectedResult);
    }

    @Test
    public void testInvalidLeftOperand() throws Exception {
        String leftOperand = "ab";
        double rightOperand = 3;
        String operator = Operation.PLUS.name();
        String expectedResult = String.valueOf(leftOperand + rightOperand);

        ResponseEntity response = controller.operation(leftOperand, String.valueOf(rightOperand), operator);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testInvalidRightOperand() throws Exception {
        String rightOperand = "ac";
        double leftOperand = 3;
        String operator = Operation.PLUS.name();
        String expectedResult = String.valueOf(leftOperand + rightOperand);

        ResponseEntity response = controller.operation(String.valueOf(leftOperand), rightOperand, operator);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }


    @Test
    public void testInvalidOperator() throws Exception {
        double rightOperand = 2;
        double leftOperand = 3;
        String operator = "@";
        String expectedResult = String.valueOf(leftOperand + rightOperand);

        ResponseEntity response = controller.operation(String.valueOf(leftOperand), String.valueOf(rightOperand), operator);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

}
