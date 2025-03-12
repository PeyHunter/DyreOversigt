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
    private Zoo zoo = new Zoo(); //opretter en instans af zoo, som kan bruges i controlleren

    @GetMapping("/")
    public String showZoo(Model model)
    {
        model.addAttribute("animals", zoo.getAnimals());
        return "/index";
    }

    @PostMapping("/addAnimal") //her er controlleren til at adde dyr!
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
            case "Crocodile":
                animal = (new Crocodile(maleCount, femaleCount));
                break;
            case "Elephant":
                animal = (new Elephant(maleCount, femaleCount));
                break;
            case "Giraph":
                animal = (new Giraph(maleCount, femaleCount));
                break;
            case "Zebra":
                animal = (new Zebra(maleCount, femaleCount));
                break;
            case "Hyena":
                animal = (new Hyena(maleCount, femaleCount));
                break;
            default:
                throw new IllegalArgumentException("Unknown species: " + species);
        }
        zoo.addAnimals(animal);
        model.addAttribute("animal", animal);
        model.addAttribute("animals", zoo.getAnimals());
        return "redirect:/";
    }

    @GetMapping("/elephant")
    public String showElephantPage() {
        return "elephant";
    }

    @GetMapping("/crocodile")
    public String showCrocodilePage() {
        return "crocodile";
    }

    @GetMapping("/lion")
    public String showLionPage() {
        return "lion";
    }

    @GetMapping("/hyena")
    public String showHyenaPage() {
        return "hyena";  // Refers to src/main/resources/templates/AnimalPages/elephant.html
    }

    @GetMapping("/giraph")
    public String showGiraphPage() {
        return "giraph";  // Refers to src/main/resources/templates/AnimalPages/elephant.html
    }

    @GetMapping("/zebra")
    public String showZebraPage() {
        return "zebra";  // Refers to src/main/resources/templates/AnimalPages/elephant.html
    }

    @PostMapping("/deleteAnimal")
    public String deleteAnimal(@RequestParam String species, Model model) {
        zoo.deleteAnimal(species);
        model.addAttribute("animals", zoo.getAnimals());
        return "redirect:/";
    }
}




