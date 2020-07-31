package com.smalaca.calculator;

class ZeroDivisorException extends RuntimeException {
    ZeroDivisorException() {
        super("Cannot divide by zero.");
    }
}
