package org.solent.com504.ood;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.Test;

/**
 * Unit tests against the SimpleMathClass class.
 * @author cgallen
 */
public class SimpleMathClassTest
{
    /**
     * Test that main doesn't throw an exception with valid inputs
     */
    @Test
    public void testMain()
    {
        String[] args =
        {
            "add", "1.5", "300"
        };
        SimpleMathClass.main(args);
    }

    /**
     * Remove this test as the maths functions should be private
     */
    @Test
    public void testAdd()
    {
        double number1 = 1.5;
        double number2 = 300;

        SimpleMathClass simpleMathClass = new SimpleMathClass();
        double result = simpleMathClass.add(number1, number2);

        double expectedResult = 301.5;
        double acceptableDelta = 0.00001;

        // expected, result, delta (compare floating point numbers
        assertThat(result, closeTo(expectedResult, acceptableDelta));
    }

    /**
     * remove this test as the parser should be private
     */
    @Test
    public void testParseAdd()
    {
        SimpleMathClass simpleMathClass = new SimpleMathClass();

        String[] args =
        {
            "add", "1.5", "300"
        };
        double result = simpleMathClass.parseArguments(args);

        double expectedResult = 301.5;
        double acceptableDelta = 0.00001;
        // expected, result, delta (compare floating point numbers
        assertThat(result, closeTo(expectedResult, acceptableDelta));
    }
}
