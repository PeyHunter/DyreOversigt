package com.example.dyreoversigt.model;

public  class Animal
{

    private String species;
    private int maleCount;
    private int femaleCount;

    public Animal(String species, int maleCount, int femaleCount)
    {
        this.species = species;
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
    }

    public String getSpecies()
    {
        return species;
    }

    public int getMaleCount()
    {
        return maleCount;
    }

    public int getFemaleCount()
    {
        return femaleCount;
    }

    public int getTotalAnimals()
    {
        return maleCount + femaleCount;
    }



}