package com.exams;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCalculatorEntryRepository implements CalculatorEntryRepository {
    private List<CalculatorEntry> calculatorEntries;
    private long localId = 0L;

    public InMemoryCalculatorEntryRepository() {
        localId = 0l;
        calculatorEntries = new ArrayList<CalculatorEntry>();
    }

    public long getLocalId() {
        return localId;
    }

    public long nextLocalId() {
        return ++localId;
    }

    @Override
    public void create(CalculatorEntry c) {
//        CalculatorEntry c = new CalculatorEntry(leftOperand, rightOperand, operator);
//        c.apply();
        this.calculatorEntries.add(c);
    }

    @Override
    public List<CalculatorEntry> list() {

        return this.calculatorEntries;
    }

}
