/**
* This class is responsible for the text displayed during the game
* @version  1
* @author   Michelle Cheng
*/
public class Message
{
    /**
    * Default constructor for the Message class.
    */
    public Message()
    {
    }

    /**
    * Method that displays the message when all fellowship members have died
    */
    public void displayAllDiedMessage()
    {
        System.out.println("All members of the fellowship have died.");
        System.out.println("Better luck next time.");
        displayGameOver();
    }

    /**
    * Method that displays information about a cave once entered
    * @param caveID   The cave identity that the fellowship has just entered
    */
    public void displayCaveEntry(int caveID)
    {
        System.out.println("Entering cave " + caveID + "...");
        printBlankLine();
    }


    /**
    * Method that displays loading messages about the input files
    * @param caveNumber     The number of caves in the labyrinth
    */
    public void displayGameLoadingMessage(int caveNumber)
    {
        printBlankLine();
        System.out.println("...Building the game");
        System.out.println("...Building labyrinth and caves");
        System.out.println("      * Number of caves: " + caveNumber);
        printBlankLine();
    }

    /**
    * Method that displays the outcome message of the game
    * @param codeStolen     Whether the code is stolen by the end of the game
    */
    public void displayGameOutcomeMessage(boolean codeStolen)
    {
        System.out.println("You've reached Mount Api...");
        if (codeStolen)
        {
            System.out.println("but you've failed to deliver the secret" +
                " code.");
            printBlankLine();
            System.out.println("Quest Failed.");
        }
        else
        {
            System.out.println("and successfully delivered the secret code" +
                " to the Java wizard!");
                printBlankLine();
            System.out.println("Quest Complete!");
            System.out.println("Congratulations!");
        }
        displayGameOver();
    }

    /**
    * Method that displays game over message
    */
    private void displayGameOver()
    {
        printBlankLine();
        System.out.println("Game Over");
    }

    /**
    * Method that displays message that indicates the identity of the holder
    */
    public void displaySecretCodeHolderMessage()
    {
        System.out.println("(The # denotes who is holding the secret code.)");
        printBlankLine();
    }

    /**
    * Method that displays the messages required to set up the team
    */
    public void displayTeamSetupInstructions()
    {
        printBlankLine();
        System.out.println("= SET UP THE FELLOWSHIP TEAM =");
        printBlankLine();
        System.out.println("It's time to choose your team.");
        System.out.println("The leader is a hobbit.");
        System.out.println("Please choose up to 3 more members.");
    }

    /**
    * Method that displays the welcome message for the game
    */
    public void displayWelcomeMessage()
    {
        System.out.println("=== Welcome to FELLOWSHIP OF CODE ");
        System.out.println("- A Java Adventure in Middle Earth ===");
        printBlankLine();
        System.out.println("Four adventurers are on a quest to deliver a");
        System.out.println("secret code to the Java Wizard on Mount Api.");
        System.out.println("A labyrinth and monsters stand in their way.");
        System.out.println("PROTECT the code from thieving monsters and");
        System.out.println("HELP the adventurers navigate the labyrinth!");
        printBlankLine();
        System.out.println("1 - PLAY");
        System.out.println("2 - EXIT");
        printBlankLine();
    }

    /**
    * Method that prints a blank line for formatting purposes
    */
    public static void printBlankLine()
    {
        System.out.println("");
    }
}
