package com.kuenag.app.contacts.utils;

import lombok.extern.slf4j.Slf4j;
import java.nio.file.Files;

import java.net.URL;
import java.nio.file.Paths;

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
        try {
            new URL(path).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidFilePath(String path) {
        return Files.exists(Paths.get(path));
    }

}
