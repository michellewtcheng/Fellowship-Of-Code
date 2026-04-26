/**
* This class is responsible for logging information about the labyrinth
* @version 1
* @author Michelle Cheng 
*/
import java.util.ArrayList;
public class LabyrinthLog
{
    private ArrayList<Integer> cavesVisited;
    private int numberOfFights;
    private int numberOfFightsWon;
    private int timesCodeChangedHands;

    /**
    * Default constructor for LabyrinthLog class
    */
    public LabyrinthLog()
    {
        this.cavesVisited = new ArrayList<Integer>();
        this.numberOfFights = 0;
        this.numberOfFightsWon = 0;
        this.timesCodeChangedHands = 0;
    }

    /**
    * Non-default constructor for LabyrinthLog class
    * @param cavesVisited   An ArrayList of caves the fellowship have visited
    */
    public LabyrinthLog(ArrayList<Integer> cavesVisited)
    {
        this.cavesVisited = cavesVisited;
        this.numberOfFights = 0;
        this.numberOfFightsWon = 0;
        this.timesCodeChangedHands = 0;
    }

    /**
    * Method to calculate the fellowship fight success rate
    * @return The success rate as a decimal number
    */
    private double calculateFightSuccessRate()
    {
        return (numberOfFightsWon * 100.0)/numberOfFights;
    }

    /**
    * Display method to show the state of the object
    */
    public void display()
    {
        System.out.println("numberOfFights: " + numberOfFights);
        System.out.println("numberOfFightsWon: " + numberOfFightsWon);
        System.out.println("timesCodeChangedHands: " + timesCodeChangedHands);
        System.out.println("cavesVisited: ");
        for (Integer i : cavesVisited)
        {
            System.out.print(i + " ");
        }
    }
    
    /**
    * Method that generates formatted presentation of data logged
    * @return A String of the logged data
    */
    public String generateLog()
    {
        String log = "Number of caves visited: " + cavesVisited.size() + "\n";
        log += "Number of times secret code changed hands: " + 
            timesCodeChangedHands + "\n";
        log += String.format("Fellowship fight success rate: " + 
            "%.2f%%", calculateFightSuccessRate());
        return log;
    }

    /**
    * Accessor method to get the caves visited by the fellowship
    * @return An ArrayList of the caves previously visited
    */
    public ArrayList<Integer> getCavesVisited()
    {
        return cavesVisited;
    }

    /**
    * Method to get the number of caves visited by the fellowship
    * @return The number of caves the fellowship have visited
    */
    public int getCavesVisitedSize()
    {
        return cavesVisited.size();
    }

    /**
    * Accessor method to get the total number of fights that have happened
    * @return The number of fights
    */
    public int getNumberOfFights()
    {
        return numberOfFights;
    }

    /**
    * Accessor method to get the number of fights won by the fellowship
    * @return The number of fights won by the fellowship
    */
    public int getNumberOfFightsWon()
    {
        return numberOfFightsWon;
    }

    /**
    * Accessor method to get the number of times the secret code changed hands
    * @return The number of times the secret code changed hands
    */
    public int getTimesCodeChangedHands()
    {
        return timesCodeChangedHands;
    }

    /**
    * Method to increment the number of fights by 1
    */
    public void incrementNumberOfFights()
    {
        this.numberOfFights++;
    }

    /**
    * Method to increment the number of fights won by the fellowship by 1
    */
    public void incrementNumberOfFightsWon()
    {
        this.numberOfFightsWon++;
    }

    /**
    * Method to increment how many times the secret code changed hands by 1
    */
    public void incrementTimesCodeChangedHand()
    {
        this.timesCodeChangedHands++;
    }

    /**
    * Mutator method to set the caves visited by the fellowship
    * @param newCavesVisited An ArrayList of cave IDs visited by the fellowship
    */
    public void setCavesVisited(ArrayList<Integer> newCavesVisited)
    {
        if (newCavesVisited != null)
            this.cavesVisited = newCavesVisited;
    }

    /**
    * Mutator method to set the number of fights in the game
    * @param newNumberOfFights The number of fights
    */
    public void setNumberOfFights(int newNumberOfFights)
    {
        if (newNumberOfFights >= 0)
            this.numberOfFights = newNumberOfFights;
    }

    /**
    * Mutator method to set the number of fights won by the fellowship
    * @param newNumberOfFightsWon The number of fights won by the fellowship
    */
    public void setNumberOfFightsWon(int newNumberOfFightsWon)
    {
        if (newNumberOfFightsWon >= 0)
            this.numberOfFightsWon = newNumberOfFightsWon;
    }

    /**
    * Mutator method to set the times the secret code changed hands
    * @param newTimesCodeChangedHands Number of times the code changed hands
    */
    public void setTimesCodeChangedHands(int newTimesCodeChangedHands)
    {
        if (newTimesCodeChangedHands >= 0)
            this.timesCodeChangedHands = newTimesCodeChangedHands;
    }

    /**
    * Method method to update the caves visited by the fellowship
    * @param newCaveVisited A cave ID that the fellowship have just visited
    */
    public void updateCavesVisited(int newCaveVisited)
    {
        if (!cavesVisited.contains(newCaveVisited))
            cavesVisited.add(newCaveVisited);
        cavesVisited.sort(null);
    }
}
