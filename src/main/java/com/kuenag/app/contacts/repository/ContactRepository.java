package com.kuenag.app.contacts.repository;

import com.kuenag.app.contacts.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * The Repository  interface
 * A simple contract with a single method which
 * retrieve the contact list
 *
 * @author  Alvaro Andres Cruz Burbano
 */

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findAll();
}
