import javax.swing.*;
import java.awt.*;

/**
 *
 */

public class TreasureButton extends JButton
{
    // has-a TreasureGame();
    private TreasureGame treasureGame;
    // has-a TreasureGameView();
    private TreasureGameView treasureGameView;

    public TreasureButton(TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        super();
        treasureGame = newTreasureGame;
        treasureGameView = newTreasureGameView;
        setForeground(Color.blue);
        addActionListener(new TreasureButtonListener(this,treasureGame, treasureGameView));
    }
}