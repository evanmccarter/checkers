import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel
{
	private int count;
	
   private JButton decrement, increment;
   private JLabel label;
   private JPanel buttonPanel;
   
   //-----------------------------------------------------------------
   //  Constructor: Sets up the GUI.
   //-----------------------------------------------------------------
   public Panel ()
   {
	  count = 50;
	  
      decrement = new JButton ("decrement");
      increment = new JButton ("increment");

      DecrementListener listenerd = new DecrementListener();
      IncrementListener listeneri = new IncrementListener();
      
      decrement.addActionListener (listenerd);
      increment.addActionListener (listeneri);

      label = new JLabel (Integer.toString(count));

      buttonPanel = new JPanel();
      buttonPanel.setPreferredSize (new Dimension(500, 40));
      buttonPanel.setBackground (Color.blue);
      buttonPanel.add (decrement);
      buttonPanel.add (increment);

      setPreferredSize (new Dimension(1000, 80));
      setBackground (Color.cyan);
      add (label);
      add (buttonPanel);
   }
   
   private class DecrementListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
        	count--;
            label.setText(Integer.toString(count));
            
            return;
      }
   }
   
   private class IncrementListener implements ActionListener
   {
      public void actionPerformed (ActionEvent event)
      {
    	  count++;
          label.setText(Integer.toString(count));
      }
   }
}