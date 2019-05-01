package com.exams;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
    @Test
    public void operationPlus() throws Exception {
        double leftOperand = 2;
        double rightOperand = 3;
        double expectedResult = leftOperand + rightOperand;

        double appliedResult = Operation.PLUS.apply(leftOperand, rightOperand);
        assertThat(appliedResult).isEqualTo(expectedResult);
    }

    @Test
    public void operationMinus() throws Exception {
        double leftOperand = 5;
        double rightoperand = 3;
        double expectedResult = leftOperand - rightoperand;

        double appliedResult = Operation.fromString("-").get().apply(leftOperand, rightoperand);
        assertThat(appliedResult).isEqualTo(expectedResult);
    }

    @Test
    public void operationTimes() throws Exception {
        double leftOperand = 5;
        double rightOperand = 3;
        double expectedResult = leftOperand * rightOperand;

        double appliedResult = Operation.fromString("×").get().apply(leftOperand, rightOperand);
        assertThat(appliedResult).isEqualTo(expectedResult);
    }

    @Test
    public void operationDivide() throws Exception {
        double leftOperand = 5;
        double righOperand = 3;
        double expectedResult = leftOperand / righOperand;

        double appliedResult = Operation.fromString("÷").get().apply(leftOperand, righOperand);
        assertThat(appliedResult).isEqualTo(expectedResult);
    }
}
