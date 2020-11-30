import javax.swing.*;

public class TreasureGame
{
    // has-a number of tries
    private int numberOfTries;
    // has-a number of treasures;
    private int numberOfTreasures;
    // has-a number of treasures found
    private int numberOfTreasuresFound;
    // has-a TreasureGameView
    private TreasureGameView treasureGameView;

    // Purpose: Construct a TreasureGame
    public TreasureGame()
    {
        // set initial number of tries
        numberOfTries = 50;
        // set initial number of treasures
        numberOfTreasures = 20;
        // set initial number of treasures found
        numberOfTreasuresFound = 0;
    }

    // Purpose: Subtract 1 from numberOfTries
    public void reduceNumberOfTries()
    {
        numberOfTries--;
    }

    /**
     * Purpose: Update data and text fields when a treasure is found
     * Input: 4 JTextFields
     * Output: None
     */
    public void foundTreasure(JTextField lastMoveText, JTextField triesLeftText, JTextField treasuresLeftText, JTextField treasuresFoundText)
    {
        // if the game isn't over...
        if(!isGameOver())
        {
            // subtract 1 from number of tries
            reduceNumberOfTries();
            // subtract 1 from number of treasures
            numberOfTreasures--;
            // add 1 to number of treasures found
            numberOfTreasuresFound++;
            // update lastMoveText field
            lastMoveText.setText("Last Move: Treasure!");
            // update triesLeftText field
            triesLeftText.setText("Number of Tries Left: " + Integer.toString(getNumberOfTriesLeft()));
            // update treasuresLeftText field
            treasuresLeftText.setText("Number of Treasures Hidden: " + Integer.toString(getNumberOfTreasuresLeft()));
            // update treasuresFoundText field
            treasuresFoundText.setText("Number of Treasures Found: " + Integer.toString(getNumberOfTreasuresFound()));
        } // end of if-statement
    }

    /**
     * Purpose: Update data and text fields when nothing is found
     * Input: 2 JTextFields
     * Output: None
     */
    public void foundNothing(JTextField lastMoveText, JTextField triesLeftText)
    {
        // if the game isn't over...
        if (!isGameOver())
        {
            // subtract 1 from number of tries
            reduceNumberOfTries();
            // update lastMoveText field
            lastMoveText.setText("Last Move: Nothing...");
            // update triesLeftText field
            triesLeftText.setText("Number of Tries Left: " + Integer.toString(getNumberOfTriesLeft()));
        } // end of if-statement
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
        if (numberOfTreasuresFound == 20 || numberOfTries == 0)
        {
            // the game is over
            return true;
        }
        // the game is not over
        return false;
    }

    /**
     * Purpose: End the game by disabling all buttons and telling the user their win status
     * Input: JButton[], JTextField
     * Output: None
     */
    public void endGame(JTextField text1)
    {
        // If the game is over...
        if (isGameOver())
        {
            // If there are treasures left
            if (getNumberOfTreasuresLeft() > 0)
            {
                // Tell player they lost
                text1.setText("Game Over - You Lose");
            }
            else
            {
                // Tell player they won
                text1.setText("Game Over - You Win!");
            }
        }
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
     * Purpose: return number of treasures found
     * Input: None
     * Output: int
     * Example:
     *  getNumberOfTreasuresFound(); return 0
     */
    public int getNumberOfTreasuresFound()
    {
        return numberOfTreasuresFound;
    }
}