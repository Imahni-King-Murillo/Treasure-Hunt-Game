/**
 *
 */

import javax.swing.*;
import java.awt.event.*;

public class EmptyButtonListener implements ActionListener
{
    // has-a button
    private JButton emptyButton;
    // has-a TreasureGame
    private TreasureGame treasureGame;
    // has-a TreasureGameView
    private TreasureGameView treasureGameView;

    /**
     * Purpose: Construct a TreasureButtonListener
     * Input: JButton
     * Output: None
     */
    public EmptyButtonListener(JButton newButton, TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        emptyButton = newButton;
        treasureGame = newTreasureGame;
        treasureGameView = newTreasureGameView;
    }

    // Purpose: Whenever button is pressed, carry out actions within method
    public void actionPerformed(ActionEvent e)
    {
        // Set treasureButton text to an "X"
        emptyButton.setText("X");
        // Take away 1 from number of tries
        treasureGame.reduceNumberOfTries();
        // Set text within the treasure game view triesLeftTextField
        treasureGameView.setTriesLeftTextField("Number of Tries Left: " + Integer.toString(treasureGame.getNumberOfTriesLeft()));
        // Set text within the treasure game view lastMoveTextField
        treasureGameView.setLastMoveTextField("Last Move: Nothing...");
        // Disable the button
        emptyButton.setEnabled(false);
    }
}