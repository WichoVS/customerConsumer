package com.coe.customer.repository;

import com.coe.customer.entity.GroupChatAdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupChatAdminRepository extends JpaRepository<GroupChatAdminEntity, Integer> {
    List<GroupChatAdminEntity> getGroupChatAdminEntitiesByGroupChat_Id(int groupChatId);

    List<GroupChatAdminEntity> getGroupChatAdminEntitiesByCustomer_Id(int customerId);
}
