package com.yfy.hx.lotsofcars.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController  {

    @GetMapping("")
    public String default_landing_page(){
        return "landing";
    }

    @GetMapping("car")
    public String hello() {
        return "main";
    }

    @GetMapping("er")
    public String landing() {
        return "ambulance_simulator";
    }

    @GetMapping("layout")
    public String layout() {
        return "layout";
    }
}
