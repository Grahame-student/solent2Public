package org.solent.com504.ood;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

/**
 * Unit tests for the simple log4j class.
 */
public class MyTestClassLog4jTest
{
    /**
     * Running main should not throw an exception.
     */
    @Test
    public void shouldAnswerAboutMe()
    {
        String[] args = {};

        MyTestClassLog4j.main(args);

        assertThat(true, equalTo(true));
    }

    /**
     * Test that talkAboutMe appends the passed in string to "talking about ".
     */
    @Test
    public void shouldAnswerWithName()
    {
        MyTestClassLog4j myTest = new MyTestClassLog4j();
        String result = myTest.talkAboutMe("Craig");
        System.out.println(result);

        assertThat(result, equalTo("talking about Craig"));
    }
}
