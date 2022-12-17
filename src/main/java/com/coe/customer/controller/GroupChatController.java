package com.coe.customer.controller;

import com.coe.customer.entity.GroupChatEntity;
import com.coe.customer.repository.GroupChatRepository;
import com.coe.kafkaproducer.model.GroupChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/group-chat")
@CrossOrigin
public class GroupChatController {
    private final GroupChatRepository groupChatRepository;

    @Autowired
    public GroupChatController(GroupChatRepository groupChatRepository) {
        this.groupChatRepository = groupChatRepository;
    }

    @GetMapping("/{idChat}")
    public GroupChat getGroupChatById(@PathVariable("idChat") int idChat) {
        GroupChatEntity entity = groupChatRepository.findById(idChat).orElse(null);

        if (entity != null) {
            return new GroupChat(entity);
        }

        return null;
    }

    @GetMapping("")
    public List<GroupChat> getGroupChats() {
        List<GroupChatEntity> entities = groupChatRepository.findAll();
        List<GroupChat> dtos = new ArrayList<>();

        for (GroupChatEntity entity : entities
        ) {
            dtos.add(new GroupChat(entity));
        }

        return dtos;
    }
}
