package com.rentacar.exeption;

public class ResourceNotFountException extends RuntimeException{

    public ResourceNotFountException(String msg){
        super(msg);
    }
}
