package com.coe.customer.service;

import com.coe.customer.entity.CustomerEntity;
import com.coe.customer.repository.CustomerRepository;
import com.coe.kafkaproducer.model.Customer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerConsumer {
    @Autowired
    private CustomerRepository customerRepository;

    @KafkaListener(topics = "customer-save-topic", groupId = "group-json")
    public void saveCustomer(ConsumerRecord<Long, Customer> record) throws IOException {
        Customer customer = record.value();
        customer.setCreateDate(new Date());
        CustomerEntity entity = new CustomerEntity(customer);
        customerRepository.save(entity);
    }

    @KafkaListener(topics = "customer-update-topic", groupId = "group-json")
    public void updateCustomer(ConsumerRecord<Long, Customer> record) throws IOException {
        Customer customer = record.value();
        CustomerEntity customerEntity = customerRepository.findById(customer.getId()).get();
        customerEntity.updateEntity(customer);
        customerRepository.save(customerEntity);
    }

    @KafkaListener(topics = "customer-delete-topic", groupId = "group-json")
    public void deleteCustomer(ConsumerRecord<Long, Integer> record) throws IOException {
        customerRepository.deleteById(record.value());
    }

    @KafkaListener(topics = "customer-status-topic", groupId = "group-json")
    public void statusCustomer(ConsumerRecord<Long, Customer> record) throws IOException {
        Customer aux = record.value();
        if (aux.getStatus().equals("OFFLINE") || aux.getStatus().equals("ONLINE")
        ) {
            CustomerEntity entity = customerRepository.findById(aux.getId()).orElse(null);
            if (entity != null) {
                entity.setStatus(aux.getStatus());
                entity.setLastTimeOnline(new Date());
                customerRepository.save(entity);
            }
        }

    }
}
