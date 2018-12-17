package com.kuenag.app.contacts.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.URL;

@Slf4j
public class Validators {

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
