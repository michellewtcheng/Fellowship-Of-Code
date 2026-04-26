/**
* This class is represents a cave within the labyrinth
* @version 1
* @author Michelle Cheng
*/
public class Cave
{
    public static final int BLOCKED_CAVE = 0;
    private int identity;
    private int[] otherCaves;
    private boolean hasMonster;
    private Monster monster;

    /**
    * Default constructor for Cave class
    */
    public Cave()
    {
        identity = 0;
        otherCaves = new int[4];
        hasMonster = false;
        monster = null;
    }

    /**
    * Non-default constructor for Cave class
    * @param identity   The identity of the cave
    * @param otherCaves The other caves accessible from this cave
    * @param hasMonster Whether this cave object has a monster
    */
    public Cave(int identity, int[] otherCaves, boolean hasMonster)
    {
        setIdentity(identity);
        setOtherCaves(otherCaves);
        this.hasMonster = hasMonster;
        this.monster = generateMonster();
    }

    /**
    * Display method to show the state of the cave object
    */
    public void display()
    {
        System.out.println("identity: " + identity);
        System.out.println("Other Caves: " + otherCaves[0] + " " +
            otherCaves[1] + " " + otherCaves[2] + " " + otherCaves[3]);
        System.out.println("hasMonster: " + hasMonster);
        System.out.println("monster: ");
        if (monster != null)
            monster.display();
        else
            System.out.println("N/A");
    }

    /**
    * Method that displays choice of other caves as a menu
    */ 
    public void displayCaveChoices()
    {      
        for (int i = 0; i < 4; i++)
        {
            if (otherCaves[i] != BLOCKED_CAVE)
            {
                String direction = "";
                char directionChar = ' ';
                switch (i)
                {
                    case 0:
                        direction = "North";
                        directionChar = 'N';
                        break;
                    case 1:
                        direction = "East";
                        directionChar = 'E';
                        break;
                    case 2:
                        direction = "South";
                        directionChar = 'S';
                        break;
                    case 3:
                        direction = "West";
                        directionChar = 'W';
                        break;
                }
                System.out.println(" " + directionChar + " - " + direction +
                    " (Cave " + otherCaves[i] + ")");
            }
        }
    }

    /**
    * Method generates the type of monster in the cave
    * @return The monster in the cave
    */
    private Monster generateMonster()
    {
        if (hasMonster)
        {
            int number = (int)(Math.random() * 3 + 1);
            switch (number)
            {
                case 1:
                    return new Monster("Orc", 5);
                case 2:
                    return new Monster("Troll", 9);
                case 3:
                    return new Monster("Goblin", 3);
            }
            return new Monster();
        }
        return null;
    }

    /**
    * Method that produces a formatted name for the cave
    * @return   A nicely formatted String with the cave's identity
    */
    public String getCaveName()
    {
        return "Cave " + identity;
    }

    /**
    * Accessor method for whether the cave has a monster
    * @return Whether this cave has a monster as a boolean
    */
    public boolean getHasMonster()
    {
        return hasMonster;
    }

    /**
    * Accessor method for this cave's identity
    * @return This cave's identity as an integer.
    */
    public int getIdentity()
    {
        return identity;
    } 

    /**
    * Intermediary accessor method for whether monster is alive
    * @return Whether this monster is alive as a boolean
    */
    public boolean getIsMonsterAlive()
    {
        if (monster != null)
            return monster.getIsAlive();
        else
            return false;
    }

    /**
    * Accessor method for monster in this cave if there is one
    * @return The monster that's in this cave
    */
    public Monster getMonster()
    {
        if (monster != null)
            return monster;
        else
            return null;
    }

    /**
    * Intermediary method that presents a basic name for the monster
    * @return Formatted string representing the monster in this cave
    */
    public String getMonsterBasic()
    {
        if (monster != null)
            return monster.getCharacterBasic();
        return "";
    }

    /**
    * Intermediary method that presents the monster's status
    * @return Formatted string representing the monster's status
    */
    public String getMonsterStatus()
    {
        if (monster != null)
            return monster.getCharacterStatus();
        return "";
    }

    /**
    * Accessor method for the other caves accessible from this cave
    * @return The other caves in North, East, South, West order.
    */
    public int[] getOtherCaves()
    {
        return otherCaves;
    }


    /**
    * Mutator method for hasMonster variable
    * @param hasMonster Whether the cave has a monster as a boolean
    */
    public void setHasMonster(boolean hasMonster)
    {
        this.hasMonster = hasMonster;
        this.monster = generateMonster();
    }

    /**
    * Mutator method for this cave's identity
    * @param newIdentity    This cave's identity as an integer.
    */
    public void setIdentity(int newIdentity)
    {
        if (Validation.isWithinRange(newIdentity, 1, 100))
            this.identity = newIdentity;
        else
            this.identity = 0;
    }

    /**
    * Mutator method for setting this cave's monster
    * @param newMonster The monster in the cave
    */
    public void setMonster(Monster newMonster)
    {
        if (newMonster != null)
            this.monster = newMonster;
    }

    /**
    * Mutator method for the other caves accessible from this cave
    * @param newOtherCaves  The identities of the other caves as an int array.
    */
    public void setOtherCaves(int[] newOtherCaves)
    {
        if (newOtherCaves.length == 4)
            this.otherCaves = newOtherCaves;
        else
            this.otherCaves = new int[4];
    }

    /**
    * Method to update whether the monster in this cave is still alive
    */
    public void updateHasMonster()
    {
        if ((monster != null) && !getIsMonsterAlive())
        {
            hasMonster = false;
        }
    }
}
