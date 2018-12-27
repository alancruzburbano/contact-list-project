package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;
import com.kuenag.app.contacts.utils.Constants;
import com.kuenag.app.contacts.utils.TextVerifiable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This is the concrete implementation of SourceReadable for
 * file method of lecture, this class reads the application.properties file
 * and perform the creation of a contact list
 *
 * @author Alvaro Andres Cruz Burbano
 */
@Slf4j
@Service
public class ReadFromFile implements SourceReadable {

    @Value("${app.contact.list.file.headers}")
    private String hasHeaders;

    @Value("${app.contact.list.file.path}")
    private String pathFile;

    @Value("${app.contact.list.file.token.separator}")
    private String tokenSeparator;

    TextVerifiable verifyUrl = (text) -> {
        try {
            new URL(text).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    };

    TextVerifiable verifyPath = (text) -> Files.exists(Paths.get(text));

    /**
     * Contact list from file stored in customized path or default path, the parameters comes from application.properties
     * if the system cannot find the path from  app.contact.list.file.path then will use app.contact.list.file.default.path that
     * will use the file placed inside the project.
     *
     * @return contact list
     */
    @Override
    public List<Contact> readItems() {
        List<Contact> contactList = new ArrayList<>();
        try {
            List<String> linesFromFile = Files.readAllLines(Paths.get(readPath()));
            for (int i = verifyHeaders(); i < linesFromFile.size(); i++) {
                contactList.add(processFileLine(linesFromFile.get(i), i));
            }
        } catch (IOException e) {
            log.error("The system cannot read the file on given path: {} message: {}", pathFile, e.getLocalizedMessage());
        }
        return contactList;
    }

    /**
     * This method get a line from the file, tokenize the chain according to the character specified
     * in app.contact.list.file.token.separator  property
     *
     * @param line from file
     * @return contact object according to the model
     */
    private Contact processFileLine(String line, int lineNumber) {
        StringTokenizer st = new StringTokenizer(line, tokenSeparator);
        Contact contactLine = null;
        if (st.countTokens() >= Constants.MIN_TOKENS_NUM) {
            contactLine = buildContactFromTokens(st);
        } else {
            log.error("The line {} not contains the minimum number of tokens required, null register in line: {}", lineNumber, line);
        }
        return contactLine;
    }

    /**
     * This method Iterates tokens, searching for a url token, assuming that previous tokens are part of contact name,
     * This is because there are contact registers using ',' as part of the name.
     *
     * @param st String tokenizer object that will be used to create a contact object
     * @return Contact object from tokens
     */
    private Contact buildContactFromTokens(StringTokenizer st) {
        Contact contact = new Contact();
        String contactName = "", lineToken;
        while (st.hasMoreTokens()) {
            lineToken = st.nextToken();
            if (!verifyUrl.verify(lineToken)) {
                contactName = contactName + lineToken;
            } else {
                contact.setUrlAvatar(lineToken);
            }
        }
        contact.setName(contactName);
        return contact;
    }

    /**
     * According to app.contact.list.file.headers property the system will return 0 or 1
     *
     * @return the index line where the system must start to read the file
     */
    private int verifyHeaders() {
        log.info("Validating if file has headers names: {}", hasHeaders);
        if ("Y".equalsIgnoreCase(hasHeaders)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * The method verifies if the file in pathFile property exist in the system,
     * else the systems will use the CSV file inside the project as a default alternative
     *
     * @return Custom path or default path.
     */
    private String readPath() {
        if (verifyPath.verify(pathFile)) {
            log.info("Read file in provided path: {}", pathFile);
            return pathFile;
        } else {
            File directory = new File(""); //Retrieve the root project path
            log.info("The Path in app.contact.list.file.path is not valid, using default " +
                    "file in project folder: {}", directory.getAbsolutePath() + Constants.DEFAULT_FILE_PATH);
            return directory.getAbsolutePath() + Constants.DEFAULT_FILE_PATH;
        }
    }

}
