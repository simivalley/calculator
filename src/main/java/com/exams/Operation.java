package com.exams;


import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;


public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("×") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("÷") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String operator;

    Operation(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return operator;
    }

    public abstract double apply(double x, double y);


    private static final Map<String, Operation> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e));


    public static Optional<Operation> fromString(String operator) {
        return Optional.ofNullable(stringToEnum.get(operator));
    }


}