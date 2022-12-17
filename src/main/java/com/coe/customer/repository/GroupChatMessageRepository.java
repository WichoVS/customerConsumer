package com.coe.customer.repository;

import com.coe.customer.entity.GroupChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupChatMessageRepository extends JpaRepository<GroupChatMessageEntity, Integer> {
    List<GroupChatMessageEntity> getGroupChatMessageEntityByGroupChatAdmin_Id(int idGroupChatAdmin);
}
