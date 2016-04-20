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

public class g6 extends JFrame
	implements ActionListener
{
	class Picture extends JPanel
	{
		public Picture()
		{  setSize(200,200); }
		
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.blue);
			g.fillRect(0,0,200,200);
			if(count%2==0)
				g.setColor(Color.red);
			else
				g.setColor(Color.yellow);
			g.fillRect(50+count,50+count,100,100);
		}
	}
	
	
	
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
		
		r.repaint();
		
	}
	
	JButton b;
	JButton c;
	JTextField t;
	int count;
	Picture r;
	
	public g6()
	{
		addWindowListener( new Astronaut() );
		setTitle("G6: our program with a window!");
		
		setSize(600,600);
		count=0;
		
		b=new JButton("Left");
		// this is a self-reference to the g6 object
		b.addActionListener(this);
		
		c=new JButton("Right");
		c.addActionListener(this);
		
		t=new JTextField("Some text here.");
		
		Container stuff=getContentPane();
		
		stuff.setLayout( new BorderLayout());
		
		//JPanel q=new JPanel();
		//q.add( new Picture());
		r=new Picture();
		stuff.add(r, "Center" );
		stuff.add( new JLabel("The Eagle has landed!"),"South");
		stuff.add( b, "West");
		stuff.add( c, "East");
		JPanel p=new JPanel();
		p.add(t);
		stuff.add( p, "North");
		
		setVisible(true);
	}
	
	public static void main(String [] args)
	{
		g6 thing=new g6();
		
	}
}