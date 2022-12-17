package com.coe.customer.controller;

import com.coe.customer.entity.GroupChatAdminEntity;
import com.coe.customer.repository.GroupChatAdminRepository;
import com.coe.kafkaproducer.model.GroupChat;
import com.coe.kafkaproducer.model.GroupChatAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/group-chat-admin")
@CrossOrigin
public class GroupChatAdminController {
    private final GroupChatAdminRepository groupChatAdminRepository;

    @Autowired
    public GroupChatAdminController(GroupChatAdminRepository groupChatAdminRepository) {
        this.groupChatAdminRepository = groupChatAdminRepository;
    }

    @GetMapping("")
    public List<GroupChatAdmin> getGroupChatAdmins() {
        List<GroupChatAdminEntity> entities = groupChatAdminRepository.findAll();
        List<GroupChatAdmin> dtos = new ArrayList<>();

        for (GroupChatAdminEntity entity : entities
        ) {
            dtos.add(new GroupChatAdmin(entity));
        }

        return dtos;
    }

    @GetMapping("/{idChat}")
    public List<GroupChatAdmin> getCustomersOfGroupChat(@PathVariable("idChat") int idChat) {
        List<GroupChatAdminEntity> entities = groupChatAdminRepository.getGroupChatAdminEntitiesByGroupChat_Id(idChat);
        List<GroupChatAdmin> dtos = new ArrayList<>();

        for (GroupChatAdminEntity entity : entities
        ) {
            dtos.add(new GroupChatAdmin(entity));
        }

        return dtos;
    }

    @GetMapping("/customer/{idCustomer}")
    public List<GroupChatAdmin> getGroupChatsOfCustomer(@PathVariable("idCustomer") int idCustomer) {

        List<GroupChatAdminEntity> entities = groupChatAdminRepository.
                getGroupChatAdminEntitiesByCustomer_Id(idCustomer);
        List<GroupChatAdmin> dtos = new ArrayList<>();

        for (GroupChatAdminEntity entity : entities
        ) {
            dtos.add(new GroupChatAdmin(entity));
        }

        return dtos;
    }
}
