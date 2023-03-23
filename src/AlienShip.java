import javax.swing.ImageIcon;

public class AlienShip extends SpaceShip {
	public AlienShip() {
		super();
	}
	
	public AlienShip(int x, int y, int dx) {
		super(x, y, new ImageIcon ("aliens.png"));
	}
}
	
/*
 * public void speedup(double dxV) { setDx(getDx()+dxV); } }
 */