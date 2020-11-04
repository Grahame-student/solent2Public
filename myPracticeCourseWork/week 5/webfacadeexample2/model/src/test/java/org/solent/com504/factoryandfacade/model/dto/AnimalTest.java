package org.solent.com504.factoryandfacade.model.dto;

import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author gwhite
 */
public class AnimalTest
{
    private final String EMPTY_STRING = "";
    private final String ANIMAL_ADDRESS = "123 Some Street, etc";

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
}
