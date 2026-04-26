/**
* This class is responsible for building the game's cave-filled labyrinth
* @version 1
* @author Michelle Cheng & Adapted from Rolling Project (ITO4131) 
*/
public class LabyrinthBuilder
{
    /**
    * Default constructor for LabyrinthBuilder class
    */
    public LabyrinthBuilder()
    {
    }

    /**
    * Method to create a labyrinth based on a set of information
    * @param labyrinthValues    The information about the labyrinth
    * @return                   The labyrinth
    */
    public Labyrinth build(String[] labyrinthValues)
    {
        Labyrinth labyrinth = new Labyrinth();
        for (String line: labyrinthValues)
        {
            generateCave(line, labyrinth);
        }
        return labyrinth;
    }

    /**
    * Method to add a cave to the labyrinth
    * @param line       The information for a cave as a String array
    * @param labyrinth  The labyrinth the cave is being added to
    */
    private void generateCave(String line, Labyrinth labyrinth)
    {
        try
        {
            String[] caveValues = line.split(",");
            int caveID = Integer.parseInt(caveValues[0]);
            int[] otherCaves = new int[4];
            for (int i = 1; i < caveValues.length; i++)
            {
                otherCaves[i - 1] = Integer.parseInt(caveValues[i]);
            }
            if (caveID != FellowshipOfCode.MOUNT_API)
                labyrinth.addCave(caveID, otherCaves, generateMonsterCave());
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Error: File should contain comma-" +
                "separated whole numbers only.");
        }
    }

    /**
    * Method that generates a cave type with or without a monster
    * @return   Whether the cave will have a monster
    */
    private boolean generateMonsterCave()
    {
        if (Math.random() < 0.75)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
