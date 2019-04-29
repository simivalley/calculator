package com.examsapi;

import com.exams.CalculatorApp;
import com.exams.CalculatorEntry;
import com.exams.Operation;
import com.jayway.jsonpath.DocumentContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.TimeZone;

import static com.jayway.jsonpath.JsonPath.parse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

//import com.mysql.cj.jdbc.MysqlDataSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApp.class, webEnvironment = RANDOM_PORT)

public class CalculatorEntryApiTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
//
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        jdbcTemplate.execute("TRUNCATE time_entries");

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Test
    public void testPlus() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.PLUS.name();
        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);

        ResponseEntity<String> createResponse = restTemplate.postForEntity("/calculator-entries", calculatorEntry, String.class);


        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        DocumentContext createJson = parse(createResponse.getBody());
        assertThat(createJson.read("$.result", Double.class)).isEqualTo( leftOperand+rightOperand);
    }

    @Test
    public void testMinus() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.MINUS.name();
        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);

        ResponseEntity<String> createResponse = restTemplate.postForEntity("/calculator-entries", calculatorEntry, String.class);


        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        DocumentContext createJson = parse(createResponse.getBody());
        assertThat(createJson.read("$.result", Double.class)).isEqualTo(leftOperand-rightOperand);
    }

    @Test
    public void testTimes() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.TIMES.name();
        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);

        ResponseEntity<String> createResponse = restTemplate.postForEntity("/calculator-entries", calculatorEntry, String.class);


        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        DocumentContext createJson = parse(createResponse.getBody());
        assertThat(createJson.read("$.result", Double.class)).isEqualTo(leftOperand*rightOperand);
    }

    @Test
    public void testDivide() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        String operator = Operation.DIVIDE.name();
        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);

        ResponseEntity<String> createResponse = restTemplate.postForEntity("/calculator-entries", calculatorEntry, String.class);


        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        DocumentContext createJson = parse(createResponse.getBody());
        assertThat(createJson.read("$.result", Double.class)).isEqualTo(leftOperand/rightOperand);
    }
}