package com.kuenag.app.contacts.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
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

    public static boolean isValidURL(String textUrl) {
        URL u = null;
        try {
            u = new URL(textUrl);
        } catch (MalformedURLException e) {
            return false;
        }
        try {
            u.toURI();
        } catch (URISyntaxException e) {
            return false;
        }
        return true;
    }

    public static boolean isValidFilePath(String path) {
        return Files.exists(Paths.get(path));
    }

}
