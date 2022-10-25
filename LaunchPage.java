// Importing the java swing package
import javax.swing.*;

// Importing the java awt package
import java.awt.*;

// Importing the java awt event package
import java.awt.event.*;

// Declaring a class called LaunchPage
public class LaunchPage implements ActionListener
{
  // Creating a frame with a title
  JFrame frame = new JFrame("PERSONAL TV/MOVIE DATABASE");

  // Creating a button 
  JButton button = new JButton();

  // Creating a constructor
  LaunchPage()
  {
    // Adding image on the button
    button.setIcon(new ImageIcon("Start Image.png"));

    // Positioning and setting the size of the button
    button.setBounds(26, 43, 560, 160);

    // Setting the focusable of the button  
    button.setFocusable(false);

    // Adding the action listener to the button
    button.addActionListener(this);

    // Setting the size of the frame
    frame.setSize(610, 280);

    // Setting the layout of the frame
    frame.setLayout(null);

    // Adding the button to the frame
    frame.add(button);

    // Setting the font of the frame text
    frame.setFont(new Font(null, Font.BOLD, 25));
    
    // Setting the default close operation of the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Setting the location of the frame
    frame.setLocationRelativeTo(null);

    // Setting the frame to visible
    frame.setVisible(true);

    // Outputting a blank line
    System.out.println();

    // Informing the user that they need to click the start button in order to proceed
    System.out.println("Press the START button when you are ready to begin.");
  }

  @Override 
  public void actionPerformed(ActionEvent e)
  {
    // Condition to check if the button is clicked
    if(e.getSource() == button)
    {
      // Disposing the frame 
      frame.dispose();

      // Instantiating an object of class PopUpWindow
      PopUpWindow puw = new PopUpWindow();
    }
  }
}