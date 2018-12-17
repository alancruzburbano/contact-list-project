package com.kuenag.app.contacts.controller;

import com.kuenag.app.contacts.repository.ContactRepository;
import com.kuenag.app.contacts.service.ReadData;
import com.kuenag.app.contacts.entity.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ContactController {

    private ReadData readContactList;

    public ContactController(ReadData readContactList) {
        this.readContactList = readContactList;
    }

    /**
     * This method provides a contact list according to the parameter that could be 'file' or 'db'
     * @param origin the data source that user selected
     * @return contact list
     */
    @GetMapping("/contacts")
    public List<Contact> contactList(@RequestParam("orig") String origin) {
        List<Contact> items = new ArrayList<>();
        switch (origin) {
            case "file":
                log.info("Reading data from file");
                items = readContactList.readContactListFromFile();
                break;

            case "db":
                log.info("Reading data from database");
                items = readContactList.readContactListFromDatabase();
                break;

            default:
                log.error("The systems cannot read items");
        }
        return items;
    }

}
