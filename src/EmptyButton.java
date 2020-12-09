
import javax.swing.*;
public class EmptyButton extends JButton
{
    // has-a TreasureGame();
    private TreasureGame treasureGame;
    // has-a TreasureGameView();
    private TreasureGameView treasureGameView;

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

    // Purpose: Return a string to set the button text to
    public String revealButtonText()
    {
        return "X";
    }
}
