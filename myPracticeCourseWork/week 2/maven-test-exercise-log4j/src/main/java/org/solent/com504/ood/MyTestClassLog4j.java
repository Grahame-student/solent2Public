package org.solent.com504.ood;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Test class to demonstrate use of log4j.
 */
public final class MyTestClassLog4j
{
    public static Logger logger = LogManager.getLogger(MyTestClassLog4j.class);

    public static void main(final String[] args)
    {
        MyTestClassLog4j myTestClassLog4j = new MyTestClassLog4j();
        myTestClassLog4j.writeAboutMe();
    }

    /**
     * This is a javadoc comment on writeAboutMe.
     */
    public void writeAboutMe()
    {
        System.out.println("This is a system out message from : "+ MyTestClassLog4j.class);
        logger.error("This is a log4j message from : "+ MyTestClassLog4j.class);
    }

    /**
     *
     * @param name
     * @return
     */
    public String talkAboutMe(String name)
    {
        return "talking about "+name;
    }
}
