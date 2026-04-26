/**
* This class is represents a graveyard of dead game characters
* @version 1
* @author Michelle Cheng
*/
import java.util.ArrayList;
public class Graveyard
{
    private ArrayList<GameCharacter> graveyard;

    /**
    * Default constructor for Graveyard class
    */
    public Graveyard()
    {
        this.graveyard = new ArrayList<GameCharacter>();
    }

    /**
    * Non-default constructor for Graveyard class
    * @param graveyard  The graveyard
    */
    public Graveyard(ArrayList<GameCharacter> graveyard)
    {
        this.graveyard = graveyard;
    }

    /**
    * Method to add a game character that has died to the graveyard
    * @param deceased   The deceased game character to be buried
    */
    public void addDeceased(GameCharacter deceased)
    {
        graveyard.add(deceased);
    }

    /**
    * Display method to show the state of a Graveyard object
    */  
    public void display()
    {
        for (GameCharacter g: graveyard)
        {
            g.display();
        }
    }

    /**
    * Accessor method to get the graveyard
    * @return   The graveyard
    */
    public ArrayList<GameCharacter> getGraveyard()
    {
        return graveyard;
    }

    /**
    * Method to present the graveyard and its occupants
    * @return   A formatted String showing a list of dead characters
    */
    public String getFormattedDisplay()
    {
        String result = "";
        for (GameCharacter gc : graveyard)
        {
            if (gc != null)
                result += "- " + gc.getCharacterType() + "\n";
        }
        return result;
    }

    /**
    * Accessor method to get the graveyard's size
    * @return   The number of character's in the graveyard
    */
    public int getSize()
    {
        return graveyard.size();
    }

    /**
    * Mutator method that sets the graveyard
    * @param newGraveyard     The new graveyard
    */
    public void setGraveyard(ArrayList<GameCharacter> newGraveyard)
    {
        if (newGraveyard != null)
            this.graveyard = newGraveyard;
    }
}
