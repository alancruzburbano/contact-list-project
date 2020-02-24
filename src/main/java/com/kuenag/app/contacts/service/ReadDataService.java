package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Contract with implemented methods to read contact list
 * This will be used by the client
 *
 * @author Alvaro Andres Cruz Burbano
 */
public interface ReadDataService {
    Page<Contact> readContactListFromDatabase(Pageable pageable);
}
