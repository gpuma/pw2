package com.ejemplo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/greeting.do")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="Fulano") String name, Model model) {
        model.addAttribute("name", name);
        //return "hola";
        return "saludo";
    }

}