package com.coe.customer.repository;

import com.coe.customer.entity.GroupChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupChatRepository extends JpaRepository<GroupChatEntity, Integer> {
}
