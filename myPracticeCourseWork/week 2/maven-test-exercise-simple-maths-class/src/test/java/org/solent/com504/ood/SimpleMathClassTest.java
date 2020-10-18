package org.solent.com504.ood;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.Test;

/**
 *
 * @author cgallen
 */
public class SimpleMathClassTest
{
    /**
     *
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
     *
     */
    @Test
    public void testAdd()
    {
        SimpleMathClass simpleMathClass = new SimpleMathClass();
        double result = simpleMathClass.add(1.5, 300);

        // expected, result, delta (compare floating point numbers
        assertThat(result, closeTo(301.5, 0.00001));
    }

    /**
     *
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

        // expected, result, delta (compare floating point numbers
        assertThat(result, closeTo(301.5, 0.00001));
    }
}
