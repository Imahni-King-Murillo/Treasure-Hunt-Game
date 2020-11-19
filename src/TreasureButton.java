/**
 *
 */

public class TreasureButton extends EmptyButton
{
    public TreasureButton(TreasureGame treasureGame, TreasureGameView treasureGameView)
    {
        super(treasureGame, treasureGameView);
        setText("T");
        addActionListener(new TreasureButtonListener(treasureGame, treasureGameView));
    }
}