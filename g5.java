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

public class g5 extends JFrame
	implements ActionListener
{
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b)
		{
			c.setText("Press Me!");
			b.setText("Thanks.");
		}
		else
		{
			b.setText("Press Me!");
			c.setText("Thanks.");			
		}
		count++;
		t.setText("Count="+count);
		
	}
	
	JButton b;
	JButton c;
	JTextField t;
	int count;
	
	public g5()
	{
		addWindowListener( new Astronaut() );
		setTitle("G5: our program with a window!");
		
		setSize(500,500);
		count=0;
		
		b=new JButton("Left");
		// this is a self-reference to the g5 object
		b.addActionListener(this);
		
		c=new JButton("Right");
		c.addActionListener(this);
		
		t=new JTextField("Some text here.");
		
		Container stuff=getContentPane();
		
		stuff.setLayout( new BorderLayout());
		
		stuff.add( new JLabel("Hi Class!"), "North" );
		stuff.add( new JLabel("The Eagle has landed!"),"South");
		stuff.add( b, "West");
		stuff.add( c, "East");
		JPanel p=new JPanel();
		p.add(t);
		stuff.add( p, "Center");
		
		setVisible(true);
	}
	
	public static void main(String [] args)
	{
		g5 thing=new g5();
		
	}
}