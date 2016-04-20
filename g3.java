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

public class g3 extends JFrame
{
	public g3()
	{
		addWindowListener( new Astronaut() );
		setTitle("G2: our program with a window!");
		
		setSize(500,500);
		
		Container stuff=getContentPane();
		stuff.add( new JLabel("Hi Class!") );
		
		
		setVisible(true);
	}
	
	public static void main(String [] args)
	{
		g3 thing=new g3();
		
	}
}