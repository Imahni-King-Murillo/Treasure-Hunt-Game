import javax.swing.*;
import java.awt.*;

/**
 *
 */

public class TreasureButton extends EmptyButton // is-a(n) EmptyButton
{
    // has-a TreasureGame();
    private TreasureGame treasureGame;
    // has-a TreasureGameView();
    private TreasureGameView treasureGameView;

    /**
     * Purpose: Construct a TreasureButton
     * Input: 1 TreasureGame, 1 TreasureGameView
     * Output: None
     */
    public TreasureButton(TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        // Add the inputted params into the superclass constructor
        super(newTreasureGame, newTreasureGameView);
        // Assign treasureGame to inputted TreasureGame
        treasureGame = newTreasureGame;
        // Assign treasureGameView to inputted TreasureGameView
        treasureGameView = newTreasureGameView;
        // remove the EmptyButton action listener
        removeActionListener(getActionListeners()[0]);
        // add a TreasureButtonListener as the action listener
        addActionListener(new TreasureButtonListener(this, treasureGame, treasureGameView));
    }
}