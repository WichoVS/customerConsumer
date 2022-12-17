package com.coe.customer.controller;

import com.coe.customer.entity.PhoneBookEntity;
import com.coe.customer.repository.PhoneBookRepository;
import com.coe.kafkaproducer.model.PhoneBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/phone-book")
@CrossOrigin
public class PhoneBookController {
    private final PhoneBookRepository phoneBookRepository;

    @Autowired
    public PhoneBookController(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    @GetMapping("/{idCustomer}")
    public List<PhoneBook> getContactsByCustomerId(@PathVariable("idCustomer") int idCustomer) {
        List<PhoneBookEntity> entities = phoneBookRepository.getPhoneBookEntitiesByCustomer_Id(idCustomer);
        List<PhoneBook> dtos = new ArrayList<>();
        for (PhoneBookEntity entity : entities
        ) {
            dtos.add(new PhoneBook(entity));
        }
        return dtos;
    }

    @GetMapping("")
    public List<PhoneBook> getAllPhoneBooks() {
        List<PhoneBookEntity> entities = phoneBookRepository.findAll();
        List<PhoneBook> dtos = new ArrayList<>();
        for (PhoneBookEntity entity : entities
        ) {
            dtos.add(new PhoneBook(entity));
        }

        return dtos;
    }
}
