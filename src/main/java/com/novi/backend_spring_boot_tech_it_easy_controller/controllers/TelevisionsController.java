package com.novi.backend_spring_boot_tech_it_easy_controller.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


public class TelevisionsController {
    @GetMapping("/televisions")
    @ResponseBody
    public String getAllTelevisions() {
        return "List Televisions";
    }
    @GetMapping("/televisions/{model}")
    @ResponseBody
    public String getTelevision (@PathVariable String model) {
        return "Type television" + model;
    }
}
