import javax.swing.ImageIcon;

public class AlienProj extends Projectiles{
	
		public AlienProj() {
			super();
		}
		
		public AlienProj(int x, int y, int dx, int dy) {
			super(x, y, dx, dy, new ImageIcon ("cupcake.png"));
		}
}
