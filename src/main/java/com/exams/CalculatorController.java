package com.exams;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator-entries")
public class CalculatorController {
   // private CalculatorEntry calculatorEntry;

//    public CalculatorController(CalculatorEntryRepository calculatorEntry) {
//        calculatorEntry = calculatorEntry;
//    }

    public CalculatorController() {

    }


    @PostMapping
    public ResponseEntity operation (@RequestBody CalculatorEntry calculatorEntryInbounding){
        CalculatorEntry calculatorEntry = new CalculatorEntry(calculatorEntryInbounding);
        double result = calculatorEntry.apply();
        return  new ResponseEntity(String.valueOf(result), HttpStatus.CREATED);
    }

    public ResponseEntity operation(double leftOperand, double rightOperand, String operator) {
        CalculatorEntry calculatorEntry = new CalculatorEntry(leftOperand, rightOperand, operator);
        return  new ResponseEntity(String.valueOf(calculatorEntry.getResult()), HttpStatus.CREATED);
    }

    @GetMapping("{leftOperand}/{rightOperand}/{operator}")
    public ResponseEntity operation(@PathVariable String leftOperand, @PathVariable String rightOperand, @PathVariable String operator) {
        String result = validateOperands(leftOperand, rightOperand);
        if (result.length() > 0) {
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        } else {
            result = String.valueOf(new CalculatorEntry(Double.valueOf(leftOperand), Double.valueOf(rightOperand), operator).apply());
            return  new ResponseEntity(result, HttpStatus.CREATED);
        }
    }

    private String validateOperands(String leftOperand, String rightOperand) {
        try {
            double lOperand = Double.valueOf(leftOperand);
            if (lOperand > Double.MAX_VALUE || lOperand < Double.MIN_VALUE) {
                throw new Exception("Invalid");
            }
        }catch (Exception e) {
            return leftOperand + " is invalid.";
        }
        try {
            double rOperand = Double.valueOf(rightOperand);
            if (rOperand > Double.MAX_VALUE || rOperand < Double.MIN_VALUE) {
                throw new Exception("Invalid");
            }
        }catch (Exception e) {
            return rightOperand + " is invalid.";
        }
        return "";
    }
}
