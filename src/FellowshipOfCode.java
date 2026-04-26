/**
* This class is responsible for running the Fellowship of Code game
* @version 1
* @author Michelle Cheng & Adapted from Rolling Project (ITO4131) 
*/
public class FellowshipOfCode
{
    public final String INPUT_TEXT_FILENAME = "labyrinth.txt";
    public final String OUTPUT_TEXT_FILENAME = "fellowship.txt";
    public static final int MOUNT_API = 100;
    private FOCManager fOCManager;
    private LabyrinthBuilder labyrinthBuilder;
    private Message message;

    /**
    * Default constructor for the FellowshipOfCode class
    */
    public FellowshipOfCode()
    {
        this.fOCManager = new FOCManager();
        this.labyrinthBuilder = new LabyrinthBuilder();
        this.message = new Message();
    }

    /**
    * Non-default constructor for the FellowshipOfCode class
    * @param fOCManager The FOCManager object
    */
    public FellowshipOfCode(FOCManager fOCManager)
    {
        this.fOCManager = fOCManager;
        this.labyrinthBuilder = new LabyrinthBuilder();
        this.message = new Message();
    }

    /**
    * Method to ask user if they want to use the fighter's weapon
    * @param index  The index of the adventurer fighting
    * @return       Whether the special weapon will be used
    */
    private boolean askToUseWeapon(int index)
    {
        if (fOCManager.doesAdventurerHaveWeapon(index))
        {
            boolean use = Input.acceptYesNo("Use special weapon?");
            if (use)
                fOCManager.useAdventurerWeapon(index);
            return use;
        }
        return false;
    }

    /**
    * Method that adds a member to the fellowship based on user input
    * @return   Whether the user has correctly chosen a member to add to
    *           their fellowship team
    */
    private boolean chooseMember()
    {
        int choice = 0;
        try
        {
            System.out.println("\nChoose member #" + 
                fOCManager.getFellowshipSize());
            System.out.println("1 - Elf");
            System.out.println("2 - Dwarf");
            choice = Input.acceptIntegerInput("Choice:");
            switch (choice)
            {
                case 1:
                    fOCManager.addElf();
                    return true;
                case 2:
                    fOCManager.addDwarf();
                    return true;
                default:
                    System.out.println("Error: Input 1 for Elf, or 2 for" + 
                        "Dwarf.");
            }
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Error: Input must be in numerical format.");
        }
        return false;
    }

    /**
    * Method to ask for user input in choosing their fighting character
    * @return   Index of Adventurer chosen by the user in the fellowship 
    */
    private int chooseYourFighter()
    {
        Message.printBlankLine();
        System.out.println("Choose your fighter:");
        fOCManager.displayFighterChoice();
        int choice = 0;
        int index = 0;
        boolean flag = true;
        do
        {
            try
            {
                choice = Input.acceptIntegerInput("Choice: ");
                int maximum = fOCManager.getFellowshipSize();
                if (Validation.isWithinRange(choice, 1, maximum))
                {
                    index = choice - 1;
                    System.out.println("You chose " + 
                        fOCManager.getAdventurerName(index));
                    flag = false;
                }
                else
                {
                    System.out.println("Error: Choose available option.");
                }
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Error: Input must be a number.");
            }
        }
        while (flag);
        Message.printBlankLine();
        return index;
    }

    /**
    * Method responsible for creating the fellowship team
    */
    private void createTeam()
    {
        fOCManager.addHobbit();
        boolean fellowshipFlag = true;
        do
        {
            boolean memberFlag = false;
            do
            {
                memberFlag = chooseMember();
            }
            while (!memberFlag);
            if (fOCManager.getFellowshipSize() == 4)
            {
                fellowshipFlag = false;
            }
            else
            {
                boolean addAnotherMember = false;
                addAnotherMember = Input.acceptYesNo("Add another character?");
                if (!addAnotherMember)
                    fellowshipFlag = false;
            }
        }
        while (fellowshipFlag);
    }

    /**
    * Method to display the state of the FellowshipOfCode class
    */
    public void display()
    {
        fOCManager.display();
    }

    /**
    * Method that displays information at the end of each cave
    * @param nextCaveID     The ID of the next cave as an integer
    */
    private void displayEndOfCaveStatistics(int nextCaveID)
    {
        Message.printBlankLine();
        System.out.println("+= END OF CAVE STATISTICS =+");
        Message.printBlankLine();
        System.out.println("VISITED CAVES: ");
        fOCManager.displayCavesVisitedInfo();
        Message.printBlankLine();
        System.out.println("DAMAGE POINTS: ");
        System.out.println("~Fellowship");
        fOCManager.displayFellowshipDamage();
        System.out.println("~Monsters");
        fOCManager.displayAllMonsterDamage();
        message.displaySecretCodeHolderMessage();
        System.out.println("The next cave is: Cave " + nextCaveID);
        Message.printBlankLine();
    }

    /**
    * Method that presents the end of game summary
    * @return The end of game summary as a String
    */
    private String getEndOfGameSummary()
    {
        Message.printBlankLine();
        System.out.println("#+= END OF GAME SUMMARY =+#");
        StringBuffer summary = new StringBuffer();
        String codeHolder = fOCManager.findSecretCodeHolder();
        if (!Validation.isBlank(codeHolder))
        {
            if (fOCManager.isSecretCodeStolen() || 
                !fOCManager.checkIfFellowshipAlive())
            {
                summary.append("The quest failed.\n");
                summary.append("The " + codeHolder + " has the secret" +
                    " code.\n");
            }
            else
            {
                summary.append("The quest was successful!\n");
                summary.append(codeHolder + " delivered the secret code.\n");
            }
        }
        summary.append(fOCManager.generateLabyrinthLog() + "\n");
        summary.append("Creatures dead (" +
            fOCManager.getGraveyardSize() + "):\n");
        summary.append(fOCManager.getFormattedGraveyardDisplay());
        System.out.println(summary.toString());
        return summary.toString();
    }

    /**
    * Method that displays fellowship character stats at the start of the game
    */
    private void displayFellowship()
    {
        Message.printBlankLine();
        System.out.println("= Your Fellowship Team =");
        fOCManager.displayFellowshipStats();
        Message.printBlankLine();
    }

    /**
    * Accessor method for the state manager
    * @return   The state manager object
    */
    public FOCManager getFOCManager()
    {
        return fOCManager;
    }

    /**
    * Accessor method for the labyrinth builder
    * @return   The labyrinth builder object
    */
    public LabyrinthBuilder getLabyrinthBuilder()
    {
        return labyrinthBuilder;
    }

    /**
    * Accessor method for the message object
    * @return   The message object
    */
    public Message getMessage()
    {
        return message;
    }

    /**
    * Main Method
    */
    public static void main(String[] args)
    {
        FellowshipOfCode game = new FellowshipOfCode();
        game.start();
    }

    /**
    * Method that starts the gameplay
    * @return Whether the game is still running
    */
    private boolean playGame()
    {
        int caveID = 1;
        while (caveID != MOUNT_API)
        {
            message.displayCaveEntry(caveID);
            if (fOCManager.isCaveSafe(caveID))
            {
                playSafeEvent();
                fOCManager.updateLabyrinthLog(caveID);
            }
            else
                playUnsafeEvent(caveID);

            if (!fOCManager.checkIfFellowshipAlive())
            {
                message.displayAllDiedMessage();
                return false;
            }
            Message.printBlankLine();
            caveID = fOCManager.chooseNextCave(caveID);
            Message.printBlankLine();
            Input.promptEnterKey("continue");
            displayEndOfCaveStatistics(caveID);
            Input.promptEnterKey("continue to the next cave");
        }
        boolean isStolen = fOCManager.isSecretCodeStolen();
        message.displayGameOutcomeMessage(isStolen);
        return false;
    }

    /**
    * Method to perform the events in a cave where there's no hostile creature
    */
    private void playSafeEvent()
    {
        fOCManager.recoverFellowshipHealth();
        System.out.println("Recovering...");
        System.out.println("-1 damage pt for each adventurer.");
    }

    /**
    * Method to perform the events in a cave where there IS a hostile creature
    * @param int Identity of cave where the events are taking place
    */
    private void playUnsafeEvent(int cave)
    {
        int index = chooseYourFighter();
        boolean useWeapon = askToUseWeapon(index);
        fOCManager.executeFightEvent(cave, index, useWeapon);
    }

    /**
    * Method parses input file data into the program
    */
    private void readFile()
    {
        FileIO reader = new FileIO(INPUT_TEXT_FILENAME);
        String[] inputLines = reader.readFile().split("\n");
        fOCManager.setLabyrinth(labyrinthBuilder.build(inputLines));
    }

    /**
    * Mutator method for the FOCManager
    * @param newFOCManager  The new FOCManager object
    */
    public void setFOCManager(FOCManager newFOCManager)
    {
        if (newFOCManager != null)
            this.fOCManager =  newFOCManager;
    }

    /**
    * Mutator method for the labyrinth builder
    * @param newLabyrinthBuilder  The new labyrinth builder
    */
    public void setLabyrinthBuilder(LabyrinthBuilder newLabyrinthBuilder)
    {
        if (newLabyrinthBuilder != null)
            this.labyrinthBuilder =  newLabyrinthBuilder;
    }

    /**
    * Mutator method for the message object
    * @param newMessage  The new message object
    */
    public void setMessage(Message newMessage)
    {
        if (newMessage != null)
            this.message =  newMessage;
    }

    /**
    * Method responsible for setting up the game before gameplay begins
    */
    private void setupGame()
    {
        readFile();
        int numberOfCaves = fOCManager.getLabyrinthSize();
        message.displayGameLoadingMessage(numberOfCaves);
        message.displayTeamSetupInstructions();
        createTeam();
        displayFellowship();
        message.displaySecretCodeHolderMessage();
    }

    /**
    * Method that starts the game
    */
    public void start()
    {
        message.displayWelcomeMessage();
        int choice = 0;
        boolean flag = true;
        do
        {
            try
            {
                choice = Input.acceptIntegerInput("Please select an option: ");
                switch (choice)
                {
                    case 1:
                        setupGame();
                        Input.promptEnterKey("play");
                        flag = playGame();
                        writeFile(getEndOfGameSummary());
                        break;
                    case 2:
                        flag = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Select an available option.");
                }
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Input must be in numerical format.");
            }
            catch (NullPointerException npe)
            {
                System.out.println("There was a NullPointerException: " + npe);
            }
            catch (Exception e)
            {
                System.out.println("An error occurred: " + e);
            }
            Message.printBlankLine();
        }
        while (flag);
    }

    /**
    * Method writes game summary into a text file
    * @param textToAdd  The text to be written to a file
    */
    private void writeFile(String textToAdd)
    {
        FileIO fileIO = new FileIO(OUTPUT_TEXT_FILENAME);
        fileIO.writeFile(textToAdd);
    }
}

