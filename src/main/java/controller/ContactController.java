package controller;

import application.PersonRepository;
import pojo.Contact;
import pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import application.ContactRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    PersonRepository personRepository;


    @PostMapping("/person")
    public void addPerson(@Valid @RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        List<Contact> contacts = person.getContacts();
        for (Contact contact1 : contacts) {
            contactRepository.save(contact1);
        }

    }

    @PutMapping("/node")
    @Transactional
    public long updatePerson(@Valid @RequestBody Person person) {
        boolean exists = personRepository.exists(person.getPersonId());

        if (exists) {
            Person savedPerson = personRepository.save(person);
            return savedPerson.getPersonId();
        }
        return 0;
    }

    @GetMapping ("/person")
    public Person getPerson(@RequestParam long id) {

        return personRepository.findOne(id);
    }
    
    @DeleteMapping ("/person/{id}")
    public void delete(@PathVariable Long id) {

        contactRepository.delete(id);
    }
}
