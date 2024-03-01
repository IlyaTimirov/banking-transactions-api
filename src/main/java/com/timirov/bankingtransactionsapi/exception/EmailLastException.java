package com.timirov.bankingtransactionsapi.exception;

public class EmailLastException extends RuntimeException{
    public EmailLastException() {
        super("Вы не можете удалить последнии email!");
    }
}
