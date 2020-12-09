import java.util.Random;

public class TreasureGame
{
    // has-a number of tries
    private int numberOfTries;
    // has-a number of treasures;
    private int numberOfTreasures;
    // has-a number of points
    private int numberOfPoints;
    // has-many point options
    private int[] pointOptions = {1,2,3};
    // has-a change in point amount
    private int changeInPointAmount = 0;
    // has-a number of trolls
    private int numberOfTrolls;
    // has-a TreasureGameView
    private TreasureGameView treasureGameView;

    // Purpose: Construct a TreasureGame
    public TreasureGame()
    {
        // set initial number of tries
        numberOfTries = 50;
        // set initial number of treasures
        numberOfTreasures = 20;
        // set initial number of points
        numberOfPoints = 0;
        // set initial number of trolls
        numberOfTrolls = 20;
    }

    // Purpose: Subtract 1 from numberOfTries
    public void reduceNumberOfTries()
    {
        if (!isGameOver())
        {
            numberOfTries--;
        }
    }

    // Purpose: Subtract 1 from number of trolls on board and reset all treasure
    public void foundTroll()
    {
        if (!isGameOver())
        {
            // subtract 1 from number of tries
            reduceNumberOfTries();
            // subtract 1 from number of trolls
            numberOfTrolls--;
            // set changeInPointAmount to the negative of the most recent amount of points
            changeInPointAmount = 0 - numberOfPoints;
            // reset number of points recieved
            numberOfPoints = 0;
        }
    }

    /**
     * Purpose: Update data and text fields when a treasure is found
     * Input: 4 JTextFields
     * Output: None
     */
    public void foundTreasure()
    {
        if (!isGameOver())
        {
            // Declare random to choose a random number
            Random randomPointIndexGenerator = new Random();
            // Make a random number
            int pointIndex = randomPointIndexGenerator.nextInt(3);
            // create int to hold current numberOfPoints
            int currentNumberOfPoints = numberOfPoints;
            // subtract 1 from number of tries
            reduceNumberOfTries();
            // subtract 1 from number of treasures
            numberOfTreasures--;
            // add the selected index of the pointOptions array to numberOfPoints
            numberOfPoints += pointOptions[pointIndex];
            // assign the difference between the old number of points and the new number of points to changeInPointAmount
            changeInPointAmount = numberOfPoints - currentNumberOfPoints;
        }
    }

    /**
     * Purpose: Update data and text fields when nothing is found
     * Input: 2 JTextFields
     * Output: None
     */
    public void foundNothing()
    {
        if (!isGameOver())
        {
            // subtract 1 from number of tries
            reduceNumberOfTries();
        }
    }

    /** Purpose: Check if the game is over and return the boolean status
     * Input: None
     * Output: boolean
     * Example:
     *  isGameOver(); return false
     */
    public boolean isGameOver()
    {
        // if number of treasures found is 20 or if number of tries left is 0...
        if (numberOfTreasures == 0 || numberOfTries == 0)
        {
            // the game is over
            return true;
        }
        // the game is not over
        return false;
    }

    /**
     * Purpose: return number of tries left
     * Input: None
     * Output: int
     * Example:
     *  getNumberOfTriesLeft(); return 50
     */
    public int getNumberOfTriesLeft()
    {
        return numberOfTries;
    }

    /**
     * Purpose: return number of treasures left
     * Input: None
     * Output: int
     * Example:
     *  getNumberOfTreasuresLeft(); return 20
     */
    public int getNumberOfTreasuresLeft()
    {
        return numberOfTreasures;
    }

    /**
     * Purpose: return number of trolls left
     * Input: None
     * Output: int
     *  getNumberOfTrolls(); return 20
     */
    public int getNumberOfTrolls()
    {
        return numberOfTrolls;
    }

    /**
     * Purpose: return number of points
     * Input: None
     * Output: int
     *  getNumberOfPoints(); return 300;
     */
    public int getNumberOfPoints()
    {
        return numberOfPoints;
    }

    /**
     * Purpose: return change in point amount
     * Input: None
     * Output: int
     *  getChangeInPointAmount(); return 3
     */
    public int getChangeInPointAmount()
    {
        return changeInPointAmount;
    }
}