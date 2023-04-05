
//TESTING FRAME


import javax.swing.JFrame;
import java.awt.GridLayout;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MineSweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,1)); // set layout of JFrame to a 1x1 grid
        
        Grid gridPanel = new Grid(new GridLayout(Game.grid, Game.grid)); // create new Grid panel
        
        frame.add(gridPanel); // add Grid panel to JFrame
        frame.pack(); // resize JFrame to fit contents
        frame.setVisible(true); // display JFrame
    }
}
