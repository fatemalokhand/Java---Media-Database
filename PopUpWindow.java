// Importing the java swing package
import javax.swing.*;

// Importing the java awt package
import java.awt.*;

// Importing the java awt event package
import java.awt.event.*;

// Importing the java sql package
import java.sql.*;

// Declaring a class called PopUpWindow
public class PopUpWindow implements ActionListener
{
  // Creating a frame with a title
  JFrame frame = new JFrame("PERSONAL TV/MOVIE DATABASE");

  // Creating labels which contain the instructions for our program
  JLabel label = new JLabel("This is a program where you can", SwingConstants.CENTER);
  JLabel label1 = new JLabel("create a database of media you’re", SwingConstants.CENTER);
  JLabel label2 = new JLabel("interested in, get recommendations,", SwingConstants.CENTER);
  JLabel label3 = new JLabel("and more. Thank you and enjoy!", SwingConstants.CENTER);

  // Creating a button 
  JButton button = new JButton("NEXT");
  
  // Creating a constructor
  PopUpWindow()
  {
    // Positioning and setting the size and font of the labels
    label.setBounds(7, 0, 400, 50);
    label.setFont(new Font(null, Font.PLAIN, 22));
    label1.setBounds(7, 32, 400, 50);
    label1.setFont(new Font(null, Font.PLAIN, 22));
    label2.setBounds(7, 64, 400, 50);
    label2.setFont(new Font(null, Font.PLAIN, 22));
    label3.setBounds(7, 96, 400, 50);
    label3.setFont(new Font(null, Font.PLAIN, 22));

    // Positioning and setting the size of the button
    button.setBounds(110, 200, 200, 100);

    // Setting the font of the button
    button.setFont(new Font(null, Font.PLAIN, 22));

    // Setting the focusable of the button 
    button.setFocusable(false);

    // Adding the action listener to the button
    button.addActionListener(this);

    // Adding the labels and button to the frame
    frame.add(label);
    frame.add(label1);
    frame.add(label2);
    frame.add(label3);
    frame.add(button);

    // Setting the font of the frame text
    frame.setFont(new Font(null, Font.BOLD, 25));

    // Setting the default close operation of the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Setting the size of the frame
    frame.setSize(420, 420);

    // Setting the layout of the frame
    frame.setLayout(null);

    // Setting the frame to visible
    frame.setVisible(true);
  }

  @Override 
  public void actionPerformed(ActionEvent e)
  {
    // Condition to check if the button is clicked
    if(e.getSource() == button)
    {
      // Disposing the frame 
      frame.dispose();

      // Instantiating an object of class MenuBar
      MenuBar mB = new MenuBar();

      // Prompting the user to enter their choice 
      System.out.println("Please enter your choice (Please enter an integer between 1-9):");
    }
  }
}