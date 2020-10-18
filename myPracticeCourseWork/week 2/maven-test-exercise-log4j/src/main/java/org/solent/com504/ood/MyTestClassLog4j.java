package org.solent.com504.ood;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Test class to demonstrate use of log4j.
 */
public final class MyTestClassLog4j
{
    /**
     * field to hold a reference to the logger shared by all instances of this class.
     */
    private static final Logger logger = LogManager.getLogger(MyTestClassLog4j.class);

    /**
     * Main function - entry point for the application.
     * @param args List of arguments passed to the main function
     */
    public static void main(final String[] args)
    {
        MyTestClassLog4j myTestClassLog4j = new MyTestClassLog4j();
        myTestClassLog4j.writeAboutMe();
    }

    /**
     * Log the name of the class.
     */
    private void writeAboutMe()
    {
        System.out.println("This is a system out message from : " + MyTestClassLog4j.class);
        logger.error("This is a log4j message from : " + MyTestClassLog4j.class);
    }

    /**
     *
     * @param name
     * @return
     */
    public String talkAboutMe(final String name)
    {
        return "talking about " + name;
    }
}
