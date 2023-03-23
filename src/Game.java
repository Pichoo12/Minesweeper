import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*; 
public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{
	private BufferedImage back; 
	private int key; 
	private ArrayList <AlienShip> aliens;
	private ArrayList<PlayerProj> playerMiss;
	private ArrayList <AlienProj> alienMiss;
	private PlayerShip player;
	private ImageIcon background;


	private int deadaliens, lives;
	private long currentTime;
	private long start,end;
	private double elapsedtime;
	private boolean time;
	private boolean sound, losesound, lose, winsound, win;
	private Player p;
	
	
	public Game() {
		new Thread(this).start();
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		aliens= setAliens();
		playerMiss= new ArrayList <PlayerProj> ();
		alienMiss = new ArrayList <AlienProj>();
		player = new PlayerShip(500,900);
		p= new Player();
		
		sound=false;
		losesound = true;
		lose=false;
		winsound= true;
		win= false;
		currentTime = System.currentTimeMillis();
		deadaliens=0;
		lives=3;
		background= new ImageIcon("background.png");
		
		start=System.currentTimeMillis();
		end=System.currentTimeMillis();
		elapsedtime=0;
		time=true;
		p= new Player();
		//lose = new Player();

		
	}
	
	private ArrayList<AlienShip> setAliens() {
		// TODO Auto-generated method stub
		ArrayList <AlienShip> temp = new ArrayList();
		for (int i=0; i<3; i++) {
			for(int j=0; j<12; j++) {
				temp.add(new AlienShip (j*100, i*140, 1));
				
			}
		}
		return temp;
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
	
	public void alienShoot(Graphics g2d) {

		if((System.currentTimeMillis()-currentTime)%200==0) {
			alienMiss.add(new AlienProj (aliens.get(getRandomNumber()).getX(), aliens.get(getRandomNumber()).getY(), 1,1));
			currentTime=System.currentTimeMillis();
		}
	}
	
	public void drawAlienProj(Graphics g2d) {
		for(AlienProj a: alienMiss) {
			g2d.drawImage(a.getPic().getImage(), a.getX(), a.getY(), a.getW(), a.getH(), this);
			a.setY(1);
		}
	}
	
	public void paint(Graphics g){
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		Graphics g2d = back.createGraphics();
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.setFont( new Font("Broadway", Font.BOLD, 50));
		g2d.drawImage(background.getImage(), 0,0, getWidth(),getHeight(), this);
		//g2d.drawString("key " + key, 340, 100);
		
		if(lose) {
			losescreen(g2d);
		}
		//g2d.drawImage(player.getShipImg().getImage(), player.getX(), player.getY(), player.getW(), player.getH(), this);
		else if(!aliens.isEmpty()) {
			g2d.drawImage(player.getShipImg().getImage(), player.getX(), player.getY(), player.getW()+90, player.getH()+80, this);
			g2d.setColor(Color.white);
			g2d.drawString("Lives:"+lives, 20, 300);
			
			
			for(AlienShip a : aliens) {
				g2d.drawImage(a.getShipImg().getImage(), a.getX(), a.getY(), a.getW(), a.getH(), this);
				//a.setX(1);
				a.move(getWidth(), getHeight());
				if(a.wallHit(getWidth(), getHeight())) {
					bounce();
				}
				if(!(deadaliens==0) && deadaliens%8 ==0) {
					for(AlienShip b: aliens) {

					b.increase(1);
					}
					deadaliens++;
				
			
				}
	
	}
			drawAlienProj(g2d);
			alienShoot(g2d);
			sound();
			
			
			//removing alien
			for(int p=0;p<playerMiss.size();p++) {
				for(int a=0; a<aliens.size();a++) {
					if(playerMiss.get(p).getY()+playerMiss.get(p).getH() >= aliens.get(a).getY()+100 && playerMiss.get(p).getX() <= aliens.get(a).getX()+aliens.get(a).getW() && playerMiss.get(p).getY()+playerMiss.get(p).getH() <= aliens.get(a).getY()+aliens.get(a).getH() && playerMiss.get(p).getX()+playerMiss.get(p).getW() >= aliens.get(a).getX()) {
						//lives--;
						aliens.remove(aliens.get(a));
						playerMiss.remove(playerMiss.get(p));
						deadaliens++;
					}
					
				}
				
			}
			
			
			
			for(AlienProj p: alienMiss) {
				if(p.getY()+p.getH() >= player.getY() && p.getX() <= player.getX()+player.getW() && p.getY()+p.getH() <= player.getY()+player.getH() && p.getX()+p.getW() >= player.getX()) {
						lives--;
						alienMiss.remove(p);
					}		
			}
			
	
			//lose when lives run out
			if(lives==0) {
				alienMiss.remove(0);
				if(losesound) {
					p.playmusic("stop");
					p.playmusic("loser music.wav");
					losesound = false;
				}
				lose=true;
				/*g2d.drawString("You lose! Press r to reset", 300, 300);
				
				if(time) {
					end=System.currentTimeMillis();
					elapsedtime=(end-start)/1000.0;
					time=false;
					}
					g2d.drawString("time:"+elapsedtime+" seconds", 300, 500);
				*/	
			}
			
			//System.out.println(lives);
				
			//lose when overrun by aliens
			for(AlienShip a: aliens) {
				if(a.getY()+a.getH()>=player.getY()+player.getH()) {
					lose=true;
					//g2d.clearRect(0, 0, getWidth(), getHeight());
				
			
		}
	}
	
	
			
			if(!playerMiss.isEmpty()) {
				for(PlayerProj p : playerMiss) {
					g2d.drawImage(p.getPic().getImage(), p.getX(), p.getY(),p.getW(), p.getH(), this);
					p.setY(-1);
					}
			}
	
		
		}
		
			
		else {
			
			win=true;
			if(winsound) {
				p.playmusic("stop");
				p.playmusic("winner music.wav");
				winsound = false;
			}
		playerMiss.clear();
		alienMiss.clear();
		g2d.setColor(Color.white);
		g2d.drawString("You win!", 300, 300);
		g2d.drawString("time:"+elapsedtime+" seconds", 300, 500);
		
	}
	
	
		
		
		twoDgraph.drawImage(back, null, 0, 0);
		
		}
	
	public void losescreen(Graphics g2d) {
		
		
		if(losesound) {
			p.playmusic("stop");
			p.playmusic("loser music.wav");
			losesound = false;
		}
		if(winsound) {
			p.playmusic("stop");
			p.playmusic("winner music.wav");
			winsound = false;
		}
g2d.setColor(Color.white)	;	
g2d.drawString("You lose!", 300, 300);

if(time) {
end=System.currentTimeMillis();
elapsedtime=(end-start)/1000.0;
time=false;
}
g2d.drawString("time:"+elapsedtime+" seconds", 300, 500);

System.out.println("lose screen");
	}
	
	
	private int getRandomNumber() {
		return (int)(Math.random()*aliens.size());
	}


	
	public void bounce() {
		for(AlienShip b: aliens) {
			b.reverseHorz();
			b.setdy(20);
			b.move(getWidth(), getHeight());
			b.setdy(0);
			//b.setdX(2);
		}
	}
	
	private void sound() {
		if(sound) {
			p.playmusic("click.wav");
			sound=false;
		}
	
		
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
		//removing alien
		if(key==32) {
			aliens.remove(0);
			}
		//auto win
	if(key==87) {
		aliens.removeAll(aliens);
	}
	}
	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX();
		player.setShipX(x);
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//p.playmusic("click.wav");
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		playerMiss.add(new PlayerProj(player.getX(), player.getY(), 1, 1));
		playerMiss.add(new PlayerProj(player.getX()+player.getW()+5, player.getY(),1,1));
		sound=true;
		//p.playmusic("click.wav");
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
