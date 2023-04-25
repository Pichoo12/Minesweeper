import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.*;

public class Main {
    private static JFrame frame;
    private static String title = "";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int GRID_SIZE = Game.grid;
    private static Game game;
    private static Discovery discovery;
    
    public static void main(String[] args) {
       frame = new JFrame(title);
        game = new Game();
        discovery = new Discovery();
        
        frame.setSize(WIDTH, HEIGHT);
     // positions Jframe in middle
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
      //assigned to variable grid 
      // found in game class
        Grid grid = new Grid(new GridLayout(GRID_SIZE, GRID_SIZE), discovery);
        Color RoyalBlue = new Color(173,216,230);
        grid.setBackground(RoyalBlue); 

        //DONT DELETE this is what adds grid object to frame 
        //makes from visibile 
        
        frame.getContentPane().add(grid);
        frame.setVisible(true);
        
        update(0);
    }
    
    public static void update(int flagged) {
        int numMines = Game.mines;
        title = String.format("Mines: " + Game.mines + " | Flags: " + flagged);
        frame.setTitle(title);
    }
}
