package com;

public class SellerNotFoundException extends RuntimeException{

        SellerNotFoundException(Long id){
            super("Could not find buyer "+ id);
        }

    }

