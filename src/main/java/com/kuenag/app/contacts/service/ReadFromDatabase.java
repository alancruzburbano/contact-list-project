package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;
import com.kuenag.app.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the concrete implementation of SourceReadable for
 * database method of lecture, this class uses a ContactRepository object
 * that at the same time is using JPA
 *
 * @author Alvaro Andres Cruz Burbano
 */

@Service
public class ReadFromDatabase implements SourceReadable {

    @Autowired
    ContactRepository contactRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Contact> readItems(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }
}
