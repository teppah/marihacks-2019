package com.yfy.hx.lotsofcars.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController  {

    @GetMapping("")
    public String default_landing_page(){
        return "landing";
    }

    @GetMapping("home")
    public String hello() {
        return "main";
    }

    @GetMapping("landing")
    public String landing() {
        return "landing";
    }

    @GetMapping("layout")
    public String layout() {
        return "layout";
    }
}
