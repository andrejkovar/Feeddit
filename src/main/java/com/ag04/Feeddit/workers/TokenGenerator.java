package com.ag04.Feeddit.workers;
import java.util.Random;

public class TokenGenerator {

    public static String generateToken(){

        Random r = new Random ();
        return Long.toString (Math.abs (r.nextLong ()), 36);
    }
}
