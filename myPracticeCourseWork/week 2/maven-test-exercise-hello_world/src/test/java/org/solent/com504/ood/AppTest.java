package org.solent.com504.ood;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Test that main doesn't an exception when called.
     */
    @Test
    public void main_DoesNotThrowException_WhenRun()
    {
        String[] args = {};

        App.main(args);

        assertThat(true, equalTo(true));
    }
}
