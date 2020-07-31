package com.smalaca.calculator;

class Calculator {
    double sum(double addend1, double addend2) {
        return check(addend1 + addend2);
    }

    double subtract(double minuend, double subtrahend) {
        return check(minuend - subtrahend);
    }

    double multiplication(double factor1, double factor2) {
        return check(factor1 * factor2);
    }

    double division(double dividend, double divisor) {
        if (divisor == 0) {
            throw new ZeroDivisorException();
        }

        return check(dividend / divisor);
    }

    private double check(double result) {
        if (result == 13) {
            throw new UnluckyNumberException();
        }

        return result;
    }
}
