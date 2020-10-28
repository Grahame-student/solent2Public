package org.solent.com504.factoryandfacade.impl;

import org.solent.com504.factoryandfacade.model.Animal;
import org.solent.com504.factoryandfacade.model.FarmFacade;

import java.util.ArrayList;
import java.util.List;

public class Farm implements FarmFacade
{
    private final List<Animal> animals = new ArrayList<>();

    @Override
    public List<Animal> getAllAnimals()
    {
        return animals;
    }

    @Override
    public void addDog(String name)
    {
        addAnimal(AnimalObjectFactory.createDog(), name);
    }

    @Override
    public void addCat(String name)
    {
        addAnimal(AnimalObjectFactory.createCat(), name);
    }

    @Override
    public void addCow(String name)
    {
        addAnimal(AnimalObjectFactory.createCow(), name);
    }

    @Override
    public void addDuck(String name)
    {
        addAnimal(AnimalObjectFactory.createDuck(), name);
    }

    private void addAnimal(Animal animal, String name)
    {
        animal.setName(name);
        animals.add(animal);
    }
}
