package com.exams;

public class CalculatorEntry {
    private double leftOperand;
    private double rightOperand;
    private String operator;

    private double result;

    public CalculatorEntry() {}

    public CalculatorEntry(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public CalculatorEntry(CalculatorEntry calculatorInbounding) {
        this.leftOperand = calculatorInbounding.getLeftOperand();
        this.rightOperand = calculatorInbounding.getRightOperand();
        this.operator = calculatorInbounding.getOperator();
        apply(leftOperand, rightOperand, operator);
    }

    public void apply ( double leftOperand, double rightOperand, String operator ){
        result = Operation.valueOf(operator).apply(leftOperand,rightOperand);

    }

    public double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {  this.result = result; }
}
