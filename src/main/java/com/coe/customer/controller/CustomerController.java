package com.coe.customer.controller;

import com.coe.customer.entity.CustomerEntity;
import com.coe.customer.repository.CustomerRepository;
import com.coe.kafkaproducer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/{idCustomer}")
    public Customer getCustomerById(@PathVariable("idCustomer") int idCustomer) {
        if (idCustomer <= 0)
            return null;

        CustomerEntity customerEntity = customerRepository.findById(idCustomer).get();
        return new Customer(customerEntity);
    }

    @GetMapping("")
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        List<CustomerEntity> entities = customerRepository.findAll();
        for (CustomerEntity entity : entities
        ) {
            customers.add(new Customer(entity));
        }
        return customers;
    }

    @GetMapping("/phone-number/{phoneNumber}")
    public Customer getCustomerByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber) throws IOException {
        CustomerEntity entityAux = new CustomerEntity();
        entityAux.setPhoneNumber(phoneNumber);
        CustomerEntity entity = customerRepository.findOne(Example.of(entityAux)).get();
        if (entity != null)
            return new Customer(entity);
        return null;
    }
}
