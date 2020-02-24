package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * This Class implements a simple contract
 * Is a service that  returns a SourceReadable (contract)
 * that could be from file or database
 *
 * @author Alvaro Andres Cruz Burbano
 */

@Service
public class ReadContactListService implements ReadDataService {

    @Autowired
    SourceReadable readFromDatabase;

    @Override
    public Page<Contact> readContactListFromDatabase(Pageable pageable) {
        return readFromDatabase.readItems(pageable);
    }
}
