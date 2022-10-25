// Importing the java swing package
import javax.swing.*;

// Importing the java awt package
import java.awt.*;

// Importing the java awt event package
import java.awt.event.*;

// Importing the java sql package
import java.sql.*;

public class MenuBar extends JFrame implements  ActionListener
{
  // Creating frame, menubar, menu, and menu items
  JFrame frame = new JFrame("MENU OPTIONS");
  JMenuBar menuBar = new JMenuBar();
  JMenu menu = new JMenu("Click here to Exit");
  JMenuItem exitOption = new JMenuItem("Exit");

  // Creating JLabels to hold instructions
  JLabel label0 = new JLabel ("Here is your menu of choices:", SwingConstants.CENTER);
  JLabel label1 = new JLabel ("1 - Enter released media that you’re interested in", SwingConstants.CENTER);
  JLabel label2 = new JLabel ("2 - Enter upcoming release that you’re interested in", SwingConstants.CENTER);
  JLabel label3 = new JLabel ("3 - Get recommendations of media to watch based off of genre", SwingConstants.CENTER);
  JLabel label4 = new JLabel ("4 - Get a randomized recommendation from your database");
  JLabel label5 = new JLabel ("5 - Enter opinion on a piece of media", SwingConstants.CENTER);
  JLabel label6 = new JLabel ("6 - See your ranking of media you’ve watched", SwingConstants.CENTER);
  JLabel label7 = new JLabel ("7 - Reminder of upcoming releases", SwingConstants.CENTER);
  JLabel label8 = new JLabel ("8 - View your database of released media", SwingConstants.CENTER);
  JLabel label9 = new JLabel ("9 - View your database of upcoming releases", SwingConstants.CENTER);
  JLabel label10 = new JLabel ("", SwingConstants.CENTER);

  // Creating a constructor
  MenuBar()
  {
    label0.setBounds(7, 0, 600, 50);
    label1.setBounds(7, 25, 600, 50);
    label2.setBounds(7, 50, 600, 50);
    label3.setBounds(7, 75, 600, 50);
    label4.setBounds(7, 100, 600, 50);
    label5.setBounds(7, 125, 600, 50);
    label6.setBounds(7, 150, 600, 50);
    label7.setBounds(7, 175, 600, 50);
    label8.setBounds(7, 200, 600, 50);
    label9.setBounds(7, 225, 600, 50);
    label10.setBounds(7, 250, 600, 50);
    
    // Setting the default close operation of the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Setting the size of the frame
    frame.setSize(600, 420);

    // Adding the labels to the frame
    frame.add(label0);
    frame.add(label1);
    frame.add(label2);
    frame.add(label3);
    frame.add(label4);
    frame.add(label5);
    frame.add(label6);
    frame.add(label7);
    frame.add(label8);
    frame.add(label9);
    frame.add(label10);

    // Setting the frame to visible
    frame.setVisible(true);
    
    // Adding menubar to frame
    frame.setJMenuBar(menuBar);

    // Adding action listeners to choices, adding choices to menu
    exitOption.addActionListener(this);
    menu.add(exitOption);

    menuBar.add(menu);
  }

  @Override 
  public void actionPerformed(ActionEvent e)
  {
    // Condition to check if the exit option is clicked
    if (e.getSource().equals(exitOption))
    {
      // Outputting a blank line
      System.out.println();

      // Outputting a message to the user
      System.out.println("Thank you for using our program! Goodbye!");

      // Exiting the program
      System.exit(0); 
    }
  }    
}