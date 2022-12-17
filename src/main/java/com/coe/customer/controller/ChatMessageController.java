package com.coe.customer.controller;

import com.coe.customer.entity.ChatMessageEntity;
import com.coe.customer.repository.ChatMessageRepository;
import com.coe.kafkaproducer.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/chat-message")
public class ChatMessageController {
    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageController(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @GetMapping("")
    public List<ChatMessage> getChatMessages() {
        List<ChatMessageEntity> entities = chatMessageRepository.findAll();
        List<ChatMessage> dtos = new ArrayList<>();
        for (ChatMessageEntity entity : entities
        ) {
            dtos.add(new ChatMessage(entity));
        }
        return dtos;
    }

    @GetMapping("/{idChat}")
    public List<ChatMessage> getChatMessagesByChatId(@PathVariable("idChat") int idChat) {
        List<ChatMessageEntity> entities = chatMessageRepository.getChatMessageEntitiesByChat_Id(idChat);
        List<ChatMessage> dtos = new ArrayList<>();
        for (ChatMessageEntity entity : entities
        ) {
            dtos.add(new ChatMessage(entity));
        }
        return dtos;
    }
}
