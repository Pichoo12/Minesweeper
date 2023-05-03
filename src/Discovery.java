
// what happens on each block click
// win lose 
// 0 empty, 1 mine, 2 number 

import java.util.ArrayList;

public class Discovery {



    private ArrayList<Blocks> foundblocks = new ArrayList<Blocks>();

    //adjacent blocks
    private ArrayList<Blocks> queue = new ArrayList<Blocks>();

    private static int flaggedBlocks = 0;
    
    public void click(Blocks block) {
        int discoveredBlocks = 0;
        if(!block.isFlagged()) {
            block.setEnabled(false);
            block.setDiscovered(true);
            
          //find spot of block to determine what happens on click
            int spot = block.getSpot();
            
            //0<9
            if(block.getType() == 0) {
                if(spot < Game.grid) {
                	//top left corner
                	//adds adjacents blank blocks 
                    if(spot % Game.grid == 0) {
                        queue.add(Grid.blockGrid.get((spot + Game.grid)));
                        queue.add(Grid.blockGrid.get((spot + Game.grid + 1)));
                        queue.add(Grid.blockGrid.get((spot  + 1)));
            
                    } else if(spot % Game.grid == Game.grid - 1) {
                        queue.add(Grid.blockGrid.get((spot + Game.grid)));
                        queue.add(Grid.blockGrid.get((spot + Game.grid - 1)));
                        queue.add(Grid.blockGrid.get((spot  - 1)));
                    } else {
                        queue.add(Grid.blockGrid.get((spot + Game.grid)));
                        queue.add(Grid.blockGrid.get((spot + Game.grid + 1)));
                        queue.add(Grid.blockGrid.get((spot + Game.grid - 1)));
                        queue.add(Grid.blockGrid.get((spot + 1)));
                        queue.add(Grid.blockGrid.get((spot - 1)));
                    }
            
            // bottom left
                } else if(spot >= (Game.grid * (Game.grid - 1))) {
                    if(spot % Game.grid == 0) {
                        queue.add(Grid.blockGrid.get((spot - Game.grid)));
                        queue.add(Grid.blockGrid.get((spot - Game.grid + 1)));
                        queue.add(Grid.blockGrid.get((spot + 1)));
                    } else if(spot % Game.grid == Game.grid - 1) {
                        queue.add(Grid.blockGrid.get((spot - Game.grid)));
                        queue.add(Grid.blockGrid.get((spot - Game.grid - 1)));
                        queue.add(Grid.blockGrid.get((spot - 1)));
                    } else {
                        queue.add(Grid.blockGrid.get((spot - Game.grid)));
                        queue.add(Grid.blockGrid.get((spot  - Game.grid + 1)));
                        queue.add(Grid.blockGrid.get((spot - Game.grid - 1)));
                        queue.add(Grid.blockGrid.get((spot + 1)));
                        queue.add(Grid.blockGrid.get((spot - 1)));
                    }
                    
               //first column modulo remainder checks edges by seeing if it = 0
                } else if(spot % Game.grid == 0) {
                    queue.add(Grid.blockGrid.get((spot - Game.grid)));
                    queue.add(Grid.blockGrid.get((spot + Game.grid)));
                    queue.add(Grid.blockGrid.get((spot - Game.grid + 1)));
                    queue.add(Grid.blockGrid.get((spot + Game.grid + 1)));
                    queue.add(Grid.blockGrid.get((spot + 1)));
                } else if(spot % Game.grid == Game.grid - 1) {
                    queue.add(Grid.blockGrid.get((spot - Game.grid)));
                    queue.add(Grid.blockGrid.get((spot + Game.grid)));
                    queue.add(Grid.blockGrid.get((spot - Game.grid - 1)));
                    queue.add(Grid.blockGrid.get((spot + Game.grid - 1)));
                    queue.add(Grid.blockGrid.get((spot - 1)));
                } else {
                    queue.add(Grid.blockGrid.get((spot - Game.grid)));
                    queue.add(Grid.blockGrid.get((spot + Game.grid)));
                    queue.add(Grid.blockGrid.get((spot - Game.grid - 1)));
                    queue.add(Grid.blockGrid.get((spot + Game.grid - 1)));
                    queue.add(Grid.blockGrid.get((spot - Game.grid + 1)));
                    queue.add(Grid.blockGrid.get((spot + Game.grid + 1)));
                    queue.add(Grid.blockGrid.get((spot - 1)));
                    queue.add(Grid.blockGrid.get((spot + 1)));
                }
                
                
                
                
     //number blocks - determining what number shows            
                
            } else if(block.getType() == 2) {
                int bombCount = 0;
                if(spot < Game.grid) {
                    if(spot % Game.grid == 0) {  //checks top left corner 
                        if(Grid.blockGrid.get(spot + Game.grid).getType() == 1) bombCount++; //adds mine count around number block 
                        if(Grid.blockGrid.get(spot + Game.grid + 1).getType() == 1) bombCount++; 
                        if(Grid.blockGrid.get(spot + 1).getType() == 1) bombCount++;
                    } else if(spot % Game.grid == Game.grid - 1) {
                        if(Grid.blockGrid.get(spot + Game.grid).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot + Game.grid - 1).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot - 1).getType() == 1) bombCount++;
                    } else {
                        if(Grid.blockGrid.get(spot + Game.grid).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot + Game.grid + 1).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot + Game.grid - 1).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot + 1).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot - 1).getType() == 1) bombCount++;
                        System.out.println(bombCount);
                    }
                } else if(spot >= (Game.grid * (Game.grid - 1))) {
                    if(spot % Game.grid == 0) {
                        if(Grid.blockGrid.get(spot - Game.grid).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot - Game.grid + 1).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot + 1).getType() == 1) bombCount++;
                    } else if(spot % Game.grid == Game.grid - 1) {
                        if(Grid.blockGrid.get(spot - Game.grid).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot - Game.grid - 1).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot - 1).getType() == 1) bombCount++;
                    } else {
                        if(Grid.blockGrid.get(spot - Game.grid).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot - Game.grid + 1).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot - Game.grid - 1).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot + 1).getType() == 1) bombCount++;
                        if(Grid.blockGrid.get(spot - 1).getType() == 1) bombCount++;
                    }
                } else if(spot % Game.grid == 0) {
                    if(Grid.blockGrid.get(spot - Game.grid).getType() == 1) bombCount++;
                   
                    if(Grid.blockGrid.get(spot + Game.grid).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get(spot - Game.grid + 1).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get(spot + Game.grid + 1).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get(spot + 1).getType() == 1) bombCount++;
                } else if(spot % Game.grid == Game.grid - 1) {
                    if(Grid.blockGrid.get((spot - Game.grid)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot + Game.grid)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot - Game.grid - 1)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot + Game.grid - 1)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot - 1)).getType() == 1) bombCount++;
                } else {
                    if(Grid.blockGrid.get((spot - Game.grid)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot + Game.grid)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot - Game.grid - 1)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot + Game.grid - 1)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot - Game.grid + 1)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot + Game.grid + 1)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot - 1)).getType() == 1) bombCount++;
                    if(Grid.blockGrid.get((spot + 1)).getType() == 1) bombCount++;
                }
                
                
                
                //sets text of danger counter to number 
                block.setText(String.valueOf(bombCount));
            
            
            
            } else if(block.getType() == 1) {
                for(int x = 0; x < Grid.blockGrid.size(); x++) {
                    Grid.blockGrid.get(x).setEnabled(false);
                    Grid.blockGrid.get(x).setText("");
                    if(Grid.blockGrid.get(x).getType() == 1) {Grid.blockGrid.get(x).setText("BOMB");}
                }
                block.setText("BOOP");
            }  

            //if block not discovered add to foundblocks arraylist 
            for(int x = 0; x < queue.size(); x++) {
                if(!queue.get(x).getDiscovered()) {
                    foundblocks.add(queue.get(x));
                    queue.get(x).setDiscovered(true);
                    
                    
                    
                }
            }
            
            //function to update foundblocks list 
            queue.clear();
            while(!foundblocks.isEmpty()) {
                Blocks temp = foundblocks.get(0); //create temporary block 
                foundblocks.remove(0); // prevents loop 
                temp.clickButton();
            }

            for(int x = 0; x < Grid.blockGrid.size(); x++) {
                if(Grid.blockGrid.get(x).getDiscovered()) {
                    discoveredBlocks++;
                }
            }

            if(discoveredBlocks == Grid.blockGrid.size() - Game.mines) {
                for(int x = 0; x < Grid.blockGrid.size(); x++) {
                    if(Grid.blockGrid.get(x).getType() == 1) {
                        Grid.blockGrid.get(x).setEnabled(false);
                        Grid.blockGrid.get(x).setText("WINNER");
                    } else {
                        Grid.blockGrid.get(x).setEnabled(false);
                        Grid.blockGrid.get(x).setText("");
                    }
                }
            }
        }   
    }

    
    public void rightClick(Blocks block) {
        if(!block.getDiscovered()) {
            if(!block.isFlagged()) {
                block.setFlags(true);
                block.setText("F");
                flaggedBlocks++;
                Main.update(flaggedBlocks);
            } else {
                block.setFlags(false);
                block.setText("F");
                flaggedBlocks--;
                Main.update(flaggedBlocks);
            }
        }
    }
}
