import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class JTT extends JFrame
{
	private static JButton[] cells;
	private static boolean noughts;
	private boolean gameOver;
	private ImageIcon neutralIcon = new ImageIcon("unpressed.png");
	private ImageIcon noughtIcon = new ImageIcon("xpressed.png");
	private ImageIcon crossIcon = new ImageIcon("opressed.png");
	
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

			g.setColor(Color.green);
			g.fillRect(225,550,90,90);

			g.setColor(Color.green);
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
		noughts = true;
		gameOver = false;
		
		for (int i = 0; i < 9; i++)
		{
			char ch = (char) ('0' + i + 1);
			cells[i].setText("" + ch);
			//cells[i].setIcon(neutralIcon);
		}

		promptUser();

		setVisible(true);

	}

	public static void cpumove()
	{
		// offensive completion
		if ((cells[0].getText().equals("X") && cells[0].getText().equals(cells[1].getText()))
				&& cells[2].getText().equals("3")) {
			cells[2].doClick();
		} else if ((cells[0].getText().equals("X") && cells[0].getText().equals(cells[2].getText()))
				&& cells[1].getText().equals("2")) {
			cells[1].doClick();
		} else if ((cells[1].getText().equals("X") && cells[1].getText().equals(cells[2].getText()))
				&& cells[0].getText().equals("1")) {
			cells[0].doClick();
		}

		else if ((cells[0].getText().equals("X") && cells[0].getText().equals(cells[4].getText()))
				&& cells[8].getText().equals("9")) {
			cells[8].doClick();
		} else if ((cells[0].getText().equals("X") && cells[0].getText().equals(cells[8].getText()))
				&& cells[4].getText().equals("5")) {
			cells[4].doClick();
		} else if ((cells[4].getText().equals("X") && cells[4].getText().equals(cells[8].getText()))
				&& cells[0].getText().equals("1")) {
			cells[0].doClick();
		}

		else if ((cells[0].getText().equals("X") && cells[0].getText().equals(cells[3].getText()))
				&& cells[7].getText().equals("8")) {
			cells[7].doClick();
		} else if ((cells[0].getText().equals("X") && cells[0].getText().equals(cells[7].getText()))
				&& cells[3].getText().equals("4")) {
			cells[3].doClick();
		} else if ((cells[3].getText().equals("X") && cells[3].getText().equals(cells[7].getText()))
				&& cells[0].getText().equals("1")) {
			cells[0].doClick();
		}

		else if ((cells[1].getText().equals("X") && cells[1].getText().equals(cells[3].getText()))
				&& cells[6].getText().equals("7")) {
			cells[6].doClick();
		} else if ((cells[1].getText().equals("X") && cells[1].getText().equals(cells[6].getText()))
				&& cells[3].getText().equals("4")) {
			cells[3].doClick();
		} else if ((cells[3].getText().equals("X") && cells[3].getText().equals(cells[6].getText()))
				&& cells[1].getText().equals("2")) {
			cells[1].doClick();
		}

		else if ((cells[1].getText().equals("X") && cells[1].getText().equals(cells[5].getText()))
				&& cells[8].getText().equals("9")) {
			cells[8].doClick();
		} else if ((cells[1].getText().equals("X") && cells[1].getText().equals(cells[8].getText()))
				&& cells[5].getText().equals("6")) {
			cells[5].doClick();
		} else if ((cells[5].getText().equals("X") && cells[5].getText().equals(cells[8].getText()))
				&& cells[1].getText().equals("2")) {
			cells[1].doClick();
		}

		else if ((cells[2].getText().equals("X") && cells[2].getText().equals(cells[4].getText()))
				&& cells[6].getText().equals("7")) {
			cells[6].doClick();
		} else if ((cells[2].getText().equals("X") && cells[2].getText().equals(cells[6].getText()))
				&& cells[4].getText().equals("5")) {
			cells[4].doClick();
		} else if ((cells[4].getText().equals("X") && cells[4].getText().equals(cells[6].getText()))
				&& cells[2].getText().equals("3")) {
			cells[2].doClick();
		}

		else if ((cells[2].getText().equals("X") && cells[2].getText().equals(cells[5].getText()))
				&& cells[7].getText().equals("8")) {
			cells[7].doClick();
		} else if ((cells[2].getText().equals("X") && cells[2].getText().equals(cells[7].getText()))
				&& cells[5].getText().equals("6")) {
			cells[5].doClick();
		} else if ((cells[5].getText().equals("X") && cells[5].getText().equals(cells[7].getText()))
				&& cells[2].getText().equals("3")) {
			cells[2].doClick();
		}

		else if ((cells[3].getText().equals("X") && cells[3].getText().equals(cells[4].getText()))
				&& cells[5].getText().equals("6")) {
			cells[5].doClick();
		} else if ((cells[3].getText().equals("X") && cells[3].getText().equals(cells[5].getText()))
				&& cells[4].getText().equals("5")) {
			cells[4].doClick();
		} else if ((cells[4].getText().equals("X") && cells[4].getText().equals(cells[5].getText()))
				&& cells[3].getText().equals("4")) {
			cells[3].doClick();
		}

		else if ((cells[6].getText().equals("X") && cells[6].getText().equals(cells[7].getText()))
				&& cells[8].getText().equals("9")) {
			cells[8].doClick();
		} else if ((cells[6].getText().equals("X") && cells[6].getText().equals(cells[8].getText()))
				&& cells[7].getText().equals("8")) {
			cells[7].doClick();
		} else if ((cells[7].getText().equals("X") && cells[7].getText().equals(cells[8].getText()))
				&& cells[6].getText().equals("7")) {
			cells[6].doClick();
		}

		// defensive blocking
		else if ((cells[0].getText().equals("O") && cells[0].getText().equals(cells[1].getText()))
				&& cells[2].getText().equals("3")) {
			cells[2].doClick();
		} else if ((cells[0].getText().equals("O") && cells[0].getText().equals(cells[2].getText()))
				&& cells[1].getText().equals("2")) {
			cells[1].doClick();
		} else if ((cells[1].getText().equals("O") && cells[1].getText().equals(cells[2].getText()))
				&& cells[0].getText().equals("1")) {
			cells[0].doClick();
		}

		else if ((cells[0].getText().equals("O") && cells[0].getText().equals(cells[4].getText()))
				&& cells[8].getText().equals("9")) {
			cells[8].doClick();
		} else if ((cells[0].getText().equals("O") && cells[0].getText().equals(cells[8].getText()))
				&& cells[4].getText().equals("5")) {
			cells[4].doClick();
		} else if ((cells[4].getText().equals("O") && cells[4].getText().equals(cells[8].getText()))
				&& cells[0].getText().equals("1")) {
			cells[0].doClick();
		}

		else if ((cells[0].getText().equals("O") && cells[0].getText().equals(cells[3].getText()))
				&& cells[7].getText().equals("8")) {
			cells[7].doClick();
		} else if ((cells[0].getText().equals("O") && cells[0].getText().equals(cells[7].getText()))
				&& cells[3].getText().equals("4")) {
			cells[3].doClick();
		} else if ((cells[3].getText().equals("O") && cells[3].getText().equals(cells[7].getText()))
				&& cells[0].getText().equals("1")) {
			cells[0].doClick();
		}

		else if ((cells[1].getText().equals("O") && cells[1].getText().equals(cells[3].getText()))
				&& cells[6].getText().equals("7")) {
			cells[6].doClick();
		} else if ((cells[1].getText().equals("O") && cells[1].getText().equals(cells[6].getText()))
				&& cells[3].getText().equals("4")) {
			cells[3].doClick();
		} else if ((cells[3].getText().equals("O") && cells[3].getText().equals(cells[6].getText()))
				&& cells[1].getText().equals("2")) {
			cells[1].doClick();
		}

		else if ((cells[1].getText().equals("O") && cells[1].getText().equals(cells[5].getText()))
				&& cells[8].getText().equals("9")) {
			cells[8].doClick();
		} else if ((cells[1].getText().equals("O") && cells[1].getText().equals(cells[8].getText()))
				&& cells[5].getText().equals("6")) {
			cells[5].doClick();
		} else if ((cells[5].getText().equals("O") && cells[5].getText().equals(cells[8].getText()))
				&& cells[1].getText().equals("2")) {
			cells[1].doClick();
		}

		else if ((cells[2].getText().equals("O") && cells[2].getText().equals(cells[4].getText()))
				&& cells[6].getText().equals("7")) {
			cells[6].doClick();
		} else if ((cells[2].getText().equals("O") && cells[2].getText().equals(cells[6].getText()))
				&& cells[4].getText().equals("5")) {
			cells[4].doClick();
		} else if ((cells[4].getText().equals("O") && cells[4].getText().equals(cells[6].getText()))
				&& cells[2].getText().equals("3")) {
			cells[2].doClick();
		}

		else if ((cells[2].getText().equals("O") && cells[2].getText().equals(cells[5].getText()))
				&& cells[7].getText().equals("8")) {
			cells[7].doClick();
		} else if ((cells[2].getText().equals("O") && cells[2].getText().equals(cells[7].getText()))
				&& cells[5].getText().equals("6")) {
			cells[5].doClick();
		} else if ((cells[5].getText().equals("O") && cells[5].getText().equals(cells[7].getText()))
				&& cells[2].getText().equals("3")) {
			cells[2].doClick();
		}

		else if ((cells[3].getText().equals("O") && cells[3].getText().equals(cells[4].getText()))
				&& cells[5].getText().equals("6")) {
			cells[5].doClick();
		} else if ((cells[3].getText().equals("O") && cells[3].getText().equals(cells[5].getText()))
				&& cells[4].getText().equals("5")) {
			cells[4].doClick();
		} else if ((cells[4].getText().equals("O") && cells[4].getText().equals(cells[5].getText()))
				&& cells[3].getText().equals("4")) {
			cells[3].doClick();
		}

		else if ((cells[6].getText().equals("O") && cells[6].getText().equals(cells[7].getText()))
				&& cells[8].getText().equals("9")) {
			cells[8].doClick();
		} else if ((cells[6].getText().equals("O") && cells[6].getText().equals(cells[8].getText()))
				&& cells[7].getText().equals("8")) {
			cells[7].doClick();
		} else if ((cells[7].getText().equals("O") && cells[7].getText().equals(cells[8].getText()))
				&& cells[6].getText().equals("7")) {
			cells[6].doClick();
		}

		// specific cases to prevent losing
		else if (cells[4].getText().equals("X") && cells[8].getText().equals("O") && cells[3].getText().equals("4")) {
			cells[3].doClick();
		} else if (cells[4].getText().equals("X") && cells[6].getText().equals("O") && cells[5].getText().equals("6")) {
			cells[5].doClick();
		}

		// first move based on location of user's move
		else if ((cells[0].getText().equals("O") || (cells[6].getText().equals("O"))) && cells[3].getText().equals("4")) {
			cells[3].doClick();
		} else if ((cells[2].getText().equals("O") || (cells[8].getText().equals("O"))) && cells[5].getText().equals("6")) {
			cells[5].doClick();
		} else if ((cells[1].getText().equals("O") || (cells[7].getText().equals("O"))) && cells[5].getText().equals("6")) {
			cells[5].doClick();
		} else if ((cells[3].getText().equals("O") || (cells[5].getText().equals("O"))) && cells[4].getText().equals("5")) {
			cells[4].doClick();
		} else if (cells[4].getText().equals("O") && cells[3].getText().equals("4")) {
			cells[3].doClick();
		}

		// prevents stupid moves
		else if (cells[0].getText().equals("1")) {
			cells[0].doClick();
		} else if ((cells[0].getText().equals("1") || cells[0].getText().equals("X")) && (cells[1].getText().equals("2") || cells[1].getText().equals("X")) && (cells[2].getText().equals("3"))) {
			cells[2].doClick();
		} else if ((cells[0].getText().equals("1") || cells[0].getText().equals("X")) && (cells[4].getText().equals("5")) && (cells[8].getText().equals("9") || cells[8].getText().equals("X"))) {
			cells[4].doClick();
		} else if ((cells[0].getText().equals("1") || cells[0].getText().equals("X")) && (cells[3].getText().equals("4")) && (cells[7].getText().equals("8") || cells[7].getText().equals("X"))) {
			cells[3].doClick();
		} else if ((cells[1].getText().equals("2") || cells[1].getText().equals("X")) && (cells[3].getText().equals("4")) && (cells[6].getText().equals("7") || cells[6].getText().equals("X"))) {
			cells[3].doClick();
		} else if ((cells[1].getText().equals("2") || cells[1].getText().equals("X")) && (cells[5].getText().equals("6")) && (cells[8].getText().equals("9") || cells[8].getText().equals("X"))) {
			cells[5].doClick();
		} else if ((cells[2].getText().equals("3") || cells[2].getText().equals("X")) && (cells[4].getText().equals("5")) && (cells[6].getText().equals("7") || cells[6].getText().equals("X"))) {
			cells[4].doClick();
		} else if ((cells[2].getText().equals("3") || cells[2].getText().equals("X")) && (cells[5].getText().equals("6")) && (cells[7].getText().equals("8") || cells[7].getText().equals("X"))) {
			cells[5].doClick();
		} else if ((cells[3].getText().equals("4") || cells[3].getText().equals("X")) && (cells[4].getText().equals("5")) && (cells[5].getText().equals("6") || cells[5].getText().equals("X"))) {
			cells[4].doClick();
		} else if ((cells[6].getText().equals("7") || cells[6].getText().equals("X")) && (cells[7].getText().equals("8")) && (cells[8].getText().equals("9") || cells[8].getText().equals("X"))) {
			cells[7].doClick();
		}

		// if nothing else move to an empty spot
		else if (cells[4].getText().equals("5")) {
			cells[4].doClick();
		} else if (cells[1].getText().equals("2")) {
			cells[1].doClick();
		} else if (cells[2].getText().equals("3")) {
			cells[2].doClick();
		} else if (cells[5].getText().equals("6")) {
			cells[5].doClick();
		} else if (cells[6].getText().equals("7")) {
			cells[6].doClick();
		} else if (cells[7].getText().equals("8")) {
			cells[7].doClick();
		} else if (cells[8].getText().equals("9")) {
			cells[8].doClick();
		}
	}
	
	public static void promptUser()
	// asks for user or cpu turn first
	{
		String inputValue = JOptionPane
			.showInputDialog("Who will go first? \n Type \'U\' for User, type \'C\' for Computer");
			
		if (inputValue.equals("U") || inputValue.equals("u")) {
			// continue
			noughts = true;
		} else if (inputValue.equals("C") || inputValue.equals("c")) {
			noughts = false;
			cpumove();
		} else {
			JOptionPane.showMessageDialog(null,
					"Invalid input. Please try again.", "alert",
					JOptionPane.ERROR_MESSAGE);
			promptUser();
		}
	}
	
	
	public static void main(String [] args)
	{
		JTT thing = new JTT();
	}
	
	private class CellButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//return if game over
			if (gameOver)
			{ return; }
			
			//find button
			JButton pressed = (JButton) (e.getSource());
			
			//get text of button
			String text = pressed.getText();
			
			if (text.equals("X") || text.equals("O"))
			{ return; }  //return if already an X or O
		
			if(noughts)
			{
				pressed.setText("X");
				pressed.setIcon(crossIcon);
			}
			else {
				pressed.setText("O");
				pressed.setIcon(noughtIcon);
			}
		}
	}

}
