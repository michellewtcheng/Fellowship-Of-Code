/**
* This class is representative of a fight event
* @version 1
* @author Michelle Cheng
*/
public class Fight
{
    private GameCharacter adventurer;
    private GameCharacter monster;
    private boolean weaponUsed;

    /**
    * Default constructor for the Fight class
    */
    public Fight()
    {
        adventurer = new GameCharacter();
        monster = new GameCharacter();
        weaponUsed = false;
    }

    /**
    * Non-default constructor for the Fight class
    * @param adventurer The adventurer fighting
    * @param monster    The monster fighting
    * @param used       Whether a special weapon is being used in this fight
    */
    public Fight(GameCharacter adventurer, GameCharacter monster, boolean used)
    {
        this.adventurer = adventurer;
        this.monster = monster;
        this.weaponUsed = used;
    }

    /**
    * Method to calculate the outcome of a fight
    * @param powerDiff      The power difference between 2 fighting characters
    * @param randomNumber   A randomly generated decimal number
    * @return               Whether the outcome of the fight is in the
    *                       adventurer's favour
    */
    private boolean calculateFightOutcome(int powerDiff, double randomNumber)
    {
        if (powerDiff > 0)
        {
            switch (powerDiff)
            {
                case 1:
                    if (randomNumber < 0.6)
                        return true;
                    else
                        return false;
                case 2:
                    if (randomNumber < 0.7)
                        return true;
                    else
                        return false;
                case 3:
                    if (randomNumber < 0.8)
                        return true;
                    else
                        return false;
                default:
                    if (randomNumber < 0.9)
                        return true;
                    else
                        return false;
            }                    
        }
        else //powerDifference is negative, aka monster has more power
        {
            switch (powerDiff)
            {
                case -1:
                    if (randomNumber > 0.6)
                        return true;
                    else
                        return false;
                case -2:
                    if (randomNumber > 0.7)
                        return true;
                    else
                        return false;
                case -3:
                    if (randomNumber > 0.8)
                        return true;
                    else
                        return false;
                default:
                    if (randomNumber > 0.9)
                        return true;
                    else
                        return false;
            }
        }
    }

    /**
    * Method to display the state of the Fight class
    */
    public void display()
    {
        adventurer.display();
        monster.display();
        System.out.println("weaponUsed: " + weaponUsed);
    }

    /**
    * Method to execute the fight event between an adventurer and a monster
    * @return           The outcome of the fight: first whether the fellowship
    *                   won, second whether the code transferred hands
    */
    public int[] executeFightEvent()
    {
        boolean adventurerWin = fight();
        GameCharacter winner = new GameCharacter();
        GameCharacter loser = new GameCharacter();
        int[] outcome = new int[2];
        if (adventurerWin)
        {
            winner = adventurer;
            loser = monster;
            outcome[0] = 1;
            System.out.println("The fellowship WON the fight!");
        }
        else
        {
            winner = monster;
            loser = adventurer;
            System.out.println("The fellowship LOST the fight.");
        }
        if (!weaponUsed)
        {
            winner.incrementDamage(1);
            loser.incrementDamage(4);
        }
        int transferOutcome = transferCode(winner, loser);
        if (transferOutcome > 0)
        {
            outcome[1] = transferOutcome;
        }
        return outcome;
    }

    /**
    * Method that executes fight events in the cave
    * @return   Outcome of the fight indicating if the ADVENTURER won
    */
    private boolean fight() 
    {
        if (weaponUsed && (monster != null))
        {
            this.monster.setDamage(10);
            return true;
        }
        else
        {
            int monsterPower = monster.getPowerRating();
            int adventurerPower = adventurer.getPowerRating();
            int powerDiff = adventurerPower - monsterPower;
            double randNumber = Math.random();
            return calculateFightOutcome(powerDiff, randNumber);
        }
    }

    /**
    * Accessor method to get the adventurer
    * @return The adventurer
    */
    public GameCharacter getAdventurer()
    {
        return adventurer;
    }

    /**
    * Accessor method to get the monster
    * @return The monster
    */
    public GameCharacter getMonster()
    {
        return monster;
    }

    /**
    * Accessor method to get whether a weapon is being used in this fight
    * @return If the weapon was used
    */
    public boolean getWeaponUsed()
    {
        return weaponUsed;
    }

    /**
    * Mutator method to set the adventurer
    * @param newAdventurer The adventurer
    */
    public void setAdventurer(GameCharacter newAdventurer)
    {
        if (newAdventurer != null)
            this.adventurer = newAdventurer;
    }

    /**
    * Mutator method to set the monster
    * @param newMonster    The monster
    */
    public void setMonster(GameCharacter newMonster)
    {
        if (newMonster != null)
            this.monster = newMonster;
    }

    /**
    * Mutator method to set if a weapon is being used in this fight
    * @param weaponUsed If a weapon was being used
    */
    public void setWeaponUsed(boolean weaponUsed)
    {
        this.weaponUsed = weaponUsed;
    }

    /**
    * Method to transfer code between characters where necessary
    * @param winner The game character that won the fight
    * @param loser  The game character that lost the fight
    * @return       An int where value > 0 means code has changed hands
    */
    private int transferCode(GameCharacter winner, GameCharacter loser)
    {
        if (winner.equals(adventurer))
        {
            if (!winner.getHasSecretCode() && loser.getHasSecretCode())
            {
                loser.setHasSecretCode(false);
                System.out.println("Well done, you got the code back!");
                return 2;
            }
            else if (!winner.getIsAlive())
            {
                winner.setHasSecretCode(false);
                return 2;
            }
        }
        else
        {
            if (loser.getHasSecretCode())
            {
                if (!winner.getIsAlive())
                {
                    System.out.println("That was close! The fellowship" + 
                        " are JUST able to hold onto the code.");
                    if (!loser.getIsAlive())
                    {
                        loser.setHasSecretCode(false);
                        System.out.println("Thank you for your sacrifice " +
                            loser.getCharacterType() + " RIP :(");
                        return 2;
                    }
                    return 0;
                }
                else
                {
                    loser.setHasSecretCode(false);
                    winner.setHasSecretCode(true);
                    System.out.println(winner.getCharacterType() +
                        " has stolen the code.");
                    return 1;
                }
            }
            else
            {
                if (!winner.getIsAlive())
                { 
                    // monster with code dies from +1 damage
                    winner.setHasSecretCode(false);
                    if (!loser.getIsAlive())
                    {
                        System.out.println("You got the code back! " +
                            "RIP " + loser.getCharacterType() + ":(");
                        return 2;
                    }
                    System.out.println("Hallelujah, you got the code back!");
                    return 2;
                }
            }
        }
        return 0;
    }
}
