import java.util.Scanner;

import javax.swing.JFrame;

public class Kennel
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame ("kennel");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	      frame.getContentPane().add(new Panel());

	      frame.pack();
	      frame.setVisible(true);
	}
}