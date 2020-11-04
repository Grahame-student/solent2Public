package org.solent.com504.factoryandfacade.model.dto;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author gwhite
 */
public class AnimalTest
{
    private final String EMPTY_STRING = "";
    private final String ANIMAL_NAME = "Bert von Ernie";
    private final String ANIMAL_ADDRESS = "123 Some Street, etc";
    private final String ANIMAL_FOOD = "chocolate brownies";
    private final String ANIMAL_TYPE = "crazy badger";
    private final long ANIMAL_ID = 12345;

    @Test
    public void GetAddress_ReturnsEmptyString_Initially()
    {
        Animal animal = new Animal();

        assertThat(animal.getAddress(), equalTo(EMPTY_STRING));
    }

    @Test
    public void SetAddress_SetsAddress_ToPassedInValue()
    {
        Animal animal = new Animal();

        animal.setAddress(ANIMAL_ADDRESS);

        assertThat(animal.getAddress(), equalTo(ANIMAL_ADDRESS));
    }

    @Test
    public void GetFood_ReturnsEmptyString_Initially()
    {
        Animal animal = new Animal();

        assertThat(animal.getFood(), equalTo(EMPTY_STRING));
    }

    @Test
    public void SetFood_SetsFood_ToPassedInValue()
    {
        Animal animal = new Animal();

        animal.setFood(ANIMAL_FOOD);
    }

    @Test
    public void ToString_ReturnsStringRepresentation_OfAnimal()
    {
        // Create a mock of the AnimalType class as it may change and cause this test to break
        AnimalType type = mock(AnimalType.class);
        when(type.toString()).thenReturn(ANIMAL_TYPE);

        Animal animal = new Animal();
        animal.setName(ANIMAL_NAME);
        animal.setAddress(ANIMAL_ADDRESS);
        animal.setAnimalType(type);
        animal.setId(ANIMAL_ID);
        animal.setFood(ANIMAL_FOOD);

        final String EXPECTED_STRING = "Animal{name=Bert von Ernie, address=123 Some Street, etc, animalType=crazy badger, food=chocolate brownies, id=12345}";

        assertThat(animal.toString(), equalTo(EXPECTED_STRING));
    }
}
