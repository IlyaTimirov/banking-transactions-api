package com.timirov.bankingtransactionsapi.exception.email;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException() {
        super("Данная почту уже занята!");
    }
}
