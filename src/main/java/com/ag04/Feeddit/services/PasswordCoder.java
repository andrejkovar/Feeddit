package com.ag04.Feeddit.services;

import java.util.Base64;

public class PasswordCoder {

    public static String encode(String password){
        return new String(Base64.getEncoder().encode(password.getBytes()));
    }

    public static String decode(String encodedPassword){
        return new String(Base64.getDecoder().decode(encodedPassword));
    }
}
