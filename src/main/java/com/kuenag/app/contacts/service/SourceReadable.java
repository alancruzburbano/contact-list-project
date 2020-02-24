package com.kuenag.app.contacts.service;

import com.kuenag.app.contacts.entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Contract with common abstraction to read information
 *
 * @author Alvaro Andres Cruz Burbano
 */
@FunctionalInterface
public interface SourceReadable {
    Page<Contact> readItems(Pageable pageable);
}
