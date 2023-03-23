import javax.swing.ImageIcon;

public class PlayerProj extends Projectiles{
	public PlayerProj() {
		super();
	}
	
	public PlayerProj(int x, int y, int dx, int dy) {
		super(x, y, dx, dy, new ImageIcon ("laser.png"));
	}
}
