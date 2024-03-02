package com.timirov.bankingtransactionsapi.exception.phone;

public class PhoneAlreadyExistsException extends RuntimeException{
    public PhoneAlreadyExistsException() {
        super("Данный номер уже занята!");
    }
}
