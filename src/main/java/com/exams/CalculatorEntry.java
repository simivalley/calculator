package com.exams;

public class CalculatorEntry {
    private long id;
    private double leftOperand;
    private double rightOperand;
    private String operator;

    private String errorMessage = "None";

    private double result;

    public CalculatorEntry() {}

    public CalculatorEntry(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
        apply(leftOperand, rightOperand, operator);
    }

    public CalculatorEntry(CalculatorEntry calculatorInbounding) {
        this.leftOperand = calculatorInbounding.getLeftOperand();
        this.rightOperand = calculatorInbounding.getRightOperand();
        this.operator = calculatorInbounding.getOperator();
        apply(leftOperand, rightOperand, operator);
    }



    public double apply ( double leftOperand, double rightOperand, String operator ){
        result = Operation.valueOf(operator).apply(leftOperand,rightOperand);
        return result;
    }

    public double apply (){
        return Operation.valueOf(this.operator).apply(this.leftOperand,this.rightOperand);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
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
