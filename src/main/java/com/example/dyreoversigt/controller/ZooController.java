package com.example.dyreoversigt.controller;

import com.example.dyreoversigt.model.*;
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

    @PostMapping("/addAnimal")
    public String addAnimal(@RequestParam String species,
                            @RequestParam int maleCount,
                            @RequestParam int femaleCount,
                            Model model)
    {
        Animal animal = null;

        switch (species)
        {
            case "Lion":
                animal = (new Lion(maleCount, femaleCount));
                break;
            case "Tiger":
                animal = (new Crocodile(maleCount, femaleCount));
                break;
            case "Elephant":
                animal = (new Elephant(maleCount, femaleCount));
                break;
            case "Giraffe":
                animal = (new Giraph(maleCount, femaleCount));
                break;
            case "Zebra":
                animal = (new Zebra(maleCount, femaleCount));
                break;
            case "Panda":
                animal = (new Hyena(maleCount, femaleCount));
                break;
            default:
                throw new IllegalArgumentException("Unknown species: " + species);
        }
        zoo.addAnimals(animal);
        model.addAttribute("animal", animal);
        model.addAttribute("animals", zoo.getAnimals());
        return "redirect:/addAnimal";
    }

    @GetMapping("/animal-added")
    public String displayZoo(Model model)
    {
        model.addAttribute("animals", zoo.getAnimals());
        return "add-animal";
    }


}


