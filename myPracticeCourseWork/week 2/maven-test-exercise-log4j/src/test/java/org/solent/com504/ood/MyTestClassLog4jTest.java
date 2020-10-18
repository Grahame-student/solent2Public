package org.solent.com504.ood;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author cgallen
 */
public class MyTestClassLog4jTest
{
    @Test
    public void shouldAnswerAboutMe()
    {
        MyTestClassLog4j myTest = new MyTestClassLog4j();
        myTest.writeAboutMe();
    }

    @Test
    public void shouldAnswerWithName()
    {
        MyTestClassLog4j myTest = new MyTestClassLog4j();
        String result = myTest.talkAboutMe("Craig");
        System.out.println(result);

        assertTrue("talking about Craig".equals(result));
    }
}
