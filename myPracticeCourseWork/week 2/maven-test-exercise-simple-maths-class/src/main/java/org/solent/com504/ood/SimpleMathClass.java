package org.solent.com504.ood;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author cgallen
 */
public class SimpleMathClass
{
    /**
     *
     */
    public final static Logger LOG = LogManager.getLogger(SimpleMathClass.class);

    // main class is called when a java program is started
    // try java
    public static void main(final String[] args)
    {
        String arguments = "Program called with arguments:";
        for (int i = 0; i < args.length; i++)
        {
            arguments = arguments + " " + args[i];
        }
        System.out.println(arguments);

        SimpleMathClass mathClass = new SimpleMathClass();
        try
        {
            double result = mathClass.parseArguments(args);
            System.out.println("Result =" + result);
        }
        catch (Exception e)
        {
            System.out.println("problem with arguments " + e.getMessage());
        }
    }

    /**
     *
     * @param arguments
     * @return
     */
    public double parseArguments(final String[] arguments)
    {
        LOG.debug("parseArguments called with arguments: " + arguments);

        // better - you print out the arguments and only run this code block if in debug mode
        if (LOG.isDebugEnabled())
        {
            String msg = "parseArguments called with arguments:";
            for (int i = 0; i < arguments.length; i++)
            {
                msg = msg + " " + arguments[i];
                LOG.debug(msg);
            }
        }

        if (arguments.length != 3)
        {
            throw new IllegalArgumentException("you must have 3 arguments (add|subrract) number1 number2");
        }
        double answer = 0;
        double number1 = Double.valueOf(arguments[1]);
        double number2 = Double.valueOf(arguments[2]);
        switch (arguments[0])
        {
            case "add":
                answer = add(number1, number2);
                break;
            case "subtract":
                answer = subtract(number1, number2);
                break;
            default:
                throw new IllegalArgumentException("unknown argument:" + arguments[0]);
        }
        return answer;
    }

    /**
     *
     * @param number1
     * @param number2
     * @return
     */
    public double add(double number1, double number2)
    {
        return number1 + number2;
    }

    /**
     *
     * @param number1
     * @param number2
     * @return
     */
    public double subtract(double number1, double number2)
    {
        return number1 - number2;
    }

    /**
     *
     * @param number1
     * @param number2
     * @return
     */
    public double multiply(double number1, double number2)
    {
        return Double.NaN;
    }

    /**
     * 
     * @param number1
     * @param number2
     * @return
     */
    public double divide(double number1, double number2)
    {
        return Double.NaN;
    }
}
