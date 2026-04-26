/**
* This class is responsible for accepting input from the user
* @version 1
* @author Michelle Cheng & Adapted from Rolling Project (ITO4131)
*/
import java.util.Scanner;
import java.util.InputMismatchException;
public class Input
{
    /**
    * Default constructor for the Input class
    */
    private Input()
    {
    }

    /**
    * Method that accepts a character via keyboard input from the user
    * 
    * @param displayMessage     Message displayed to the user informing
                                them of what needs to be entered
    * @param index              Where the character is in the input string
    * @return                   The user inputted character
    */
    public static char acceptCharInput(String displayMessage, int index)
        throws StringIndexOutOfBoundsException
    {
        System.out.println(displayMessage);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toUpperCase();
        if (!Validation.isWithinRange(input, 1, 1))
        {
            throw new InputMismatchException("Input cannot be multiple" + 
                " letters.");
        }
        return input.charAt(index);
    } 

    /**
    * Method that accepts a number as an integer via input from the user
    * @param displayMessage     Message displayed to the user informing
                                them of what needs to be entered
    * @return                   The user inputted number as an integer
    */
    public static int acceptIntegerInput(String displayMessage)
        throws NumberFormatException
    {
        System.out.println(displayMessage);
        Scanner scanner = new Scanner(System.in);

        return Integer.parseInt(scanner.nextLine());
    }

    /**
    * Method that accepts a string via keyboard input from the user
    * @param displayMessage     Message displayed to the user informing
                                them of what needs to be entered
    * @return                   The user inputted string
    */
    public static String acceptStringInput(String displayMessage)
    {
        System.out.println(displayMessage);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine().trim();
    }

    /**
    * Method that asks the user for a YES or NO input
    * @param message    The question being asked to the user
    * @return           Whether the user inputted yes
    */
    public static boolean acceptYesNo(String message)
    {
        boolean cont = true;
        message += " (Y/N)";
            do
            {
                try
                {
                    char choice = acceptCharInput(message, 0);
                    if (Character.isLetter(choice))
                    {
                        if (choice == 'N')
                        {
                            return false;
                        }
                        else if (choice == 'Y')
                        {
                            return true;
                        } 
                        else
                        {
                            System.out.println("Error: Enter Y or N");
                        }
                    }
                    else
                    {
                        System.out.println("Error: Please enter a letter");
                    }
                }
                catch (StringIndexOutOfBoundsException sioobe)
                {
                    System.out.println("Error: Entry must not be blank.");
                }
                catch (Exception e)
                {
                    System.out.println("Error: Enter a single letter Y or N.");
                }
            }
            while (cont);
        return false;
    }

    /**
    * Method that prompts the user to press the enter key
    * @param context    A string that finishes the display message 
    *                   appropriately depending on what the situation requires
    */
    public static void promptEnterKey(String context)
    {
        String displayMessage = "Press ENTER when you're ready to " + context;
        boolean cont = true;
        do
        {
            String nextChoice = acceptStringInput(displayMessage);
            if (nextChoice.isBlank())
                cont = false;
        }
        while (cont);
    }    
}
