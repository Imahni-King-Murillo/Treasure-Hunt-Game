import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class TreasureGameView extends JFrame
{
    // has-a TreasureGame
    private TreasureGame treasureGame;
    // has-a label
    private JLabel gameLabel;
    // has-a textField
    private JTextField triesLeftTextField;
    // has-a textField
    private JTextField pointsGainedTextField;
    // has-a textField
    private JTextField lastMoveTextField;
    // has-a label
    private JLabel treasureLegendLabel;
    // has-a label
    private JLabel emptyLegendLabel;
    // has-a label
    private JLabel trollLegendLabel;
    // has-an Icon
    private Icon treasureIcon = new ImageIcon("img/treasure.png");
    // has-an Icon
    private Icon emptyIcon = new ImageIcon("img/empty.png");
    // has-an Icon
    private Icon trollIcon = new ImageIcon("img/troll.png");
    // has-a menu bar
    private JMenuBar menuBar;
    // has-an options menu
    private JMenu optionsMenu;
    // has-an about menu
    private JMenu aboutMenu;
    // has-many JButtons
    private EmptyButton[] buttonGrid;
    // has-a Random
    private Random randomIndexGenerator;

    /**
     * Purpose: construct a TreasureGameView
     * Input: 1 TreasureGame
     */
    public TreasureGameView(TreasureGame newTreasureGame)
    {
        // Set treasureGame to inputted TreasureGame
        treasureGame = newTreasureGame;
        // Set the size of the buttonGrid
        buttonGrid = new EmptyButton[10 * 10];
        // Initialize Random object
        randomIndexGenerator = new Random();
        // Set the title for the user to see the name of the game
        setTitle("Treasure Hunt Game");
        // Set window size
        setSize(1000, 600);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a 10x10 grid layout for the game
        GridLayout gameLayout = new GridLayout(10, 10);
        // Create a grid status layout for the UI
        GridLayout statusLayout = new GridLayout(4, 1);
        // Create a grid legend layout for the legend instructions
        GridLayout legendLayout = new GridLayout(3, 1);
        // Create a border layout for the complete UI
        BorderLayout uiLayout = new BorderLayout();
        // Create a panel to add all statuses
        JPanel statusPanel = new JPanel();
        // Create a panel to add the legend
        JPanel legendPanel = new JPanel();
        // Create a panel to add all of the game content
        JPanel gamePanel = new JPanel();
        // Create a panel to add al of the UI
        JPanel uiPanel = new JPanel();
        // Set the layout of the staus panel to the created 5 x 1 GridLayout
        statusPanel.setLayout(statusLayout);
        // Set the layout of the legend panel to the created 3 x 1 GridLayout
        legendPanel.setLayout(legendLayout);
        // Set the layout of the gamePanel to the created 10x10 GridLayout
        gamePanel.setLayout(gameLayout);
        // Set the layout of the uiPanel to the created BorderLayout
        uiPanel.setLayout(uiLayout);

        // counter for the loop below to insure 20 TreasureButtons are inserted
        int treasureCounter = 0;
        // counter for the loop below to insure 20 TrollButtons are inserted
        int trollCounter = 0;
        // Loop to add TreasureButton()'s into random indexes within the buttonGrid
        while (treasureCounter < treasureGame.getNumberOfTreasuresLeft())
        {
            // Create a random int upon every iteration
            int insertionIndex = randomIndexGenerator.nextInt(99);
            // if the randomly selected index is null...
            if (buttonGrid[insertionIndex] == null)
            {
                // Add new button to random grid index
                buttonGrid[insertionIndex] = new TreasureButton(treasureGame, this);
                // Add 1 to counter
                treasureCounter++;
            } // end of if-statement
        } // end of while-loop

        // Loop to add TrollButton()'s into random indexes within the buttonGrid
        while (trollCounter < treasureGame.getNumberOfTrolls())
        {
            // Create a random int upon every iteration
            int insertionIndex = randomIndexGenerator.nextInt(99);
            // if the randomly selected index is null...
            if (buttonGrid[insertionIndex] == null)
            {
                // Add new button to random grid index
                buttonGrid[insertionIndex] = new TrollButton(treasureGame, this);
                // Add 1 to counter
                trollCounter++;
            } // end of if-statement
        } // end of while-loop

        // Loop to add EmptyButton()'s into remaining null indexes within the buttonGrid
        for (int index = 0; index < buttonGrid.length; index++)
        {
            // if the current index is null, add an EmptyButton() into it
            if (buttonGrid[index] == null)
            {
                // Add new button into current null index
                buttonGrid[index] = new EmptyButton(treasureGame, this);
            }
        } // end of for-loop

        // Loop to add all of the contents of the buttonGrid into the gamePanel
        for (int index = 0; index < buttonGrid.length; index++)
        {
            // Add every button in the button grid to the gamePanel
            gamePanel.add(buttonGrid[index]);
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
        // Set the text within the pointsGainedTextField
        pointsGainedTextField = new JTextField("Number of Points Gained: " + Integer.toString(treasureGame.getNumberOfPoints()));
        // Make the pointsGainedTextField uneditable
        pointsGainedTextField.setEditable(false);
        // Set the text within the lastMoveTextField
        lastMoveTextField = new JTextField("Last Move: Game Start");
        // Make the lastMoveTextField uneditable
        lastMoveTextField.setEditable(false);
        // Set the text of the treasureLegendLabel
        treasureLegendLabel = new JLabel(" = A Treasure");
        // set icon of treasureLegendLabel
        treasureLegendLabel.setIcon(treasureIcon);
        // set background color of the treasureLegendLabel
        treasureLegendLabel.setBackground(Color.white);
        // Make label background visible
        treasureLegendLabel.setOpaque(true);
        // Set the text of the emptyLegendLabel
        emptyLegendLabel = new JLabel(" = No Treasure");
        // set icon of treasureLegendLabel
        emptyLegendLabel.setIcon(emptyIcon);
        // set the background color of the emptyLegendLabel
        emptyLegendLabel.setBackground(Color.white);
        // Make label background visible
        emptyLegendLabel.setOpaque(true);
        // Set the text of the trollLegendLabel
        trollLegendLabel = new JLabel(" = A Troll. All Points Lost!");
        // set icon of trollLegendLabel
        trollLegendLabel.setIcon(trollIcon);
        // set the background color of the trollLegendLabel
        trollLegendLabel.setBackground(Color.white);
        // Make label background visible
        trollLegendLabel.setOpaque(true);

        // Add the triesLeftTextField to the statusPanel
        statusPanel.add(triesLeftTextField);
        // Add the pointsGainedTextField to the statusPanel
        statusPanel.add(pointsGainedTextField);
        // Add the lastMoveTextField to the statusPanel
        statusPanel.add(lastMoveTextField);

        // Add the treasureLegendLabel to the legendPanel
        legendPanel.add(treasureLegendLabel);
        // Add the emptyLegendLabel to the legendPanel
        legendPanel.add(emptyLegendLabel);
        // Add the trollLegendLabel to the legendPanel
        legendPanel.add(trollLegendLabel);

        // Add the gamelabel to the uiPanel
        uiPanel.add(gameLabel, BorderLayout.NORTH);
        // Add the statusPanel to the uiPanel
        uiPanel.add(statusPanel, BorderLayout.WEST);
        // Add the gamePanel to the center of the BorderLayout
        uiPanel.add(gamePanel, BorderLayout.CENTER);
        // Add the legendPanel to the uiPanel
        uiPanel.add(legendPanel, BorderLayout.EAST);

        // build and add menu bar
        buildMenuBar();

        // Add the UI panel into the JFrame
        add(uiPanel);
        // Set visibility to true in order for the JFrame to show up
        setVisible(true);
    }

    // Purpose: Build the game menu bar
    private void buildMenuBar()
    {
        // Create the menu bar
        menuBar = new JMenuBar();

        // Create the options menu
        buildOptionsMenu();
        // Create the about menu
        buildAboutMenu();

        // add options menu to the menu bar
        menuBar.add(optionsMenu);
        // add about menu to the menu bar
        menuBar.add(aboutMenu);

        // Set the games menu bar
        setJMenuBar(menuBar);
    }

    // Purpose: Build the options menu
    private void buildOptionsMenu()
    {
        // create exit item
        JMenuItem exitItem = new JMenuItem("Exit Game");
        // set exit item mnemonic
        exitItem.setMnemonic(KeyEvent.VK_X);
        // add exit item action listner
        exitItem.addActionListener(new ExitListener());

        // Create the options menu
        optionsMenu = new JMenu("Options");
        // set options menu mnemonic
        optionsMenu.setMnemonic(KeyEvent.VK_O);

        // add the exit item to the optionsMenu
        optionsMenu.add(exitItem);
    }

    // Purpose: build an about menu
    private void buildAboutMenu()
    {
        // array of creator names
        String[] creatorNames = {"Imahni King", "Evan McClure"};
        // array of creator "emails"
        String[] creatorContacts = {"imahniking@game.com", "evanmcclure@game.com"};

        // create about menu
        aboutMenu = new JMenu("About");
        // set aboutMenu mnemonic
        aboutMenu.setMnemonic(KeyEvent.VK_A);

        // loop to create menu items for every creator and add them to about menu
        for (int index = 0; index < creatorNames.length; index++)
        {
            // Create the item name based off of the current creatorName index
            String itemName = creatorNames[index];
            // Create the item contact info bassed off of the current creatorContact index
            String itemContact = creatorContacts[index];
            // create a creator item that consists of the creators name and contact
            JMenuItem creatorItem = new JMenuItem(itemName + ": " + itemContact);
            // add creatorItem to the aboutMenu
            aboutMenu.add(creatorItem);
        }
    }

    // Purpose: Update data and text fields when nothing is found
    public void foundNothing()
    {
        // Call the foundNothing method from TreasureGame
        treasureGame.foundNothing();
        // update triesLeftText field
        triesLeftTextField.setText("Number of Tries Left: " + Integer.toString(treasureGame.getNumberOfTriesLeft()));
        // Illuminate the "X" on the legend
        emptyLegendLabel.setBackground(Color.green);
        treasureLegendLabel.setBackground(Color.white);
        trollLegendLabel.setBackground(Color.white);
        // if the game isn't over...
        if (!treasureGame.isGameOver())
        {
            // update lastMoveText field
            lastMoveTextField.setText("Last Move: Nothing...");
        } // end of if-statement
    }


    // Purpose: Update data and text fields when a treasure is found
    public void foundTreasure()
    {
        // Call the foundTreasure method from TreasureGame
        treasureGame.foundTreasure();
        // update triesLeftText field
        triesLeftTextField.setText("Number of Tries Left: " + Integer.toString(treasureGame.getNumberOfTriesLeft()));
        // update pointsGainedText field
        pointsGainedTextField.setText("Number of Points Gained: " + Integer.toString(treasureGame.getNumberOfPoints()));
        // Illuminate the "$" on the legend
        emptyLegendLabel.setBackground(Color.white);
        treasureLegendLabel.setBackground(Color.green);
        trollLegendLabel.setBackground(Color.white);

        // if the game isn't over...
        if(!treasureGame.isGameOver())
        {
            // if the number of points gained is greater than 1...
            if (treasureGame.getChangeInPointAmount() > 1)
            {
                // update lastMoveText field
                lastMoveTextField.setText("Last Move: " + Integer.toString(treasureGame.getChangeInPointAmount()) + " points gained!");
            }
            // if the number of points gained is 1
            else
            {
                // update lastMoveText field
                lastMoveTextField.setText("Last Move: " + Integer.toString(treasureGame.getChangeInPointAmount()) + " point gained!");
            }
        } // end of if-statement
    }

    // Purpose: Update data and text fields when a troll is found
    public void foundTroll()
    {
        // Call the foundTroll method from TreasureGame
        treasureGame.foundTroll();
        // update triesLeftText field
        triesLeftTextField.setText("Number of Tries Left: " + Integer.toString(treasureGame.getNumberOfTriesLeft()));
        // update pointsGainedText field
        pointsGainedTextField.setText("Number of Points Gained: " + Integer.toString(treasureGame.getNumberOfPoints()));
        // Illuminate the "Troll!" on the legend
        emptyLegendLabel.setBackground(Color.white);
        treasureLegendLabel.setBackground(Color.white);
        trollLegendLabel.setBackground(Color.red);
        // if the game isn't over...
        if(!treasureGame.isGameOver())
        {
            // update lastMoveText field
            lastMoveTextField.setText("Last Move: Troll!");
        } // end of if-statement
    }

    // Purpose: Call the endGame method, disable all enabled buttons and show all remaining TreasureButtons
    public void endGame()
    {
        // If the game is over...
        if (treasureGame.isGameOver())
        {
            // if there are treasures left...
            if (treasureGame.getNumberOfTreasuresLeft() > 0)
            {
                // Tell player they ran out of tries
                lastMoveTextField.setText("Game Over - All Out Of Tries!");
            }
            else
            {
                // Tell player they found all of the treasures
                lastMoveTextField.setText("Game Over - All Treasures Uncovered!");
            }
            // loop to show the the text behind and disable all remaining enabled buttons
            for (int index = 0; index < buttonGrid.length; index++)
            {
                // create an EmptyButton to assign the buttonGrid[index] to
                EmptyButton button = buttonGrid[index];
                if (button.getButtonStatus())
                {
                    // Set the current button text to string returned by the current button's revealButtonText() method
                    button.setIcon(button.revealIcon());
                    // set button border
                    button.setBorder(BorderFactory.createLineBorder(button.revealBorder(), 2));
                }
            }
        }
    }

    // Purpose: Create a TreasureGame and TreasureGameView
    public static void play()
    {
        TreasureGame treasureGame = new TreasureGame();
        TreasureGameView treasureGameView = new TreasureGameView(treasureGame);
    }

    // Purpose: Call the play method
    public static void main(String[] args)
    {
        TreasureGameView.play();
    }
}