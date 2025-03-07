package com.example.dyreoversigt.controller;

import com.example.dyreoversigt.model.Zoo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ZooController
{
    private Zoo zoo = new Zoo();

    @GetMapping("/addAnimal")

        public String showForm(Model model)
        {
            model.addAttribute("zoo", zoo);
            return "add-animal";
        }


}
