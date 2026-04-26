/**
* This class is represents a Fellowship adventurer character in the game
* @version 1
* @author Michelle Cheng
*/
public class Adventurer extends GameCharacter
{
    private boolean hasSpecialWeapon;

    /**
    * Default constructor for the Character class
    */
    public Adventurer()
    {
        super();
        hasSpecialWeapon = false;
    }

    /**
    * Non-default constructor for the Character class
    * @param specialWeapon  Whether the adventurer character possesses a
    *                       special weapon
    * @param powerRating    A number that determines a character's chance at
    *                       winning in a fight.
    * @param type           The type of creature the adventurer is
    */
    public Adventurer(boolean specialWeapon, int powerRating, String type)
    {
        super(type, powerRating);
        this.hasSpecialWeapon = specialWeapon;
    }

    /**
    * Non-default constructor for the Character class
    * @param specialWeapon  Whether the adventurer character possesses a
    *                       special weapon
    * @param power          A number that determines a character's chance at
    *                       winning in a fight.
    * @param secretCode     Whether the adventurer possesses the secret code
    */
    public Adventurer(boolean specialWeapon, int power, boolean secretCode)
    {
        super("Hobbit", power, secretCode);
        this.hasSpecialWeapon = specialWeapon;
    }

    /**
    * Method to append an indicator that an adventurer has a weapon
    * @return   An indicator for whether an adventurer is carrying a weapon
    */
    private String appendWeaponMarker()
    {
        if (hasSpecialWeapon)
        {
            return " (weapon)";
        }
        return "";
    }

    /**
    * Display method to show state of object
    */
    @Override
    public void display()
    {
        super.display();
        System.out.println("Weapon: " + hasSpecialWeapon);
    }

    /**
    * Display method to show an adventurer's damage 
    * @return   A String containing an adventurer's damage 
    */
    @Override 
    public String getCharacterDamage()
    {
        return super.getCharacterDamage() + 
            appendWeaponMarker();
    }

    /**
    * Display method to show formatted adventurer statistics
    * @return   A String containing the adventurer's statistics
    */
    @Override
    public String getCharacterStatistics()
    {
        return super.getCharacterStatistics() + 
            appendWeaponMarker(); 
    }

    /**
    * Accessor method to see if the character has a special weapon available
    * @return   If the character has a special weapon as a boolean
    */    
    public boolean getHasSpecialWeapon()
    {
        return hasSpecialWeapon;
    }

    /**
    * Mutator method that sets whether the adventurer has a special weapon
    * @param newHasSpecialWeapon    Whether the adventurer has a weapon
    */
    public void setSpecialWeapon(boolean newHasSpecialWeapon)
    {
        this.hasSpecialWeapon = newHasSpecialWeapon;
    }
    
    /**
    * Method to use an adventurer's special weapon
    */    
    public void useSpecialWeapon()
    {
        this.hasSpecialWeapon = false;
    }
}
