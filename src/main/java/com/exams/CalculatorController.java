package com.exams;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return  new ResponseEntity(String.valueOf(calculatorEntry.getResult()), HttpStatus.CREATED);
    }
}
