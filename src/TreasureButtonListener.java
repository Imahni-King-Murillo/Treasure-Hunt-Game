/**
 *
 */

import javax.swing.*;
import java.awt.event.*;

public class TreasureButtonListener implements ActionListener
{
    // has-a TreasureGame
    private TreasureGame treasureGame;
    // has-a TreasureGameView
    private TreasureGameView treasureGameView;
    // has-a JButton
    private JButton treasureButton;

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
        // Set button text
        treasureButton.setText("$");
        // Do the foundTreasure function from TreasureGame
        treasureGameView.foundTreasure();
        // Try to end game
        treasureGameView.endGame();
        // Disable button
        treasureButton.setEnabled(false);
    }
}
