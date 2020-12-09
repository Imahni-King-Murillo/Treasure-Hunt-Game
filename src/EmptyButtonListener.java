
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmptyButtonListener implements ActionListener
{
    // has-a button
    private EmptyButton emptyButton;
    // has-a TreasureGame
    private TreasureGame treasureGame;
    // has-a TreasureGameView
    private TreasureGameView treasureGameView;

    /**
     * Purpose: Construct a TreasureButtonListener
     * Input: JButton
     * Output: None
     */
    public EmptyButtonListener(EmptyButton newButton, TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        emptyButton = newButton;
        treasureGame = newTreasureGame;
        treasureGameView = newTreasureGameView;
    }

    // Purpose: Whenever button is pressed, carry out actions within method
    public void actionPerformed(ActionEvent e)
    {
        if (!treasureGame.isGameOver())
        {
            // set image
            emptyButton.setIcon(emptyButton.revealIcon());
            // Take away 1 from number of tries
            treasureGameView.foundNothing();
            // set button status false
            emptyButton.setButtonStatus(false);
            // Try to end game
            treasureGameView.endGame();
            // remove action listener
            emptyButton.removeActionListener(emptyButton.getActionListeners()[0]);
        }
    }
}