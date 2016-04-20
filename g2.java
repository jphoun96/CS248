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

public class g2 extends JFrame
{
	public static void main(String [] args)
	{
		g2 thing=new g2();
		thing.addWindowListener( new Astronaut() );
		thing.setTitle("G2: our program with a window!");
		thing.setVisible(true);
	}
}