// this class arranges block class in jpanel

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel {

	//max blocks (makes it 8*8 (64) - refer to game class)
    private int maximum = Game.grid * Game.bid;
    // prevents duplication
    private boolean Duplicated = false;

  //position of each mine (Integer type array list cuz mines is assigned #) 
    private ArrayList<Integer> mines = new ArrayList<Integer>();
    
 //This ArrayList holds all blocks and creates new object of ArrayList

    public ArrayList<Blocks> blockGrid = new ArrayList<Blocks>();

 //constructor to make grid on main   
    public Grid(GridLayout hishreya) {
        super(hishreya);
//to create the grid we called two methods 
        createBlocks();
        addBlocks();
    }

    
 // FIRST WAS MINES
 // i "index" kept to track index of loop less than num mines from game (10)
    public void createBlocks() {
        for(int i = 1; i <= Game.mines; i++) {
        	//while not duplicated = true
            while(!Duplicated) {
            	
 //randomization gets number 0-maximum
 //lines 36 ISSUE
                int mineSpot = (int) (Math.random() * maximum);
                
 // code to prevent mines randomizing in same place
 // if not mineSpot number add number 
                if (!mines.contains(mineSpot)) {
                    mines.add(mineSpot);
                    Duplicated = true;
                }
                
            }
  // if mine isn't duplicated doesn't add new mines
            Duplicated = false;
        }

        
 //OTHER BLOCKS
 //Blocks 0-99
 // drew this out   
        for(int i = 0; i < maximum; i++) {
            if(mines.contains(i)) { //checking if mine array contains mine index grid counts horizontally
            	blockGrid.add(new Blocks(i, false, 1, false)); // Block class constructor 
            	
   //checks edge removes adjacent blocks to left for edge blocks
            } else if(i % Game.grid == 0){ 
                if(mines.contains(i - Game.grid) ||  //grid = 10
                        mines.contains(i - Game.grid + 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.grid) ||
                        mines.contains(i + Game.grid + 1)) {
                    blockGrid.add(new Blocks(i, false, 2, false));  //adds number blocks
                } else {
                    blockGrid.add(new Blocks(i, false, 0, false)); //adds blank cell
                }
                
            
            } else if(i % Game.grid == Game.grid - 1){   
                if(mines.contains(i - Game.grid - 1) ||
                        mines.contains(i - Game.grid) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + Game.grid - 1) ||
                        mines.contains(i + Game.grid)) {
                    blockGrid.add(new Blocks(i, false, 2, false));
                } else {
                    blockGrid.add(new Blocks(i, false, 0, false));
                }
            }else {
                if(mines.contains(i - Game.grid - 1) ||
                        mines.contains(i - Game.grid) ||
                        mines.contains(i - Game.grid + 1) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.grid - 1) ||
                        mines.contains(i + Game.grid) ||
                        mines.contains(i + Game.grid + 1)) {
                    blockGrid.add(new Blocks(i, false, 2, false));
                } else {
                    blockGrid.add(new Blocks(i, false, 0, false));
                }
            }
        }
    }

 //adds blocks to Jpanel
    
    private void addBlocks() {
        for(int i = 0; i < blockGrid.size(); i++) {
            add(blockGrid.get(i));
        }
    }
}

