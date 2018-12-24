package com.kuenag.app.contacts.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.URL;

/**
 * Format validator that can be used in different application layers
 * This class only can contain validations of text format
 * retrieve is the validation is Ok according according to the method used
 *
 * @author  Alvaro Andres Cruz Burbano
 */

@Slf4j
public class TextValidator {

    public static boolean isValidURL(String path) {
        log.info("Validating if incoming path is valid: {}", path);
        try {
            new URL(path).toURI();
            return true;
        } catch (Exception e) {
            log.info("Is not a valid path: {}", path);
            return false;
        }
    }

}
