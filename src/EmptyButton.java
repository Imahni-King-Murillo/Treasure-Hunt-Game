/**
 *
 */

import javax.swing.*;
import java.awt.*;
public class EmptyButton extends JButton
{
    // has-a TreasureGame();
    private TreasureGame treasureGame;
    // has-a TreasureGameView();
    private TreasureGameView treasureGameView;

    public EmptyButton(TreasureGame newTreasureGame, TreasureGameView newTreasureGameView)
    {
        super();
        treasureGame = newTreasureGame;
        treasureGameView = newTreasureGameView;
        setText("?");
        setForeground(Color.blue);
        addActionListener(new EmptyButtonListener(this, treasureGame, treasureGameView));
    }
}
