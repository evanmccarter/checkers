import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel
{
	Dog dogs[] = new Dog[10];
	
	private JPanel buttonPanel, indexPanel, namePanel, agePanel;
	private JTextField indexText, nameText, ageText;
	private JButton checkIn, checkOut, getInfo, changeName, changeAge, average;
	private JLabel indexLabel, nameLabel, ageLabel, output;
	
	//-----------------------------------------------------------------
	//  Constructor: Sets up the GUI.
	//-----------------------------------------------------------------
	public Panel ()
	{
		//instantiate objects
		
		indexPanel = new JPanel();
		namePanel = new JPanel();
		agePanel = new JPanel();
		buttonPanel = new JPanel();
		
		indexText = new JTextField(20);
		nameText = new JTextField(20);
		ageText = new JTextField(20);
		
		checkIn = new JButton ("check in");
		checkOut = new JButton ("check out");
		getInfo = new JButton ("get info");
		changeName = new JButton ("change name");
		changeAge = new JButton ("change age");
		average = new JButton ("average age");
		
		indexLabel = new JLabel("dog index");
		nameLabel = new JLabel("dog name");
		ageLabel = new JLabel("dog age");
		output = new JLabel();
		
		InListener inlistener = new InListener();
		OutListener outlistener = new OutListener();
		InfoListener infolistener = new InfoListener();
		NameListener namelistener = new NameListener();
		AgeListener agelistener = new AgeListener();
		AverageListener averagelistener = new AverageListener();
		
		
		//set up listeners
		
		checkIn.addActionListener(inlistener);
		checkOut.addActionListener(outlistener);
		getInfo.addActionListener(infolistener);
		changeName.addActionListener(namelistener);
		changeAge.addActionListener(agelistener);
		average.addActionListener(averagelistener);
		
		
		//set up layout
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		indexPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		namePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		agePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		output.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		//miscellaneous setup
		
		setBackground (Color.white);
		indexPanel.setBackground (Color.red);
		namePanel.setBackground (Color.orange);
		agePanel.setBackground (Color.yellow);
		buttonPanel.setBackground (Color.green);
		
		
		//add objects to panels
		
		indexPanel.add(indexLabel);
		indexPanel.add(indexText);
		
		namePanel.add(nameLabel);
		namePanel.add(nameText);
		
		agePanel.add(ageLabel);
		agePanel.add(ageText);
		
		buttonPanel.add(checkIn);
		buttonPanel.add(checkOut);
		buttonPanel.add(getInfo);
		//buttonPanel.add(changeName);
		//buttonPanel.add(changeAge);
		buttonPanel.add(average);
		
		add(indexPanel);
		add(namePanel);
		add(agePanel);
		add(buttonPanel);
		add(output);
	}
	

	public void checkIn(int n, String name, int age)
	{
		dogs[n] = new Dog(age, name);
	}
	
	public void checkOut(int n)
	{
		dogs[n] = null;
	}
	
	public String dogString(int n)
	{
		return dogs[n].toString();
	}
	
	private class InListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			checkIn(Integer.parseInt(indexText.getText()), nameText.getText(), Integer.parseInt(ageText.getText()));
			
			return;
		}
	}
	
	private class OutListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			checkOut(Integer.parseInt(indexText.getText()));
			
			return;
		}
	}
	
	private class InfoListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			int number = Integer.parseInt(indexText.getText());
			
			if (dogs[number] != null)
			{
				output.setText(dogString(Integer.parseInt(indexText.getText())));
			}
			else
			{
				output.setText("that dog doesn't exist!");
			}
			
			return;
		}
	}
	
	private class NameListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			//TODO do stuff
			
			return;
		}
	}
	
	private class AgeListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			//TODO do stuff
			
			return;
		}
	}
	
	private class AverageListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			int total = 0;
			int number = 0;
			
			for(int i = 0; i < dogs.length; i++)
			{
				if (dogs[i] != null)
				{
					number++;
					total += dogs[i].getAge();
				}
			}
			
			try
			{
			output.setText(Integer.toString(total/number));
			}
			catch(Exception e)
			{
				output.setText("an error occured");
			}
			
			return;
		}
	}
}