package com.kuenag.app.contacts.controller;

import com.kuenag.app.contacts.entity.Contact;
import com.kuenag.app.contacts.service.ReadData;
import com.kuenag.app.contacts.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The Controller that handle the request and provide the
 * data according to user selection
 *
 * @author Alvaro Andres Cruz Burbano
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ContactController {

    private ReadData readContactList;

    public ContactController(ReadData readContactList) {
        this.readContactList = readContactList;
    }

    /**
     * This method provides a contact list according to the parameter value of
     * orig parameter that could be 'file' or 'db'
     *
     * @param origin the data source that user selected
     * @return contact list
     */
    @GetMapping("/contacts")
    public List<Contact> contactList(@RequestParam("orig") String origin) {
        List<Contact> items = new ArrayList<>();
        if (Constants.READ_FROM_FILE.equalsIgnoreCase(origin)) {
            log.info("Reading data from file");
            items = readContactList.readContactListFromFile();
        } else if (Constants.READ_FROM_DATABASE.equalsIgnoreCase(origin)) {
            log.info("Reading data from database");
            items = readContactList.readContactListFromDatabase();
        } else if (items.size() < Constants.MIN_ITEMS_ALLOWED)
            log.error("The list of contacts is empty");
        return items;
    }
}
