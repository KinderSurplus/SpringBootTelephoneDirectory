package com.example.telephoneDir_INET2005;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    //make object of UserService
    @Autowired
    private UserService userService;

    //get all the telephone listings
    @RequestMapping(value = "/telephone", method = RequestMethod.GET)
    public List<TeleRecord> getAllItems() {
        return userService.getAllItems();
    }

    //get a particular telephone listing by its ID
    @RequestMapping(value = "/telephone/{id}", method = RequestMethod.GET)
    public Optional<TeleRecord> getItemById(@PathVariable Integer id) {
        return userService.getItem(id);
    }

    //add a new telephone listing to the database
    @RequestMapping(value = "/telephone", method = RequestMethod.POST)
    public void addTele(@RequestBody TeleRecord teleRecord) {
        userService.addItem(teleRecord);
    }

    //update telephone listing by id
    @RequestMapping(value = "/telephone/{id}/{phone}/{name}", method = RequestMethod.PUT)
    public Optional<TeleRecord> teleRecord(@PathVariable Integer id, @PathVariable String phone, @PathVariable String name) {
       return userService.setItemById(id, phone, name);
    }

    //delete all the telephone listings
    @RequestMapping(value = "/tutorial", method = RequestMethod.DELETE)
    public void deleteAllItems() {
        userService.deleteAllItem();
    }

    //delete one specific telephone listing by its ID
    @RequestMapping(value = "/telephone/{id}", method = RequestMethod.DELETE)
    public void deleteItemById(@PathVariable Integer id) {
        userService.deleteItem(id);
    }


}
