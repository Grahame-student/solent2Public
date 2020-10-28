package org.solent.com504.factoryandfacade.test.impl;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.solent.com504.factoryandfacade.model.*;
import org.solent.com504.factoryandfacade.impl.AnimalObjectFactory;

import java.util.List;

/**
 * @author cgallen
 */
public class FarmTest
{
    private static final Integer ZERO_ELEMENTS = 0;
    private static final Integer ONE_ELEMENT = 1;

    private static final int FIRST_ELEMENT = 0;

    private static final String SOME_NAME = "Some Name";
    private static final String ANIMAL_NAME = "Ernie";

    FarmFacade farm;

    @Before // setup()
    public void before()
    {
        farm = AnimalObjectFactory.getFarmFacade();
    }

    @Test
    public void getAllAnimals_ReturnsList_OfAllAnimals()
    {
        assertThat(farm.getAllAnimals(), instanceOf(List.class));
    }

    @Test
    public void getAllAnimals_IsEmpty_Initially()
    {
        assertThat(farm.getAllAnimals().size(), equalTo(ZERO_ELEMENTS));
    }

    @Test
    public void addCat_AddsItem_ToAnimalList()
    {
        farm.addCat(SOME_NAME);

        assertThat(farm.getAllAnimals().size(), equalTo(ONE_ELEMENT));
    }

    @Test
    public void addCat_AddsCat_ToAnimalList()
    {
        farm.addCat(SOME_NAME);

        Animal animal = farm.getAllAnimals().get(FIRST_ELEMENT);
        assertThat(animal, instanceOf(Cat.class));
    }

    @Test
    public void addCat_SetsCatName_ToPassedInName()
    {
        farm.addCat(ANIMAL_NAME);

        Animal animal = farm.getAllAnimals().get(FIRST_ELEMENT);
        assertThat(animal.getName(), equalTo(ANIMAL_NAME));
    }

    @Test
    public void addDog_AddsItem_ToAnimalList()
    {
        farm.addDog(SOME_NAME);

        assertThat(farm.getAllAnimals().size(), equalTo(ONE_ELEMENT));
    }

    @Test
    public void addDog_AddsDog_ToAnimalList()
    {
        farm.addDog(SOME_NAME);

        Animal animal = farm.getAllAnimals().get(FIRST_ELEMENT);
        assertThat(animal, instanceOf(Dog.class));
    }

    @Test
    public void addDog_SetsDogName_ToPassedInName()
    {
        farm.addDog(ANIMAL_NAME);

        Animal animal = farm.getAllAnimals().get(FIRST_ELEMENT);
        assertThat(animal.getName(), equalTo(ANIMAL_NAME));
    }

    @Test
    public void addCow_AddsItem_ToAnimalList()
    {
        farm.addCow(SOME_NAME);

        assertThat(farm.getAllAnimals().size(), equalTo(ONE_ELEMENT));
    }

    @Test
    public void addCow_AddsCow_ToAnimalList()
    {
        farm.addCow(SOME_NAME);

        Animal animal = farm.getAllAnimals().get(FIRST_ELEMENT);
        assertThat(animal, instanceOf(Cow.class));
    }

    @Test
    public void addCow_SetsCowName_ToPassedInName()
    {
        farm.addCow(ANIMAL_NAME);

        Animal animal = farm.getAllAnimals().get(FIRST_ELEMENT);
        assertThat(animal.getName(), equalTo(ANIMAL_NAME));
    }

    @Test
    public void addDuck_AddsItem_ToAnimalList()
    {
        farm.addDuck(SOME_NAME);

        assertThat(farm.getAllAnimals().size(), equalTo(ONE_ELEMENT));
    }

    @Test
    public void addDuck_AddsDuck_ToAnimalList()
    {
        farm.addDuck(SOME_NAME);

        Animal animal = farm.getAllAnimals().get(FIRST_ELEMENT);
        assertThat(animal, instanceOf(Duck.class));
    }

    @Test
    public void addDuck_SetsDuckName_ToPassedInName()
    {
        farm.addDuck(ANIMAL_NAME);

        Animal animal = farm.getAllAnimals().get(FIRST_ELEMENT);
        assertThat(animal.getName(), equalTo(ANIMAL_NAME));
    }
}
