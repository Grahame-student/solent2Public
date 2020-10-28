/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.test.impl;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import org.solent.com504.factoryandfacade.impl.Farm;
import org.solent.com504.factoryandfacade.model.*;
import org.solent.com504.factoryandfacade.impl.AnimalObjectFactory;

/**
 * @author gallenc
 */
public class AnimalObjectFactoryTest
{
    @Test
    public void createCat_Returns_CatObject()
    {
        Animal animal = AnimalObjectFactory.createCat();

        assertThat(animal, instanceOf(Cat.class));
    }

    @Test
    public void createDog_Returns_DogObject()
    {
        Animal animal = AnimalObjectFactory.createDog();

        assertThat(animal, instanceOf(Dog.class));
    }

    @Test
    public void createDog_Returns_CowObject()
    {
        Animal animal = AnimalObjectFactory.createCow();

        assertThat(animal, instanceOf(Cow.class));
    }

    @Test
    public void createDog_Returns_DuckObject()
    {
        Animal animal = AnimalObjectFactory.createDuck();

        assertThat(animal, instanceOf(Duck.class));
    }

    @Test
    public void createFarm_Returns_FarmObject()
    {
        FarmFacade farm = new Farm();

        assertThat(farm, instanceOf(Farm.class));
    }
}
