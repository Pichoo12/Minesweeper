import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage; 
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener{

	
	private BufferedImage back; 
	private int key; 
	private Player p;

public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		key =-1; 
		p =new Player();
		
		//plays music in background
		p.playmusic("background music.wav");
		
	
	}

	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	
public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.setFont( new Font("Arial", Font.BOLD, 10));
		Color Black = new Color(0,0,0);


		setBackground(Black);
		
//Drawing
		//drawing amount of mines and flags
		//g2d.drawString("Mines: " + //minetracker + " - Flags: " + flagged)");"
		g2d.drawString ("Cheatcodes: M & N", 10, 650);
		twoDgraph.drawImage(back, null, 0, 0);
	}

	



	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}




//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		
		
	
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		
		
	}
	
	
	

	
}