package com.example.dars5_sptring.telegramProgect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String controller(){
        return "home";
    }
}
