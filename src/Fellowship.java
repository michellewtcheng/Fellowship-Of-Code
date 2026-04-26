/**
* This class is represents a group of adventurers called the Fellowship
* @version 1
* @author Michelle Cheng
*/
import java.util.ArrayList;
public class Fellowship
{
    private ArrayList<Adventurer> fellowship;

    /**
    * Default constructor for the Fellowship class
    */
    public Fellowship()
    {
        this.fellowship = new ArrayList<Adventurer>();
    }

    /**
    * Non-default constructor for the Fellowship class
    * @param fellowship The group of adventurer's
    */
    public Fellowship(ArrayList<Adventurer> fellowship)
    {
        this.fellowship = fellowship;
    }

    /**
    * Method to add an adventurer to the fellowship 
    * @param adventurer The adventurer to be added as an Adventurer object
    */
    private void addAdventurer(Adventurer adventurer)
    {
        fellowship.add(adventurer);
    }

    /**
    * Method to add a dwarf to the fellowship 
    */
    public void addDwarf()
    {
        addAdventurer(new Adventurer(false, 7, "Dwarf"));
        System.out.println("Adding Dwarf to the fellowship.");
    }

    /**
    * Method to add an elf to the fellowship 
    */
    public void addElf()
    {
        addAdventurer(new Adventurer(true, 5, "Elf"));
        System.out.println("Adding Elf to the fellowship.");
    }

    /**
    * Method to add a hobbit to the fellowship 
    */
    public void addHobbit()
    {
        addAdventurer(new Adventurer(true, 3, true));
    }

    /**
    * Method to check if anyone in the fellowship has died
    * @return           Whether someone in the fellowship has died
    */
    public boolean checkForDead()
    {
        for (Adventurer a: fellowship)
        {
            if (!a.getIsAlive())
            {
                return true;
            }
        }
        return false;
    }

    /**
    * Method that checks if the fellowship has at least 1 living member
    * @return Whether the all the fellowship have died
    */
    public boolean checkIfAlive()
    {
        if (fellowship.size() > 0)
            return true;
        else
            return false;
    }

    /**
    * Method to find the adventurers that have died
    * @return   The adventurer that has died
    */
    public Adventurer collectTheDead()
    {
        for (int i = 0; i < fellowship.size(); i++)
        {
            Adventurer current = fellowship.get(i);
            if (!current.getIsAlive())
            {
                return fellowship.remove(i);
            }
        }
        return null;
    }

    /**
    * Display method for the state of the Fellowship object
    */
    public void display()
    {
        for (Adventurer a: fellowship)
        {
            a.display();
        }
    }

    /**
    * Method that displays each fellowship member's damage
    */
    public void displayDamage()
    {
        for (Adventurer a : fellowship)
        {
            System.out.println(a.getCharacterStatus());
        }
    }

    /**
    * Method that displays choice of adventurers they can choose for a fight
    */ 
    public void displayFighterChoice()
    {
        int optionNumber = 1;
        for (Adventurer a : fellowship)
        {
            System.out.println(" " + optionNumber + " - " + 
                a.getCharacterDamage());
            optionNumber++;
        }
    }

    /**
    * Method that displays fellowship character statistics
    */
    public void displayStats()
    {
        for (Adventurer a : fellowship)
        {
            System.out.println(a.getCharacterStatistics());
        }
    }

    /**
    * Intermediary accessor method to see if an adventurer has a weapon
    * @param index  The index of the adventurer in the fellowship
    * @return       Whether the adventurer has a special weapon
    */
    public boolean doesAdventurerHaveWeapon(int index)
    {
        return getAdventurer(index).getHasSpecialWeapon();
    }

    /**
    * Method to find which character is holding the secret code
    * @return   Adventurer with the secret code
    */
    public Adventurer findSecretCodeHolder()
    {
        if (!isSecretCodeStolen())
        {
            for (Adventurer a: fellowship)
            {
                if (a.getHasSecretCode())
                {
                    return a;
                }
            }
        }
        return null;
    }

    /**
    * Accessor method to get a specific member of the fellowship
    * @param index  The location of the specific member in the ArrayList
    * @return       The fellowship member
    */
    public Adventurer getAdventurer(int index)
    {
        return fellowship.get(index);
    }

    /**
    * Intermediary accessor method to get a fellowship member's name
    * @param index  The index of the adventurer within the Fellowship
    * @return       The adventurer's name
    */
    public String getCharacterName(int index)
    {
        return getAdventurer(index).getCharacterType();
    }

    /**
    * Accessor method to get the fellowship
    * @return   The fellowship as an ArrayList
    */
    public ArrayList<Adventurer> getFellowship()
    {
        return fellowship;
    }

    /**
    * Accessor method to get the size of the fellowship
    * @return   The number of members in the fellowship
    */
    public int getSize()
    {
        return fellowship.size();
    }

    /**
    * Method to check whether the secret code is in the fellowship's possession
    * @return   Whether the secret code has been stolen as a boolean
    */
    public boolean isSecretCodeStolen()
    {
        for (Adventurer a: fellowship)
        {
            if (a.getHasSecretCode())
                return false;
        }
        return true;
    }

    /**
    * Method to decrement all fellowship member's damage when recovering
    */
    public void recoverHealth()
    {
        for (Adventurer a: fellowship)
        {
            int damage = a.getDamage();
            if (Validation.isWithinRange(damage, 1, 10))
                a.decrementDamage();
        }
    }

    /**
    * Mutator method that sets the fellowship
    * @param newFellowship     The fellowship as an ArrayList
    */
    public void setFellowShip(ArrayList<Adventurer> newFellowship)
    {
        if (newFellowship != null)
            this.fellowship = newFellowship;
    }
    
    /**
    * Method that transfers holdership to the fighter
    * @param fighterIndex   Index of the fighter in the fellowship
    */
    public void transferCodeToFighter(int fighterIndex)
    {
        if (findSecretCodeHolder() != null)
        {
            findSecretCodeHolder().setHasSecretCode(false);
            fellowship.get(fighterIndex).setHasSecretCode(true);
        }
    }

    /**
    * Intermediary method that uses up an adventurer's weapon
    * @param index  Index of adventurer within the fellowship
    */
    public void useAdventurerWeapon(int index)
    {
        Adventurer member = getAdventurer(index);
        if (member.getHasSpecialWeapon())
            member.useSpecialWeapon();
    }
}
