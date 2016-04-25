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
				(int)(1.0*size),(int)(1.0*size));
		}
	}

	Button [] cells;

	class Picture extends JPanel
	{
		//set size of background
		public Picture()
		{
			setSize(900,700);
			//setLayout(new BorderLayout());
			//setContentPane(new JLabel(new ImageIcon("back.png")));
			//setLayout(null);
		}

		//set color of background
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.white);
			g.fillRect(0,0,900,700);
			
			g.setColor(Color.green);
			g.fillRect(225,550,90,90);
			
			g.setColor(Color.green);
			g.fillRect(550,550,90,90);
			
			
			for(int i=0; i<9; i++)
			{
				cells[i].drawme(g);
			}
		}
	}

	Picture r;

	public JTT()
	{
		addWindowListener( new window() );
		setTitle("Jerry-Tac-Toe");
		//size of window
		setSize(900,700);
		
		cells= new Button[9];
		
		cells[0]= new Button(
		50,25,85,Color.blue);

		cells[1]= new Button(
		400,25,85,Color.blue);

		cells[2]= new Button(
		750,25,85,Color.blue);

		cells[3]= new Button(
		200,225,85,Color.blue);

		cells[4]= new Button(
		400,225,85,Color.blue);

		cells[5]= new Button(
		600,225,85,Color.blue);

		cells[6]= new Button(
		50,400,85,Color.blue);

		cells[7]= new Button(
		400,400,85,Color.blue);

		cells[8]= new Button(
		750,400,85,Color.blue);


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
