import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrollButtonListener implements ActionListener
{
    // has-a TreasureGame
    private TreasureGame treasureGame;
    // has-a TreasureGameView
    private TreasureGameView treasureGameView;
    // has-a TrollButton
    private TrollButton trollButton;

    /**
     * Purpose: Construct a TrollButtonListener
     * Input:
     * Output: None
     */
    public TrollButtonListener(TrollButton newButton, TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        trollButton = newButton;
        treasureGame = newTreasureGame;
        treasureGameView = newTreasureGameView;
    }

    // Purpose: Whenever this listener is called, carryout the actions within the method
    public void actionPerformed(ActionEvent e)
    {
        if (!treasureGame.isGameOver())
        {
            // set button image
            trollButton.setIcon(trollButton.revealIcon());
            // Do the foundTroll function from TreasureGame
            treasureGameView.foundTroll();
            // set button status to false
            trollButton.setButtonStatus(false);
            // Try to end game
            treasureGameView.endGame();
            // remove action listener
            trollButton.removeActionListener(trollButton.getActionListeners()[0]);
        }
    }
}
