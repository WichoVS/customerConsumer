package com.coe.customer.controller;

import com.coe.customer.entity.ChatEntity;
import com.coe.customer.repository.ChatRepository;
import com.coe.kafkaproducer.model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/chat")
@CrossOrigin
public class ChatController {
    private final ChatRepository chatRepository;

    @Autowired
    public ChatController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @GetMapping("")
    public List<Chat> getAllChats() {
        List<ChatEntity> entities = chatRepository.findAll();
        List<Chat> dtos = new ArrayList<>();

        for (ChatEntity entity : entities
        ) {
            dtos.add(new Chat(entity));
        }

        return dtos;
    }

    @GetMapping("/{idCustomer}")
    public List<Chat> getCustomerChats(@PathVariable("idCustomer") int idCustomer) {
        List<ChatEntity> entities = chatRepository.getChatEntitiesByCustomer_Id(idCustomer);
        List<Chat> dtos = new ArrayList<>();

        for (ChatEntity entity : entities
        ) {
            dtos.add(new Chat(entity));
        }

        return dtos;
    }
}
