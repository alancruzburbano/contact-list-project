package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;
import com.kuenag.app.contacts.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadFromDatabase implements SourceReadable {

    private ContactRepository contactRepository;

    public ReadFromDatabase(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> readItems() {
        return contactRepository.findAll();
    }
}
