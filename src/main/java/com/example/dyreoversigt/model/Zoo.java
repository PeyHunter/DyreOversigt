package com.example.dyreoversigt.model;

import java.util.ArrayList;
import java.util.List;

public class Zoo
{
    private List<Animal> animals = new ArrayList<Animal>();

    public void addAnimals(Animal animal)
    {
        animals.add(animal);
    }

    public List<Animal> getAnimals()
    {
        return animals;
    }




}
