package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;

import java.util.List;

/**
 * Contract with common abstraction to read information
 *
 * @author  Alvaro Andres Cruz Burbano
 */
public interface SourceReadable {
    List<Contact> readItems();
}
