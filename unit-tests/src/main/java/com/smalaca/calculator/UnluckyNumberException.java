package com.smalaca.calculator;

class UnluckyNumberException extends RuntimeException {
    UnluckyNumberException() {
        super("Bad luck this time - the result is 13.");
    }
}
