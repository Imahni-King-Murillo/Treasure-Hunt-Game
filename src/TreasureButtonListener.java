/**
 *
 */

import javax.swing.*;
import java.awt.event.*;

public class TreasureButtonListener implements ActionListener
{
    // has-a JButton
    private JButton treasureButton;
    // has-a TreasureGame
    private TreasureGame treasureGame;
    // has-a TreasureGameView
    private TreasureGameView treasureGameView;

    /**
     * Purpose: Construct a TreasureButtonListener
     * Input:
     * Output: None
     */
    public TreasureButtonListener(JButton newButton, TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        treasureButton = newButton;
        treasureGame = newTreasureGame;
        treasureGameView = newTreasureGameView;
    }

    // Purpose: Whenever this listener is called, carryout the actions within the method
    public void actionPerformed(ActionEvent e)
    {
        // Set treasureButton text to an "$"
        treasureButton.setText("$");
        treasureGame.reduceNumberOfTreasuresHidden();
        // Take away 1 from number of tries
        treasureGame.reduceNumberOfTries();
        treasureGameView.setTreasuresLeftTextField("Number of Treasures Hidden: " + Integer.toString(treasureGame.getNumberOfTreasuresLeft()));
        treasureGameView.setTreasuresFoundTextField("Number of Treasures Found: " + Integer.toString(treasureGame.getNumberOfTreasuresFound()));
        // Set text within the treasure game view triesLeftTextField
        treasureGameView.setTriesLeftTextField("Number of Tries Left: " + Integer.toString(treasureGame.getNumberOfTriesLeft()));
        // Set text within the treasure game view lastMoveTextField
        treasureGameView.setLastMoveTextField("Last Move: Treasure!");
        // Call revealTreasureButtons
        treasureGameView.revealTreasureButtons();
        // Call setButtonState function
        treasureGameView.setButtonState();
        // Disable already clicked button
        treasureButton.setEnabled(false);
    }
}
