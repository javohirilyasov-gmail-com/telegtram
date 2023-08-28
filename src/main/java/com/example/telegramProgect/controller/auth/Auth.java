package com.example.telegramProgect.controller.auth;

import com.example.telegramProgect.model.User;
import com.example.telegramProgect.model.dto.user.UserRequestDto;
import com.example.telegramProgect.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/auth")
public class Auth {

    private final UserService userService;

    public Auth(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String signInGet(){
        return "sign-in";
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public String signInPost(@RequestParam String phoneNumber, @RequestParam String password, Model model) throws SQLException, ClassNotFoundException {
        User user = userService.findByUserPhone(phoneNumber);
        if (user != null){
            if (user.getPassword().equals(password)){
                model.addAttribute("id",user.getId());
                model.addAttribute("username",user.getUsername());
                model.addAttribute("name",user.getName());
                model.addAttribute("username",user.getUsername());
                model.addAttribute("phoneNumber",user.getPhoneNumber());
                return "/menu";
            }else {
                model.addAttribute("incorrectPasswd","You have entered password incorrect");
                return "sign-in";
            }
        }
        model.addAttribute("userNotFound","This kind of user not found ");
        return "index";
    }


    @RequestMapping(value = "/sign-up",method = RequestMethod.GET)
    public String signUpGet(){
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String signUpPost(@ModelAttribute UserRequestDto userDto, Model model) throws SQLException, ClassNotFoundException {
        if(userDto != null) {
            User user = userService.checkerPhoneNumber(userDto);
            userService.create(user);
            model.addAttribute("username", userDto.getUsername());
            model.addAttribute("id",user.getId());
            model.addAttribute("name",user.getName());
            model.addAttribute("username",user.getUsername());
            model.addAttribute("phoneNumber",user.getPhoneNumber());
            return "menu";
        }else {
            return "index";
        }
    }

}
