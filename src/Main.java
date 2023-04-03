import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	
	private static JFrame frame;
	private static String title;

	private static final int WIDTH =700;
	private static final int HEIGHT=700;
	public Main () {
		super("Mine Island");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		Color RoyalBlue = new Color(50,200,200);
		setBackground(RoyalBlue);
		getContentPane().add(play);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Main run = new Main();
	}

}