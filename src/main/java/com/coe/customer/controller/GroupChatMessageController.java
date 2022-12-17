package com.coe.customer.controller;

import com.coe.customer.entity.GroupChatMessageEntity;
import com.coe.customer.repository.GroupChatMessageRepository;
import com.coe.kafkaproducer.model.GroupChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/group-chat-message")
@CrossOrigin
public class GroupChatMessageController {
    private final GroupChatMessageRepository groupChatMessageRepository;

    @Autowired
    public GroupChatMessageController(GroupChatMessageRepository groupChatMessageRepository) {
        this.groupChatMessageRepository = groupChatMessageRepository;
    }

    @GetMapping("")
    public List<GroupChatMessage> getGroupChatMessages() {
        List<GroupChatMessageEntity> entities = groupChatMessageRepository.findAll();
        List<GroupChatMessage> dtos = new ArrayList<>();

        for (GroupChatMessageEntity entity : entities
        ) {
            dtos.add(new GroupChatMessage(entity));
        }

        return dtos;
    }

    @GetMapping("/{idGroupChatAdmin}")
    public List<GroupChatMessage> getGroupChatMessagesOfGroup(@PathVariable("idGroupChatAdmin") int idGroupChatAdmin) {
        List<GroupChatMessageEntity> entities = groupChatMessageRepository.
                getGroupChatMessageEntityByGroupChatAdmin_Id(idGroupChatAdmin);
        List<GroupChatMessage> dtos = new ArrayList<>();

        for (GroupChatMessageEntity entity : entities
        ) {
            dtos.add(new GroupChatMessage(entity));
        }

        return dtos;
    }
}
