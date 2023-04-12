
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.*;

//ERROR 2 JFrame wasn't extending 

public class Main {
    public static void main(String[] args) {
    	
        JFrame frame = new JFrame();
        Game play = new Game();

        
        //Formatting 
        //frame.setSize(Game.WIDTH, Game.HEIGHT);
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); - closes jframe on exit
        frame.setTitle("Minen Island");
        
        //size of frame
        frame.setSize(800, 800);
        
        // positions Jframe in middle
        frame.setLocationRelativeTo(null);
        
        
        
        frame.getContentPane().add(play);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ((Component) play).setFocusable(true);
        
        //assigned to variable grid 
        // found in game class
        Grid grid = new Grid(new GridLayout(Game.grid, Game.grid));
        Color RoyalBlue = new Color(173,216,230);
        grid.setBackground(RoyalBlue); 

        
        //DONT DELETE this is what adds grid object to frame 
       frame.add(grid);
        //makes frame visible
        frame.setVisible(true);
    }
}
