package com.example.telegramProgect.controller;

import com.example.telegramProgect.model.dto.user.UserRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping(value = "/menu")
public class Menu {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String returnToMenu(@RequestParam String id, @ModelAttribute UserRequestDto userRequestDto, Model model){
        model.addAttribute("name",userRequestDto.getName());
        model.addAttribute("username",userRequestDto.getUsername());
        model.addAttribute("password",userRequestDto.getPassword());
        model.addAttribute("phoneNumber",userRequestDto.getPhoneNumber());
        model.addAttribute("id",id);
        return "menu";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String returnToIndex(){
        return "index";
    }

}
