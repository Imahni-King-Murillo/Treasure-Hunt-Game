
import javax.swing.*;
import java.awt.*;

public class EmptyButton extends JButton
{
    // has-a TreasureGame();
    private TreasureGame treasureGame;
    // has-a TreasureGameView();
    private TreasureGameView treasureGameView;
    // has-a boolean
    private boolean buttonStatus = true;

    /**
     * Purpose: Construct an EmptyButton
     * Input: 1 TreasureGame, 1 TreasureGameView
     * Output: None
     */
    public EmptyButton(TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        super();
        // Assign treasureGame to inputted TreasureGame
        treasureGame = newTreasureGame;
        // Assign treasureGameView to inputted TreasureGameView
        treasureGameView = newTreasureGameView;
        // Add an EmptyButtonListener as the action listener
        addActionListener(new EmptyButtonListener(this, treasureGame, treasureGameView));
    }

    public Icon revealIcon()
    {
        Icon emptyIcon = new ImageIcon("img/empty.png");
        return emptyIcon;
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
        return Color.black;
    }
}
