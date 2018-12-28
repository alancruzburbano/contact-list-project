package com.kuenag.app.contacts.utils;

public final class Constants {
    public static final int MIN_TOKENS_NUM = 2; //Tokens that must have incoming CSV file
    public static final int MIN_ITEMS_ALLOWED = 1; //Min number of contacts that app should read
    public static final String READ_FROM_FILE = "file"; //Value read from request parameter op 1
    public static final String READ_FROM_DATABASE = "db"; //Value read from request parameter op 2
    public static final String DEFAULT_FILE_PATH = "\\src\\main\\resources\\input\\contactList\\people.csv";
    public static final String VALIDATE_NAME_REGULAR_EXPRESSION = "^([A-z\\'\\.-ᶜ]*(\\s))+[A-z\\'\\.-ᶜ]*$";
}
