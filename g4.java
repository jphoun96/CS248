import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class Astronaut extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.out.println("Goodbye!");
		System.exit(0);
	}
}

public class g4 extends JFrame
{
	public g4()
	{
		addWindowListener( new Astronaut() );
		setTitle("G4: our program with a window!");
		
		setSize(500,500);
		
		Container stuff=getContentPane();
		
		stuff.setLayout( new BorderLayout());
		
		stuff.add( new JLabel("Hi Class!"), "North" );
		stuff.add( new JLabel("The Eagle has landed!"),"South");
		stuff.add( new JButton("Left"), "West");
		stuff.add( new JButton("Right"), "East");
		stuff.add( new JLabel("What"), "Center");
		
		setVisible(true);
	}
	
	public static void main(String [] args)
	{
		g4 thing=new g4();
		
	}
}