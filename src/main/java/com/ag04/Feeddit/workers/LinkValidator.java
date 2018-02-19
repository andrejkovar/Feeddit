package com.ag04.Feeddit.workers;

import org.apache.commons.validator.routines.UrlValidator;

public class LinkValidator {

    private static UrlValidator urlValidator = new UrlValidator();

    public static boolean isValid(String url){

        return urlValidator.isValid(url);
    }
}
