package com.examsapi;

import com.exams.CalculatorApp;
import com.exams.CalculatorEntry;
import com.exams.Operation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApp.class, webEnvironment = RANDOM_PORT)

public class CalculatorEntryApiTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Test
    public void testPlus() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.PLUS.toString();
        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "/calculator-entries/{leftOperand}/{rightOperand}/{operator}", HttpMethod.GET, requestEntity,
                String.class,
                leftOperand, rightOperand, operator);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(Double.valueOf(response.getBody())).isEqualTo(leftOperand + rightOperand);
    }

    @Test
    public void testMinus() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.MINUS.toString();
        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "/calculator-entries/{leftOperand}/{rightOperand}/{operator}", HttpMethod.GET, requestEntity,
                String.class,
                leftOperand, rightOperand, operator);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(Double.valueOf(response.getBody())).isEqualTo(leftOperand - rightOperand);
    }

    @Test
    public void testTimes() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.TIMES.toString();
        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "/calculator-entries/{leftOperand}/{rightOperand}/{operator}", HttpMethod.GET, requestEntity,
                String.class,
                leftOperand, rightOperand, operator);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(Double.valueOf(response.getBody())).isEqualTo(leftOperand * rightOperand);
    }

    @Test
    public void testDivide() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.DIVIDE.toString();
        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "/calculator-entries/{leftOperand}/{rightOperand}/{operator}", HttpMethod.GET, requestEntity,
                String.class,
                leftOperand, rightOperand, operator);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(Double.valueOf(response.getBody())).isEqualTo(leftOperand / rightOperand);
    }


    @Test
    public void testInvalidInputByWrongOperator() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = "@";
        //CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "/calculator-entries/{leftOperand}/{rightOperand}/{operator}", HttpMethod.GET, requestEntity,
                String.class,
                leftOperand, rightOperand, operator);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void testInvalidInputByWrongLeftOperand() throws Exception {
        String leftOperand = "ROTTEN";
        double rightOperand = 3;
        String operator = "*";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "/calculator-entries/{leftOperand}/{rightOperand}/{operator}", HttpMethod.GET, requestEntity,
                String.class,
                leftOperand, rightOperand, operator);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }


    @Test
    public void testInvalidInputByWrongRightOperand() throws Exception {
        double leftOperand =  2;
        String rightOperand = "rotten";
        String operator = "*";
        //CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "/calculator-entries/{leftOperand}/{rightOperand}/{operator}", HttpMethod.GET, requestEntity,
                String.class,
                leftOperand, rightOperand, operator);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }




}