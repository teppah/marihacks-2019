package com.yfy.hx.lotsofcars.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController  {

    @GetMapping("/home")
    public String hello() {
        return "main";
    }
}
