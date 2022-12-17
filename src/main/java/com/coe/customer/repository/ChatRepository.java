package com.coe.customer.repository;

import com.coe.customer.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Integer> {
    List<ChatEntity> getChatEntitiesByCustomer_Id(int customerId);
}
