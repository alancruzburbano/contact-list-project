package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;

import java.util.List;

public interface ReadData {
    List<Contact> readContactListFromFile();

    List<Contact> readContactListFromDatabase();
}
