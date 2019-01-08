package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This Class implements a simple contract
 * Is a service that  returns a SourceReadable (contract)
 * that could be from file or database
 *
 * @author Alvaro Andres Cruz Burbano
 */

@Service
public class ReadContactList implements ReadData {

    @Autowired
    SourceReadable readFromFile;
    @Autowired
    SourceReadable readFromDatabase;

    @Override
    public List<Contact> readContactListFromFile() {
        return readFromFile.readItems();
    }

    @Override
    public List<Contact> readContactListFromDatabase() {
        return readFromDatabase.readItems();
    }
}
