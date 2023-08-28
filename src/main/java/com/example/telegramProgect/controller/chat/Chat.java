package com.example.telegramProgect.controller.chat;

import com.example.telegramProgect.model.User;
import com.example.telegramProgect.model.dto.chat.ChatRequestDto;
import com.example.telegramProgect.service.message.MessageService;
import com.example.telegramProgect.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/chat")
public class Chat {

    private final UserService userService;
    private final MessageService messageService;

    public Chat(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @RequestMapping(value = "/create-chat", method = RequestMethod.GET)
    public String createChatGetMethod(@RequestParam String id, @RequestParam String username, Model model){
        model.addAttribute("id",id);
        model.addAttribute("username",username);
        return "create-chat";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String returnToChat(@RequestParam String id,@RequestParam String username, Model model){
        model.addAttribute("id",id);
        model.addAttribute("username", username);
        return "chat";
    }


    @RequestMapping(value = "/create-chat", method = RequestMethod.POST)
    public String createChatPostMethod(@ModelAttribute ChatRequestDto chatRequestDto, Model model) throws SQLException, ClassNotFoundException {

        User receiverUser = userService.findByUserPhone(chatRequestDto.getReceiverPhoneNumber());
        if (receiverUser != null){
            System.out.println(chatRequestDto);
            chatRequestDto.setReceiverId(receiverUser.getId());
            chatRequestDto.setReceiverUsername(receiverUser.getUsername());
            messageService.create(chatRequestDto);
        }else {
            model.addAttribute("sms","This user do not have an account in Telegram ");
            return "create-chat";
        }
        return "create-chat";
    }



}
