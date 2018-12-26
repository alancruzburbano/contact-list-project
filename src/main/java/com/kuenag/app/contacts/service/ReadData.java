package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;

import java.util.List;

/**
 * Contract with implemented methods to read contact list
 *This will be used by the client
 *
 * @author  Alvaro Andres Cruz Burbano
 */
public interface ReadData {
    List<Contact> readContactListFromFile();
    List<Contact> readContactListFromDatabase();
}
