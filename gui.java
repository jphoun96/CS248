import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class gui extends JFrame
{
	private static JButton[] cells;
	private CellButtonHandler[] cellHandlers;
	
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
	
	public gui()
	{
		addWindowListener( new window() );
		setTitle("Jerry Tic-Tac-Toe");
		//size of window
		setSize(900,600);
		Container stuff=getContentPane();
		stuff.setLayout( new BorderLayout());
		r=new Picture();
		stuff.add(r, "Center" );
		setVisible(true);
		
		cells = new JButton[9];
		cellHandlers = new CellButtonHandler[9];
		for(int i = 0; i < 9; i++)
		{
			cells[i] = new JButton("");
			cellHandlers[i] = new CellButtonHandler();
			cells[i].addActionListener(cellHandlers[i]);
		}
		
		for(int i = 0; i < 9; i++)
		{
			add(cells[i]);
			cells[i].setHorizontalTextPosition(SwingConstants.CENTER);
			cells[i].setOpaque(false);
			cells[i].setContentAreaFilled(false);
			cells[i].setBorderPainted(false);
		}
		
		cells[0].setBounds(100,100,100,100);
	}

	public static void main(String [] args)
	{
		gui thing = new gui();
	}
}