package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO postMethodName(@RequestBody ContactCreateDTO entity) {
        var contact = new Contact();
        contact.setFirstName(entity.getFirstName());
        contact.setLastName(entity.getLastName());
        contact.setPhone(entity.getPhone());
        var contactDB = contactRepository.save(contact);

        var contactDTO = new ContactDTO();
        contactDTO.setId(contactDB.getId());
        contactDTO.setFirstName(contactDB.getFirstName());
        contactDTO.setLastName(contactDB.getLastName());
        contactDTO.setPhone(contactDB.getPhone());
        contactDTO.setCreatedAt(contactDB.getCreatedAt());
        contactDTO.setUpdatedAt(contactDB.getUpdatedAt());

        return contactDTO;
    }

    // END
}
