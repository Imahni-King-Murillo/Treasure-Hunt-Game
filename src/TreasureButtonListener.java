/**
 *
 */

import java.awt.event.*;

public class TreasureButtonListener implements ActionListener
{
    // has-a TreasureGame
    private TreasureGame treasureGame;
    // has-a TreasureGameView
    private TreasureGameView treasureGameView;

    /**
     * Purpose: Construct a TreasureButtonListener
     * Input:
     * Output: None
     */
    public TreasureButtonListener(TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        treasureGame = newTreasureGame;
        treasureGameView = newTreasureGameView;
    }

    // Purpose: Whenever this listener is called, carryout the actions within the method
    public void actionPerformed(ActionEvent e)
    {
        treasureGame.reduceNumberOfTreasuresHidden();
        treasureGameView.setTreasuresLeftTextField("Number of Treasures Hidden: " + Integer.toString(treasureGame.getNumberOfTreasuresLeft()));
        treasureGameView.setTreasuresFoundTextField("Number of Treasures Found: " + Integer.toString(treasureGame.getNumberOfTreasuresFound()));
        // Set text within the treasure game view lastMoveTextField
        treasureGameView.setLastMoveTextField("Last Move: Treasure!");
    }
}
