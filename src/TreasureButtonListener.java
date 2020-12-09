/**
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TreasureButtonListener implements ActionListener
{
    // has-a TreasureGame
    private TreasureGame treasureGame;
    // has-a TreasureGameView
    private TreasureGameView treasureGameView;
    // has-a JButton
    private TreasureButton treasureButton;

    /**
     * Purpose: Construct a TreasureButtonListener
     * Input:
     * Output: None
     */
    public TreasureButtonListener(TreasureButton newButton, TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        treasureButton = newButton;
        treasureGame = newTreasureGame;
        treasureGameView = newTreasureGameView;
    }

    // Purpose: Whenever this listener is called, carryout the actions within the method
    public void actionPerformed(ActionEvent e)
    {
        if (!treasureGame.isGameOver())
        {
            // set image
            treasureButton.setIcon(treasureButton.revealIcon());
            // Do the foundTreasure function from TreasureGame
            treasureGameView.foundTreasure();
            // set button status to false
            treasureButton.setButtonStatus(false);
            // Try to end game
            treasureGameView.endGame();
            // remove action listener
            treasureButton.removeActionListener(treasureButton.getActionListeners()[0]);
        }
    }
}
