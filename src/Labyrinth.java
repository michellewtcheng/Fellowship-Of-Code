/**
* This class is represents a labyrinth of caves
* @version 1
* @author Michelle Cheng
*/
import java.util.HashMap;
public class Labyrinth
{
    private HashMap<Integer, Cave> labyrinth;

    /**
    * Default constructor for the Labyrinth class
    */
    public Labyrinth()
    {
        this.labyrinth = new HashMap<Integer, Cave>();
    }

    /**
    * Non-default constructor for the Labyrinth class
    * @param labyrinth  The labyrinth
    */
    public Labyrinth(HashMap<Integer, Cave> labyrinth)
    {
        this.labyrinth = labyrinth;
    }

    /**
    * Method to add a cave to the HashMap of the labyrinth's caves
    *
    * @param currentCave    The cave to be added to the labyrinth's caves
    */
    public void addCave(int caveID, int[] otherCaves, boolean hasMonster)
    {
        Cave cave = new Cave(caveID, otherCaves, hasMonster);
        labyrinth.put(caveID, cave);
    }

    /**
    * Method to check if the monster has died in the cave
    * @param caveID     The cave the adventurer's have just explored
    * @return           Whether the monster in that cave has died
    */
    public boolean checkForDead(int caveID)
    {
        Cave currentCave = labyrinth.get(caveID);
        if (currentCave.getHasMonster())
        {
            if (!currentCave.getIsMonsterAlive())
            {
                currentCave.updateHasMonster();
                return true;
            }
        }
        return false;
    }

    /**
    * Method asking user to choose the next cave to enter
    * @param currentID  The identity of the current cave
    * @return           The identity of the next chosen cave
    */
    public int chooseNextCave(int currentID)
    {
        int nextCave = 0;
        boolean flag = true;
        do
        {
            try
            {
                Cave currentCave = labyrinth.get(currentID);
                System.out.println("Which way next?");
                currentCave.displayCaveChoices();
                String message = "Choose a direction (letter): ";
                char nextDirection = Input.acceptCharInput(message, 0);
                if ("NESW".indexOf(nextDirection) >= 0)
                {
                    switch (nextDirection)
                    {
                        case 'N':
                            nextCave = currentCave.getOtherCaves()[0];
                            break;
                        case 'E':
                            nextCave = currentCave.getOtherCaves()[1];
                            break;
                        case 'S':
                            nextCave = currentCave.getOtherCaves()[2];
                            break;
                        case 'W':
                            nextCave = currentCave.getOtherCaves()[3];
                            break;
                    }
                    if (nextCave != Cave.BLOCKED_CAVE)
                    {
                        flag = false;
                    }
                    else
                    {
                        System.out.println("Error: Choose available option.");
                    }
                }
                else
                {
                    System.out.println("Error: Input a listed letter.");
                }
            }
            catch (StringIndexOutOfBoundsException sioobe)
            {
                System.out.println("Error: Input cannot be blank.");
            }
            catch (Exception e)
            {
                System.out.println("Error: Input a single listed letter.");
            }
        }
        while (flag);
        System.out.println("You've chosen to enter Cave " + nextCave);
        return nextCave;
    }

    /**
    * Method to retrieve a dead monster
    * @param caveID     The cave the adventurer's have just explored
    * @return           The monster that has died
    */
    public Monster collectTheDead(int caveID)
    {
        Cave currentCave = labyrinth.get(caveID);
        return currentCave.getMonster();
    }

    /**
    * Display method to show state of Labyrinth object
    */
    public void display()
    {
        for(Cave c: labyrinth.values())
        {
            c.display();
        }
    }

    /**
    * Method that displays damage of each monster in all caves
    */
    public void displayAllMonsterDamage()
    {
        for (Cave c : labyrinth.values())
        {
            if (c.getMonster() != null)
            {
                String current = c.getMonsterStatus() + "\t[" + 
                    c.getCaveName() + "]";
                System.out.println(current);
            }
        }
    }

    /**
    * Method to find which monster in which cave has the secret code
    * @return   Monster with the secret code
    */
    public String findSecretCodeHolder()
    {
        String result = "";
        for (Cave c: labyrinth.values())
        {
            if (c.getHasMonster())
            {
                if (c.getMonster().getHasSecretCode())
                {
                    result = c.getMonster().getCharacterType() + " in " +
                        c.getCaveName();
                    return result;
                }   
            }
        }
        return result;
    }

    /**
    * Accessor method to get a specific cave in the labyrinth
    * @param caveID The identity of the specific cave
    * @return       The cave
    */
    public Cave getCave(int caveID)
    {
        return labyrinth.get(caveID);
    }

    /**
    * Accessor method to get the labyrinth
    * @return   The labyrinth
    */
    public HashMap<Integer, Cave> getLabyrinth()
    {
        return labyrinth;
    }

    /**
    * Method to get the size of the labyrinth
    * @return   The number of caves in the labyrinth
    */
    public int getSize()
    {
        return labyrinth.size();
    }

    /**
    * Method to check if the cave has a monster or not
    * @param caveID The identity of the cave being checked
    * @return       Whether the cave is confirmed to be safe.
    */
    public boolean isCaveSafe(int caveID)
    {
        Cave cave = labyrinth.get(caveID);
        if (cave.getHasMonster())
        {
            String msg = cave.getMonster().getCharacterType() +
                " is in this cave!";
            System.out.println(msg);
            return false;
        }
        else
        {
            System.out.println("It's safe! There are no enemies in this " +
                "cave.");
            return true;
        }
    }

    /**
    * Mutator method that sets the labyrinth
    * @param newLabyrinth     The new labyrinth
    */
    public void setLabyrinth(HashMap<Integer, Cave> newLabyrinth)
    {
        if (newLabyrinth != null)
            this.labyrinth = newLabyrinth;
    }
}
