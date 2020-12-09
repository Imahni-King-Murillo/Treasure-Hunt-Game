import javax.swing.*;
import java.awt.*;

public class TrollButton extends EmptyButton
{
    // has-a TreasureGame();
    private TreasureGame treasureGame;
    // has-a TreasureGameView();
    private TreasureGameView treasureGameView;
    // has-a boolean
    private boolean buttonStatus = true;

    /**
     * Purpose: Create a TrollButton
     * Input: 1 TreasureGame, 1 TreasureGameView
     * Output: None
     */
    public TrollButton(TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        // Add the inputted params into the superclass constructor
        super(newTreasureGame, newTreasureGameView);
        // Assign treasureGame to inputted TreasureGame
        treasureGame = newTreasureGame;
        // Assign treasureGameView to inputted TreasureGameView
        treasureGameView = newTreasureGameView;
        // remove the EmptyButton action listener
        removeActionListener(getActionListeners()[0]);
        // add a TrollButtonListener as the action listener
        addActionListener(new TrollButtonListener(this, treasureGame, treasureGameView));
    }

    public Icon revealIcon()
    {
        Icon trollIcon = new ImageIcon("img/troll.png");
        return trollIcon;
    }

    public void setButtonStatus(boolean status)
    {
        buttonStatus = status;
    }

    public boolean getButtonStatus()
    {
        return buttonStatus;
    }

    public Color revealBorder()
    {
        return Color.red;
    }
}