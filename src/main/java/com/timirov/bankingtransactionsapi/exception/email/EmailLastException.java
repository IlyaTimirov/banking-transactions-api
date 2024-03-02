package com.timirov.bankingtransactionsapi.exception.email;

public class EmailLastException extends RuntimeException{
    public EmailLastException() {
        super("Вы не можете удалить последнии email!");
    }
}
