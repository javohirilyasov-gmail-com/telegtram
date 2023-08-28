package com.example.telegramProgect.controller.user;

import com.example.telegramProgect.model.User;
import com.example.telegramProgect.model.dto.user.UserRequestDto;
import com.example.telegramProgect.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String profileMethodGet(@ModelAttribute UserRequestDto dto, Model model) throws SQLException, ClassNotFoundException {
        User user = userService.findByUserPhone(dto.getPhoneNumber());
        model.addAttribute("id",user.getId());
        model.addAttribute("name",user.getName());
        model.addAttribute("username",user.getUsername());
        model.addAttribute("phoneNumber",user.getPhoneNumber());
        return "profile";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editMethodGet(@RequestParam String id, @ModelAttribute UserRequestDto userRequestDto, Model model){
        model.addAttribute("name",userRequestDto.getName());
        model.addAttribute("username", userRequestDto.getUsername());
        model.addAttribute("phoneNumber",userRequestDto.getPhoneNumber());
        model.addAttribute("id",id);
        return "edit-profile";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String editMethodPost(@ModelAttribute UserRequestDto userRequestDto,Model model) throws SQLException, ClassNotFoundException {
        UUID id = null;
        if (userRequestDto != null){
            userService.update(userRequestDto);
         id = userRequestDto.getId();
        }
        model.addAttribute("id",id);
        return "edit-profile";
    }




}
