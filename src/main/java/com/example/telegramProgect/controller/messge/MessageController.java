package com.example.telegramProgect.controller.messge;

import com.example.telegramProgect.service.message.MessageService;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {


    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }



}
