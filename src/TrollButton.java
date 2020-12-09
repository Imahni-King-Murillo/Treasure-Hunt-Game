public class TrollButton extends EmptyButton
{
    // has-a TreasureGame();
    private TreasureGame treasureGame;
    // has-a TreasureGameView();
    private TreasureGameView treasureGameView;

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

    public String revealButtonText()
    {
        return "Troll!";
    }
}