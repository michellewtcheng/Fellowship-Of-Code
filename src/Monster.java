/**
* This class represents monster characters in the game
* @version 1
* @author Michelle Cheng
*/
public class Monster extends GameCharacter
{
    /**
    * Default constructor for the Monster class
    */
    public Monster()
    {
        super();
    }

    /**
    * Non-default constructor for the Monster class
    * @param type           The type of monster as a String
    * @param powerRating    The power rating for the monster as an int
    */
    public Monster(String type, int powerRating)
    {
        super(type, powerRating);
    }
}
