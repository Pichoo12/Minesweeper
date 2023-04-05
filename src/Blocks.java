//this class creates the tiles for our game using buttons and then we add it later in jpanel  	
import javax.swing.*;
//to create button object we extended Jbutton 
public class Blocks extends JButton {
//spot of the block for location 
	private int spot; 
//spot is true or false based on if the block is found by player
	private boolean discovered;
// three types of blocks (empty, bomb, number) each block unique #
	private int type;
// indicates if flags is placed
	private boolean flags;
	
//put everything as a parameter for blocks to define each object
// assigns parameter to "instance" variables {outside of constructor} 
// we found this constructor is necessary to modify blocks 
	public Blocks (int spot, boolean discovered, int type, boolean flagged) {
//	1. ERROR - u have to assign parameter values 2 variables called before
//  had to look up syntax on how to pull instance variables
		this.spot = spot;
		this.discovered = discovered;
		this.type = type;
		this.flags = flags;
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
}
