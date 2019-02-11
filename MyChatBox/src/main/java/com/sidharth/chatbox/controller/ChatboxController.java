package com.sidharth.chatbox.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.sidharth.chatbox.model.ChatMessageModel;

@Controller
public class ChatboxController {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public ChatMessageModel sendMessage(@Payload ChatMessageModel chatMessage) {
        return chatMessage;
    }
	
	@MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessageModel addUser(@Payload ChatMessageModel chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
