/**
 *
 */
public class TreasureGame
{
    // has-a number of tries
    private int numberOfTries;
    // has-a number of treasures;
    private int numberOfTreasures;
    // has-a number of treasures found
    private int numberOfTreasuresFound;
    // has-a game over boolean
    private boolean gameOver = false;

    public TreasureGame()
    {
        numberOfTries = 50;
        numberOfTreasures = 20;
        numberOfTreasuresFound = 0;
    }

    public void reduceNumberOfTries()
    {
        numberOfTries--;
    }

    public int getNumberOfTriesLeft()
    {
        return numberOfTries;
    }

    public void reduceNumberOfTreasuresHidden()
    {
        if(numberOfTries > 0)
        {
            numberOfTreasures--;
            numberOfTreasuresFound++;
        }
    }

    public int getNumberOfTreasuresLeft()
    {
        return numberOfTreasures;
    }

    public int getNumberOfTreasuresFound()
    {
        return numberOfTreasuresFound;
    }

    public void setGameStatus()
    {
        if (numberOfTreasuresFound == 20 || numberOfTries == 0)
        {
            gameOver = true;
        }
    }

    public boolean getGameStatus()
    {
        return gameOver;
    }
}