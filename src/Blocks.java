//this class creates the tiles for our game using buttons and then we add it later in jpanel  	
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.*;
//to create button object we extended Jbutton and plays music when clicking button
public class Blocks extends JButton implements MouseListener {
//spot of the block for location 
	private int spot; 
//spot is true or false based on if the block is found by player
	private boolean discovered;
// three types of blocks (empty, bomb, number) each block unique #
	private int type;
// indicates if flags is placed
	private boolean flags;
	private ImageIcon tile;
	
//put everything as a parameter for blocks to define each object
// assigns parameter to "instance" variables {outside of constructor} 
// we found this constructor is necessary to modify blocks 
	public Blocks (int spot, boolean discovered, int type, boolean flags) {
//	1. ERROR - u have to assign parameter values 2 variables called before
//  had to look up syntax on how to pull instance variables
		this.spot = spot;
		this.discovered = discovered;
		this.type = type;
		this.flags = flags;
		this.tile = new ImageIcon ("beach tile.png");
		//setIcon(tile);
		
		addMouseListener(this);
}
//getters and setters
	
public int getSpot() {
	    return spot;
	}

//parameter to modify value of discovered
public void setDiscovered(boolean discover) {
    this.discovered = discover;
}
//identify is discovery true
public boolean getDiscovered() {
  return discovered;
}
public int getType() {
    // types of mines 
	// mine number and empty blocks - assigned number int
    return type;
}
public void setFlags(boolean flag) {
    this.flags = flag;
}
public boolean getFlags() {
    return flags;
}
public ImageIcon gettile() {
	return tile;
}

//looked up this method to get sound on button
private void playClickSound() {
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("click.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    } catch(Exception ex) {
    }
}

// implement mouse listener methods
public void mouseClicked(MouseEvent e) {
    playClickSound(); 
}
public void mousePressed(MouseEvent e) {
	
}
public void mouseReleased(MouseEvent e) {
	
}
public void mouseEntered(MouseEvent e) {
	
}
public void mouseExited(MouseEvent e) {
	
}

}



