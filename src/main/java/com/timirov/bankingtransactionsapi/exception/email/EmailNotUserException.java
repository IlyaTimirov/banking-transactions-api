package com.timirov.bankingtransactionsapi.exception.email;

public class EmailNotUserException extends RuntimeException{
    public EmailNotUserException() {
        super("У вас нету такой почты!");
    }
}
