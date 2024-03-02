package com.timirov.bankingtransactionsapi.exception.phone;

public class PhoneNotUserException extends RuntimeException{
    public PhoneNotUserException() {
        super("У вас нету такого телефона!");
    }
}
