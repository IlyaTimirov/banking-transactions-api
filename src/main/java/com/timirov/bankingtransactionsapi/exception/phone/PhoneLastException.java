package com.timirov.bankingtransactionsapi.exception.phone;

public class PhoneLastException extends RuntimeException{
    public PhoneLastException() {
        super("Вы не можете удалить последнии номер телефона!");
    }
}
