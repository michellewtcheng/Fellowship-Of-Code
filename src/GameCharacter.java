/**
* This class is represents a character in the game
* @version 1
* @author Michelle Cheng
*/
public class GameCharacter
{
    private String characterType;
    private int damage;
    private int powerRating;
    private boolean hasSecretCode;
    private boolean isAlive;

    /**
    * Default constructor for the GameCharacter class
    */
    public GameCharacter()
    {
        characterType = "Unknown";
        damage = 0;
        powerRating = 0;
        hasSecretCode = false;
        isAlive = true;
    }

    /**
    * Non-default constructor for the Character class
    * @param type           The name of the character
    * @param powerRating    A number that determines a character's chance at
    *                       winning in a fight.
    */
    public GameCharacter(String type, int powerRating)
    {
        characterType = type;
        damage = 0;
        this.powerRating = powerRating;
        hasSecretCode = false;
        this.isAlive = true;
    }

    /**
    * Non-default constructor for the Character class
    * @param type           The name of the character
    * @param powerRating    A number that determines a character's chance at
    *                       winning in a fight.
    * @param hasSecretCode  Whether the character possesses the secret code
    */
    public GameCharacter(String type, int powerRating, boolean hasSecretCode)
    {
        characterType = type;
        damage = 0;
        this.powerRating = powerRating;
        this.hasSecretCode = hasSecretCode;
        this.isAlive = true;
    }

    /**
    * Method to append an indicator that a game character has the secret code
    * @return   An indicator for whether a game character has the secret code
    */
    private String appendSecretCodeMarker()
    {
        if (hasSecretCode)
        {
            return "#";
        }
        return "";
    }

    /**
    * Method to check if character's alive status needs to be updated
    */
    private void checkIfAlive()
    {
        if (getDamage() >= 10)
        {
            setIsAlive(false);
            System.out.println(characterType + " has died.");
        }
    }

    /**
    * Method to decrement damage 
    */
    public void decrementDamage()
    {
        damage--;
    }

    /**
    * Method to display the state of the object
    */
    public void display()
    {
        System.out.println("characterType: " + characterType);
        System.out.println("damage: " + damage);
        System.out.println("powerRating: " + powerRating);
        System.out.println("hasSecretCode: " + hasSecretCode);
        System.out.println("isAlive: " + isAlive);
    }

    /**
    * Method to show basic representation of game character
    * @return   A formatted string representing the game character
    */    
    public String getCharacterBasic()
    {
        return characterType + appendSecretCodeMarker();
    }

    /**
    * Method to show game character's damage 
    * @return   A String containing the game character's damage 
    */    
    public String getCharacterDamage()
    {
        return characterType + appendSecretCodeMarker() + "\tDamage: " + 
            damage;
    }

    /**
    * Method to show formatted game character statistics
    * @return   A String containing the game character's statistics
    */    
    public String getCharacterStatistics()
    {
        return characterType + appendSecretCodeMarker() + "\tDamage: " + 
            damage + ", Power Rating: " + powerRating;
    }

    /**
    * Method to show formatted game character dead/living status
    * @return   A String containing the game character's status
    */    
    public String getCharacterStatus()
    {
        String status = characterType + appendSecretCodeMarker() + "\t";
        if (isAlive)
            status += "Damage: " + damage;
        else
            status += "(dead)";
        return status;
    }

    /**
    * Accessor method to get the game character's (name) type
    * @return   A String with the character's (name) type
    */    
    public String getCharacterType()
    {
        return characterType;
    }

    /**
    * Accessor method to get the character's damage points
    * @return   The damage points as an integer
    */    
    public int getDamage()
    {
        return damage;
    }

    /**
    * Accessor method to get whether the character has the secret code
    * @return   Whether the character has the secret code as a boolean
    */    
    public boolean getHasSecretCode()
    {
        return hasSecretCode;
    }

    /**
    * Accessor method to get whether the character is still alive
    * @return   Whether the character is alive as a boolean
    */    
    public boolean getIsAlive()
    {
        return isAlive;
    }

    /**
    * Accessor method to get the character's power rating
    * @return   The power rating as an integer
    */    
    public int getPowerRating()
    {
        return powerRating;
    }

    /**
    * Method to increment damage 
    * @param amount The amount to increment damage by as an int
    */
    public void incrementDamage(int amount)
    {
        damage += amount;
        checkIfAlive();
    }

    /**
    * Mutator method to set the character's type
    * @param newCharacterType  Character type as a String
    */    
    public void setCharacterType(String newCharacterType)
    {
        if (newCharacterType != null)
            this.characterType = newCharacterType;
    }

    /**
    * Mutator method to set the character's damage points
    * @param newDamage  Damage points as an integer
    */    
    public void setDamage(int newDamage)
    {
        if (newDamage >= 0)
        {
            this.damage = newDamage;
        }
        checkIfAlive();
    }

    /**
    * Mutator method to set whether the character has the secret code
    * @param secretCode  Whether the character has the secret code as a boolean
    */    
    public void setHasSecretCode(boolean secretCode)
    {
        this.hasSecretCode = secretCode;   
    }

    /**
    * Mutator method to set whether the character is alive
    * @param isAlive  Whether the character is alive as a boolean
    */    
    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }

    /**
    * Mutator method to set the character's power rating
    * @param newPowerRating  Power rating as an integer
    */   
    public void setPowerRating(int newPowerRating)
    {
        if (newPowerRating > 0)
        {
            this.powerRating = newPowerRating;
        }
    }
}
