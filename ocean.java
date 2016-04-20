import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class ocean extends JFrame
	implements ActionListener
{
	
	class closer extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.out.println("Goodbye!");
			System.exit(0);
		}
	}
	
	class Fish
	{
		int x,y;
		int size;
		Color color;
		
		public Fish(int xpos, int ypos, int s, Color c)
		{
			x=xpos; y=ypos; color=c;
			size=s;
		}
		
		public void move(int deltax, int deltay)
		{
			x+=deltax;
			y+=deltay;
		}
		
		public void colorme(Color c)
		{
			color=c;
		}
		
		public void drawme(Graphics g)
		{
			g.setColor(color);
			g.fillOval(x,
			  (int)(y+0.05*size),
			  (int)(1.5*size),(int)(0.9*size));
			int [] X={(x+size),x+2*size,x+2*size};
			int [] Y={(int)(y+0.5*size),
			  (int)(y+0.05*size),(int)(y+0.95*size)};
			g.fillPolygon(X,Y,3);
			
			g.setColor(Color.white);
			g.fillOval(x+size/5,y+size/3,
			  size/5,size/5);
			g.setColor(Color.black);
			g.fillOval(x+size/5+5,y+size/3+5,
			  size/5-10,size/5-10);
		}
	}

	Fish [] school;
	
	class Picture extends JPanel
	{
		public Picture()
		{  setSize(1000,600); }
		
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.blue);
			g.fillRect(0,0,1000,700);
			
			//Fish f=new Fish(100,100,300,Color.orange);
			//f.drawme(g);
			for(int i=0; i<school.length; i++)
			{
				school[i].drawme(g);
			}
		}
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==animate)
		{
			for(int i=0; i<school.length; i++)
				school[i].move(-5,0);
		}
		else
		{
			int f=Integer.parseInt(t.getText());
			if(0<=f && f<school.length)
				school[f].colorme(
			new Color((int)(255*Math.random()),
			  (int)(255*Math.random()),
			  (int)(255*Math.random()))
			  );
			
		}
	
		r.repaint();
		
	}
	
	JButton animate;
	JButton tb;
	Picture r;
	TextField t;

	public ocean()
	{
		addWindowListener( new closer() );
		setTitle("The Ocean!!");
		
		setSize(1050,700);
		
		school=new Fish[10];
		for(int i=0; i<school.length; i++)
		{
			school[i]=new Fish(
			  (int)(1000*Math.random()),
			  (int)(600*Math.random()),
			  (int)(100*Math.random()+1), 
			  new Color((int)(255*Math.random()),
			  (int)(255*Math.random()),
			  (int)(255*Math.random())) );
		}
		
		Container stuff=getContentPane();
		
		stuff.setLayout( new BorderLayout());
		
		//JPanel q=new JPanel();
		//q.add( new Picture());
		r=new Picture();
		stuff.add(r, "Center" );
		
		animate=new JButton("X");
		stuff.add(animate,"West");
		animate.addActionListener(this);
		
		JPanel p=new JPanel();
		stuff.add(p,"South");
		
		t=new TextField("1");
		p.add(t);
		tb=new JButton("Change Color!");
		p.add(tb);
		tb.addActionListener(this);
		

		setVisible(true);
	}
	
	public static void main(String [] args)
	{
		ocean atlantic=new ocean();
		
	}
}