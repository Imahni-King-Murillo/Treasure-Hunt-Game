/**
 *
 */

import javax.swing.*;
import java.awt.*;
public class TreasureGameView extends JFrame
{
    // has-a TreasureGame
    private TreasureGame treasureGame;
    // has-a label
    private JLabel gameLabel;
    // has-a textField
    private JTextField triesLeftTextField;
    // has-a textField
    private JTextField treasuresLeftTextField;
    // has-a textField
    private JTextField treasuresFoundTextField;
    // has-a textField
    private JTextField lastMoveTextField;

    // Purpose: Construct a TreasureGameView()
    public TreasureGameView(TreasureGame newTreasureGame)
    {
        // Set treasureGame to inputted TreasureGame
        treasureGame = newTreasureGame;
        // Set the title for the user to see the name of the game
        setTitle("Treasure Hunt Game");
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a 10x10 grid layout for the game
        GridLayout gameLayout = new GridLayout(10, 10);
        // Create a grid status layout for the UI
        GridLayout statusLayout = new GridLayout(4, 1);
        // Create a border layout for the complete UI
        BorderLayout uiLayout = new BorderLayout();
        // Create a panel to add all statuses
        JPanel statusPanel = new JPanel();
        // Create a panel to add all of the game content
        JPanel gamePanel = new JPanel();
        // Create a panel to add al of the UI
        JPanel uiPanel = new JPanel();
        // Set the layout of the staus panel to the create 5 x 1 GridLayout
        statusPanel.setLayout(statusLayout);
        // Set the layout of the gamePanel to the created 10x10 GridLayout
        gamePanel.setLayout(gameLayout);
        // Set the layout of the uiPanel to the created BorderLayout
        uiPanel.setLayout(uiLayout);
        // Loop to add 20 TreasureButtons into the gamePanel
        for (int index = 0; index < 20; index++)
        {
            gamePanel.add(new TreasureButton(treasureGame, this));
        }
        // Loop to add 100 EmptyButtons into the gamePanel
        for (int index = 0; index < 80; index++)
        {
            gamePanel.add(new EmptyButton(treasureGame, this));
        }
        // Set the text and color of the gameLabel
        gameLabel = new JLabel("Treasure Hunt!");
        // Set the color of the gameLabel
        gameLabel.setForeground(Color.yellow);
        // Set the background color of the gameLabel
        gameLabel.setBackground(Color.black);
        // Make the gameLabel background visible
        gameLabel.setOpaque(true);
        // Put the gameLabel in the center of the uiPanel
        gameLabel.setHorizontalAlignment(JLabel.CENTER);
        // Set the text within the triesLeftTextField
        triesLeftTextField = new JTextField("Number of Tries: " + Integer.toString(treasureGame.getNumberOfTriesLeft()));
        // Make the triesLeftTextField uneditable
        triesLeftTextField.setEditable(false);
        // Set the text within the treasuresLeftTextField
        treasuresLeftTextField = new JTextField("Number of Treasures Hidden: " + Integer.toString(treasureGame.getNumberOfTreasuresLeft()));
        // Make the treasureLeftTextField uneditable
        treasuresLeftTextField.setEditable(false);
        // Set the text within the treasuresFoundTextField
        treasuresFoundTextField = new JTextField("Number of Treasures Found: 0");
        // Make the treasuresFoundTextField uneditable
        treasuresFoundTextField.setEditable(false);
        // Set the text within the lastMoveTextField
        lastMoveTextField = new JTextField("Last Move: Game Start");
        // Make the lastMoveTextField uneditable
        lastMoveTextField.setEditable(false);

        // Add the triesLeftTextField to the statusPanel
        statusPanel.add(triesLeftTextField);
        // Add the treasureLeftTextField to the statusPanel
        statusPanel.add(treasuresLeftTextField);
        // Add the treasuresFoundTextField to the statusPanel
        statusPanel.add(treasuresFoundTextField);
        // Add the lastMoveTextField to the statusPanel
        statusPanel.add(lastMoveTextField);

        // Add the gamelabel to the uiPanel
        uiPanel.add(gameLabel, BorderLayout.NORTH);
        // Add the statusPanel to the uiPanel
        uiPanel.add(statusPanel, BorderLayout.WEST);
        // Add the gamePanel to the center of the BorderLayout
        uiPanel.add(gamePanel, BorderLayout.CENTER);

        // Add the UI panel into the JFrame
        add(uiPanel);

        // Pack the JFrame size to the size of the gamePanel
        pack();
        // Set visibility to true in order for the JFrame to show up
        setVisible(true);
    }

    /**
     * Purpose: Set the text within the triesLeftTextField
     * Input: String
     * Output: None;
     */
    public void setTriesLeftTextField(String newText)
    {
        triesLeftTextField.setText(newText);
    }

    /**
     * Purpose: Set the text within the treasuresLeftTextField
     * Input: String
     * Output: None;
     */
    public void setTreasuresLeftTextField(String newText)
    {
        treasuresLeftTextField.setText(newText);
    }

    /**
     * Purpose: Set the text within the treasuresFoundTextField
     * Input: String
     * Output: None
     */
    public void setTreasuresFoundTextField(String newText)
    {
        treasuresFoundTextField.setText(newText);
    }

    /**
     * Purpose: Update the lastMoveTextField
     * Input: String
     * Output: None
     */
    public void setLastMoveTextField(String newText)
    {
        if (treasureGame.getNumberOfTriesLeft() <= 0 && treasureGame.getNumberOfTreasuresFound() < 20)
        {
            lastMoveTextField.setText("Game Over - You Lose");
        }
        else if (treasureGame.getNumberOfTreasuresFound() >= 20)
        {
            lastMoveTextField.setText("Game Over- You Win!");
        }
        else
        {
            lastMoveTextField.setText(newText);
        }
    }

    // Purpose: Method to begin a Treasure Hunt Game
    public static void main()
    {
        TreasureGame treasureGame = new TreasureGame();
        TreasureGameView treasureGameView = new TreasureGameView(treasureGame);
    }
}
