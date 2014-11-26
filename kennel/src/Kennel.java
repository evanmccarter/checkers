import java.util.Scanner;

import javax.swing.JFrame;

public class Kennel
{
	Dog dogs[] = new Dog[10];
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame ("Left Right");
	      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	      frame.getContentPane().add(new Panel());

	      frame.pack();
	      frame.setVisible(true);
	}
	
	public void checkIn(int n)
	{
		Scanner s = new Scanner(System.in);
		
		int age;
		String name;
		
		System.out.print("enter an age: ");
		age = s.nextInt();
		
		System.out.print("enter a name: ");
		name = s.next();
		
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
}