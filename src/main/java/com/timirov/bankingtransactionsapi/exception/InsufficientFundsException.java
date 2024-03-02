package com.timirov.bankingtransactionsapi.exception;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException() {
        super("Недостаточно средств для перевода!");
    }
}
