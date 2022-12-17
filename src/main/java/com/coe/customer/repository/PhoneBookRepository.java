package com.coe.customer.repository;

import com.coe.customer.entity.PhoneBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBookEntity, Integer> {
    List<PhoneBookEntity> getPhoneBookEntitiesByCustomer_Id(int customerId);
}
