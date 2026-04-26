/**
* This class is responsible for performing validations on user input
* @version 1
* @author Michelle Cheng & Adapted from Rolling Project (ITO4131)
*/
public class Validation
{
    /**
    * Default constructor to create a Validation object
    */
    private Validation()
    {
    }

    /**
    * Method make sure user input isn't empty
    * @param input  String variable being checked for emptiness/containment
    *               of blank spaces
    * @return       Whether the input is blank or not as a boolean
    */
    public static boolean isBlank(String input)
    {
        return input.isBlank();
    }

    /**
    * Method make sure user input isn't empty
    * @param input  char variable being checked for emptiness/containment
    *               of blank spaces
    * @return       Whether the input is blank or not as a boolean
    */
    public static boolean isBlank(char input)
    {
        return Character.toString(input).isBlank();
    }

    /**
    * Method that checks if the length of an input is within the required range
    * @param input      String whose length is being checked
    * @param minimum    Minimum numerical length of characters the input can be
    * @param maximum    Maximum numerical length of characters the input can be
    * @return           Whether the input's length is within range, as a 
    *                   boolean
    */
    public static boolean isWithinRange(String input, int minimum, int maximum)
    {
        int inputLength = input.trim().length();
        if (inputLength < minimum || inputLength > maximum)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
    * Method that checks if a number is within the required range
    * @param number     Number being checked
    * @param minimum    Minimum of range
    * @param maximum    Maximum of range
    * @return           Whether the number is within range, as a boolean
    */
    public static boolean isWithinRange(int number, int minimum, int maximum)
    {
        if (number < minimum || number > maximum)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
