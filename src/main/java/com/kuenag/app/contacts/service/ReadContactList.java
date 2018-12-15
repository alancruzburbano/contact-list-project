package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadContactList implements ReadData {

    private SourceReadable readFromFile;
    private SourceReadable readFromDatabase;

    public ReadContactList(SourceReadable readFromFile, SourceReadable readFromDatabase) {
        this.readFromFile = readFromFile;
        this.readFromDatabase = readFromDatabase;
    }

    @Override
    public List<Contact> readContactListFromFile() {
        return readFromFile.readItems();
    }

    @Override
    public List<Contact> readContactListFromDatabase() {
        return readFromDatabase.readItems();
    }
}
