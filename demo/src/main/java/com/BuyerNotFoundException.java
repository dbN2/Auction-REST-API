package com;

public class BuyerNotFoundException extends RuntimeException{
    BuyerNotFoundException(Long id){
        super("Could not find buyer "+ id);
    }
}
