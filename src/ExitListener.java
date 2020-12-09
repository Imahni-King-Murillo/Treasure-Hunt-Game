import javax.swing.*;
import java.awt.event.*;

public class ExitListener implements ActionListener
{
    // Exit from game whenever this listener is called
    public void actionPerformed (ActionEvent e)
    {
        System.exit(0);
    }
}
