/**
* This class is responsible managing the entities associated with the game FOC
* @version 1
* @author Michelle Cheng
*/
public class FOCManager
{
    private Fellowship fellowship;
    private Graveyard graveyard;
    private Labyrinth labyrinth;
    private LabyrinthLog labyrinthLog;
    
    /**
    * The default constructor for FOCManager class
    */
    public FOCManager()
    {
        this.fellowship = new Fellowship();
        this.graveyard = new Graveyard();
        this.labyrinth = new Labyrinth();
        this.labyrinthLog = new LabyrinthLog();
    }

    /**
    * The non-default constructor for FOCManager class
    * @param fellowship The fellowship
    * @param labyrinth  The labyrinth
    */
    public FOCManager(Fellowship fellowship, Labyrinth labyrinth)
    {
        this.fellowship = fellowship;
        this.graveyard = new Graveyard();
        this.labyrinth = labyrinth;
        this.labyrinthLog = new LabyrinthLog();
    }

    /**
    * Method to add a dwarf to the fellowship 
    */
    public void addDwarf()
    {
        fellowship.addDwarf();
    }

    /**
    * Method to add an elf to the fellowship 
    */
    public void addElf()
    {
        fellowship.addElf();
    }

    /**
    * Method to add a hobbit to the fellowship 
    */
    public void addHobbit()
    {
        fellowship.addHobbit();
    }

    /**
    * Method that checks if the fellowship has at least 1 living member
    * @return Whether the fellowship is alive as a boolean
    */
    public boolean checkIfFellowshipAlive()
    {
        return fellowship.checkIfAlive();
    }

    /**
    * Method asking user to choose the next cave to enter
    * @param currentID  The identity of the cave the adventurers are in
    * @return           The cave ID of the chosen next cave
    */
    public int chooseNextCave(int currentID)
    {
        return labyrinth.chooseNextCave(currentID);
    }

    /**
    * Method to bury characters that have died at the end of exploring a cave
    * @param caveID     The cave the adventurer's have just explored
    */
    private void collectTheDead(int caveID)
    {
        if (fellowship.checkForDead())
        {
            try
            {
            graveyard.addDeceased(fellowship.collectTheDead());
            }
            catch (NullPointerException npe)
            {
                System.out.println("No adventurer has died");
            }
        }
        if (labyrinth.checkForDead(caveID))
            graveyard.addDeceased(labyrinth.collectTheDead(caveID));
    }

    /**
    * Display method to show state of the object
    */ 
    public void display()
    {
        fellowship.display();
        graveyard.display();
        labyrinth.display();
        labyrinthLog.display();
    }

    /**
    * Method that displays damage of each monster in all caves
    */
    public void displayAllMonsterDamage()
    {
        labyrinth.displayAllMonsterDamage();
    }

    /**
    * Method that displays each visited caves along with any monsters
    */
    public void displayCavesVisitedInfo()
    {
        for (int i : labyrinthLog.getCavesVisited())
        {
            String message = "- Cave " + i + ": ";
            if (labyrinth.getCave(i).getHasMonster())
            {
                message += labyrinth.getCave(i).getMonsterBasic();
            }
            else
            {
                message += "Empty";
            }
            System.out.println(message);
        }
    }

    /**
    * Method that displays each fellowship member's damage
    */
    public void displayFellowshipDamage()
    {
        fellowship.displayDamage();
    }
        
    /**
    * Method that displays fellowship character statistics
    */
    public void displayFellowshipStats()
    {
        fellowship.displayStats();
    }

    /**
    * Method that displays choice of adventurers they can choose to have fight
    */ 
    public void displayFighterChoice()
    {
        fellowship.displayFighterChoice();
    }

    /**
    * Intermediary method to see if an adventurer has a weapon
    * @param index  The index of the adventurer in the fellowship
    * @return       Whether the adventurer has a special weapon
    */
    public boolean doesAdventurerHaveWeapon(int index)
    {
        return fellowship.doesAdventurerHaveWeapon(index);
    }

    /**
    * Method to execute the events where the fellowship encounter a monster
    * @param cave       The cave the fight takes place
    * @param fighter    Index of adventurer in fellowship fighting the monster
    * @param useWeapon  Whether the adventurer is using a special weapon
    */
    public void executeFightEvent(int cave, int fighter, boolean weapon)
    {
        if (!fellowship.isSecretCodeStolen())
            fellowship.transferCodeToFighter(fighter);
        Fight fight = new Fight();
        fight.setAdventurer(fellowship.getAdventurer(fighter));
        fight.setMonster(labyrinth.getCave(cave).getMonster());
        fight.setWeaponUsed(weapon);
        int[] outcome = fight.executeFightEvent();
        collectTheDead(cave);
        updateLabyrinthLog(cave, outcome);
    }

    /**
    * Method to find which character is holding the secret code
    * @return   Character with the secret code
    */
    public String findSecretCodeHolder()
    {
        if (fellowship.isSecretCodeStolen())
        {
            if (!labyrinth.findSecretCodeHolder().isBlank())
                return labyrinth.findSecretCodeHolder();
        }
        else
        {
            if (fellowship.findSecretCodeHolder() != null)
                return fellowship.findSecretCodeHolder().getCharacterType();
        }
        return "";
    }

    /**
    * Method that generates formatted presentation of data logged
    * @return A String of the logged data
    */
    public String generateLabyrinthLog()
    {
        return labyrinthLog.generateLog();
    }

    /**
    * Method to get a fellowship member's name
    * @param index  The index of the adventurer within the Fellowship
    * @return       The adventurer's name
    */
    public String getAdventurerName(int index)
    {
        return fellowship.getCharacterName(index);
    }

    /**
    * Accessor method to get the fellowship
    * @return   The fellowship as an ArrayList
    */
    public Fellowship getFellowship()
    {
        return fellowship;
    }

    /**
    * Method to get the number of adventurers in the fellowship
    * @return   The fellowship size
    */
    public int getFellowshipSize()
    {
        return fellowship.getSize();
    }

    /**
    * Method to present the graveyard and its occupants
    * @return   A formatted String showing a list of dead characters
    */
    public String getFormattedGraveyardDisplay()
    {
        return graveyard.getFormattedDisplay();
    }

    /**
    * Accessor method to get the graveyard
    * @return   The graveyard
    */
    public Graveyard getGraveyard()
    {
        return graveyard;
    }

    /**
    * Method to get the number of dead characters
    * @return   The graveyard size
    */
    public int getGraveyardSize()
    {
        return graveyard.getSize();
    }

    /**
    * Accessor method to get the labyrinth
    * @return   The labyrinth
    */
    public Labyrinth getLabyrinth()
    {
        return labyrinth;
    }

    /**
    * Accessor method to get the labyrinth log
    * @return   The labyrinth log
    */
    public LabyrinthLog getLabyrinthLog()
    {
        return labyrinthLog;
    }

    /**
    * Method to get the number of caves in the labyrinth
    * @return   The labyrinth size
    */
    public int getLabyrinthSize()
    {
        return labyrinth.getSize();
    }

    /**
    * Method to check if the cave has a monster or not
    * @param caveID The identity of the cave being checked
    * @return       Whether the cave is confirmed to be safe.
    */
    public boolean isCaveSafe(int caveID)
    {
        return labyrinth.isCaveSafe(caveID);
    }

    /**
    * Method to check whether the secret code is in the fellowship's possession
    * @return   Whether the secret code has been stolen as a boolean
    */
    public boolean isSecretCodeStolen()
    {
        return fellowship.isSecretCodeStolen();
    }

    /**
    * Method to decrement all fellowship member's damage when recovering
    */
    public void recoverFellowshipHealth()
    {
        fellowship.recoverHealth();
    }

    /**
    * Mutator method that sets the fellowship
    * @param newFellowship     The fellowship
    */
    public void setFellowShip(Fellowship newFellowship)
    {
        if (newFellowship != null)
            this.fellowship = newFellowship;
    }

    /**
    * Mutator method that sets the graveyard
    * @param newGraveyard     The new graveyard
    */
    public void setGraveyard(Graveyard newGraveyard)
    {
        if (newGraveyard != null)
            this.graveyard = newGraveyard;
    }

    /**
    * Mutator method that sets the labyrinth
    * @param newLabyrinth     The new labyrinth
    */
    public void setLabyrinth(Labyrinth newLabyrinth)
    {
        if (newLabyrinth != null)
            this.labyrinth = newLabyrinth;
    }

    /**
    * Mutator method that sets the labyrinth log
    * @param newLabyrinthLog     The new labyrinthLog
    */
    public void setLabyrinthLog(LabyrinthLog newLabyrinthLog)
    {
        if (newLabyrinthLog != null)
            this.labyrinthLog = newLabyrinthLog;
    }

    /**
    * Method that updates the labyrinth log
    * @param cave       The cave the fellowship have just visited
    */
    public void updateLabyrinthLog(int cave)
    {
        labyrinthLog.updateCavesVisited(cave);
    }

    /**
    * Method that updates the labyrinth log
    * @param cave       The cave the fellowship have just visited
    * @param outcome    Indicators for a fight win and change of hand of the
    *                   code
    */
    private void updateLabyrinthLog(int cave, int[] outcome)
    {
        labyrinthLog.updateCavesVisited(cave);
        labyrinthLog.incrementNumberOfFights();
        if (outcome[0] == 1)
            labyrinthLog.incrementNumberOfFightsWon();
        if (outcome[1] == 1 || outcome[1] == 2)
        {
            labyrinthLog.incrementTimesCodeChangedHand();
            if (outcome[1] == 2)
                fellowship.getAdventurer(0).setHasSecretCode(true);
        } 
    }

    /**
    * Intermediary method that uses up an adventurer's weapon
    * @param index  Index of adventurer within the fellowship
    */
    public void useAdventurerWeapon(int index)
    {
        fellowship.useAdventurerWeapon(index);
    }
}
