import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class JTT extends JFrame
{
	class window extends WindowAdapter
	{
		public void Closing(WindowEvent e)
		{
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
	}

	class Button
	{
		int x, y;
		int size;
		Color color;

		public Button(int xpos, int ypos, int s, Color c)
		{
			x=xpos; y=ypos; color=c;
			size=s;
		}

		public void colorme(Color c)
		{
			color=c;
		}

		public void drawme(Graphics g)
		{
			g.setColor(Color.blue);
			g.fillOval(x,
				(int)(y+0.05*size),
				(int)(1.5*size),(int)(1.5*size));
		}
	}

	Button [] cells;

	class Picture extends JPanel
	{
		//set size of background
		public Picture()
		{
			setSize(900,600);
		}

		//set color of background
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0,0,900,600);
		}
	}

	Picture r;

	public JTT()
	{
		addWindowListener( new window() );
		setTitle("Jerry-Tac-Toe");
		//size of window
		setSize(900,600);

		cells=new Button[9];
		for(int i=0; i<9; i++)
		{
			cells[i]=new Button(


		}

		Container stuff=getContentPane();
		stuff.setLayout( new BorderLayout());
		r=new Picture();
		stuff.add(r, "Center" );

		setVisible(true);
	}

	public static void main(String [] args)
	{
		JTT thing = new JTT();
	}

}
