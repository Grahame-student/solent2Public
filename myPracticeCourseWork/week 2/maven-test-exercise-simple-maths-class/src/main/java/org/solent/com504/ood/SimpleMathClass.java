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
    public static final Logger LOG = LogManager.getLogger(SimpleMathClass.class);

    /**
     * Main entry point to the application.
     * @param args array of strings, where each one represents an argumentS
     */
    public static void main(final String[] args)
    {
        String arguments = "Program called with arguments:";
        for (String arg : args)
        {
            arguments = arguments + " " + arg;
        }
        System.out.println(arguments);

        SimpleMathClass mathClass = new SimpleMathClass();
        try
        {
            double result = mathClass.parseArguments(args);
            System.out.println("Result = " + result);
        }
        catch (Exception e)
        {
            System.out.println("problem with arguments " + e.getMessage());
        }
    }

    /**
     * Parse the parameters and carry out the appropriate mathematical operation.
     * @param arguments
     * @return return the result from the requested mathematical operation
     */
    public double parseArguments(final String[] arguments)
    {
        final int reqArgCount = 3;

        LOG.debug("parseArguments called with arguments: " + String.join(", ", arguments));

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

        if (arguments.length != reqArgCount)
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
     * Add {@code number1} to {@code number2}.
     * @param number1
     * @param number2
     * @return the sum of {@code number1} and {@code number2}
     */
    public double add(final double number1, final double number2)
    {
        return number1 + number2;
    }

    /**
     * Subtract {@code number2} from {@code number1}.
     * @param number1
     * @param number2
     * @return the result of subtracting {@code number2} from {@code number1}
     */
    public double subtract(final double number1, final double number2)
    {
        return number1 - number2;
    }

    /**
     *
     * @param number1
     * @param number2
     * @return the result of multiplying {code number1} from {@code number2}
     */
    public double multiply(final double number1, final double number2)
    {
        return Double.NaN;
    }

    /**
     *
     * @param number1
     * @param number2
     * @return the result of dividing {code number1} by {@code number2}
     */
    public double divide(final double number1, final double number2)
    {
        return Double.NaN;
    }
}
