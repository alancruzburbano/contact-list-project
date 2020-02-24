package com.kuenag.app.contacts.controller;

import com.kuenag.app.contacts.entity.Contact;
import com.kuenag.app.contacts.service.ReadDataService;
import com.kuenag.app.contacts.utils.PageRender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * The Controller that handle the request and provide the
 * data according to user selection
 *
 * @author Alvaro Andres Cruz Burbano
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contact-list")
@Slf4j

public class ContactController {

    @Autowired
    ReadDataService readContactList;

    /**
     * This method provides a contact list according to the parameter value of
     * orig parameter that could be 'file' or 'db'
     *
     * @param page the page size
     * @return contact list
     */
    @RequestMapping("/db")
    public PageRender<Contact> contactList(@RequestParam(name = "page", defaultValue = "0") int page) {
        //List<Contact> items = new ArrayList<>();
        //if (Constants.READ_FROM_FILE.equalsIgnoreCase(origin)) {
        log.info("Reading data from file");
        Pageable pageable = PageRequest.of(page, 10);
        PageRender<Contact> pageRender =
                new PageRender("/contacts",
                        readContactList.readContactListFromDatabase(pageable));
        return pageRender;
        //} else if (Constants.READ_FROM_DATABASE.equalsIgnoreCase(origin)) {
        //    Pageable pageable = PageRequest.of(page, 5);
        //    log.info("Reading data from database");
            //items = readContactList.readContactListFromDatabase().stream().;
        //} else if (items.size() < Constants.MIN_ITEMS_ALLOWED)
        //    log.error("The list of contacts is empty");
        //return items;
    }

}
