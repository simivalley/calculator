package com.exams;

import java.util.List;

public interface CalculatorEntryRepository {

    void create(CalculatorEntry c);

    List<CalculatorEntry> list();
}
