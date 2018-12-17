package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;
import com.kuenag.app.contacts.utils.Constants;
import com.kuenag.app.contacts.utils.Validators;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Service
public class ReadFromFile implements SourceReadable {

    @Value("${app.contact.list.file.headers}")
    private String hasHeaders;

    @Value("${app.contact.list.file.path}")
    private String pathFile;

    @Value("${app.contact.list.file.default.path}")
    private String defaultPathFile;

    @Value("${app.contact.list.file.token.separator}")
    private String tokenSeparator;

    @Override
    public List<Contact> readItems() {
        List<Contact> contactList = new ArrayList<>();
        log.info("Accessing file in path: {}", pathFile);
        try {
            List<String> linesFromFile = Files.readAllLines(Paths.get(readPath()));
            for (int i = verifyHeaders(); i < linesFromFile.size(); i++) {
                contactList.add(buildContactData(linesFromFile.get(i)));
            }
        } catch (IOException e) {
            log.error("The system cannot read the file on given path: {}", pathFile);
        }
        return contactList;
    }

    private Contact buildContactData(String line) {
        Contact contact = new Contact();
        String contactName = "", lineToken;
        StringTokenizer st = new StringTokenizer(line, tokenSeparator);
        if (st.countTokens() >= Constants.TOKENS_ALLOWED) {
            while (st.hasMoreTokens()) {
                lineToken = st.nextToken();
                if (!Validators.isValidURL(lineToken)) {
                    contactName = contactName + lineToken;
                } else {
                    contact.setUrlAvatar(lineToken);
                }
            }
            contact.setName(contactName);
        } else {
            log.error("Register with wrong number of tokens: {}", line);
        }
        return contact;
    }

    private int verifyHeaders() {
        log.info("Validating if file has headers names: {}", hasHeaders);
        if ("Y".equalsIgnoreCase(hasHeaders)) {
            return 1;
        } else {
            return 0;
        }
    }

    private String readPath(){
        if(Validators.isValidURL(pathFile))
            return pathFile;
        else {
            File directory = new File("");
            log.info("Using default file in project folder: {}",directory.getAbsolutePath() + defaultPathFile);
            return directory.getAbsolutePath() + defaultPathFile;
        }
    }

}
