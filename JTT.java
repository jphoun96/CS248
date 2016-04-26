import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class JTT extends JFrame
{
	private static JButton[] cells;
	
	class window extends WindowAdapter
	{
		public void Closing(WindowEvent e)
		{
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
	}

	class Picture extends JPanel
	{
		//set size of background
		public Picture()
		{
			setSize(900,700);
			//setLayout(new BorderLayout());
		    //setContentPane(new JLabel(new ImageIcon("back2.png")));
			//setLayout(null);
		}

		//set color of background
		public void paintComponent(Graphics g)
		{

			g.setColor(Color.white);
			g.fillRect(0,0,900,700);

			g.setColor(Color.white);
			g.fillRect(225,550,90,90);

			g.setColor(Color.white);
			g.fillRect(550,550,90,90);


		}
		
	}

	Picture r;
	

	public JTT()
	{
		addWindowListener( new window() );
		setTitle("Jerry-Tac-Toe");
		//size of window
		setSize(900,700);
				
		cells = new JButton[9];

		for(int i=0; i<9; i++)
			{
				cells[i] = new JButton("something awesome", null );
				add(cells[i]);
				cells[i].setBackground(Color.BLUE);
				cells[i].setOpaque(true);	
			}
				
		cells[0].setBounds(50,25,88,88);
		cells[1].setBounds(400,25,88,88);
		cells[2].setBounds(750,25,88,88);
		cells[3].setBounds(200,225,88,88);
		cells[4].setBounds(400,225,88,88);
		cells[5].setBounds(600,225,88,88);
		cells[6].setBounds(50,400,88,88);
		cells[7].setBounds(400,400,88,88);
		cells[8].setBounds(750,400,88,88);

		
		Container stuff=getContentPane();
		stuff.setLayout( new BorderLayout());
		r = new Picture();
		stuff.add(r, "Center" );
		
		setVisible(true);
		
		initialize();
	}

	public void initialize()
	{
		for (int i = 0; i < 9; i++) 
		{
			char ch = (char) ('0' + i + 1);
			cells[i].setText("" + ch);
			//cells[i].setIcon(neutralIcon);
		}

	}
	
	public static void main(String [] args)
	{
		JTT thing = new JTT();
	}

}
