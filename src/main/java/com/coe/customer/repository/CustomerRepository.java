package com.coe.customer.repository;


import com.coe.customer.entity.CustomerEntity;
import com.coe.kafkaproducer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    CustomerEntity findFirstByPhoneNumber(String phoneNumber);
}
