import javax.swing.ImageIcon;

import com.sun.javafx.geom.Rectangle;

public class Projectiles {
	int x, y, w, h, dx, dy;
	ImageIcon pic;
	
	public Projectiles() {
		x=0;
		y=0;
	}
	
	public Projectiles (int xv, int yv, int dxx, int dyy, ImageIcon i) {
		x=xv;
		y=yv;
		w=100;
		h=20;
		dx=dxx;
		dy=dyy;
		pic = i;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getH() {
		return h;
	}
	public int getW() {
		return w;
	}
	
	public ImageIcon getPic() {
		return pic;
	}
	
	public void setY(int dy) {
		y+=dy;
	}

	public void increasedx(int dxv) {
	if(dx<0) {
		dx -=dxv;
	} else {
		dx += dxv;
		
	}
	}
	
	/*
	public boolean collision(SpaceShip s) {
		Rectangle Ship = new Rectangle (s.getX(), s.getY(), s.getW(), s.getH());
		Rectangle Proj = new Rectangle (getX(), getY(), getW(), getH());
		if(Ship.intersects(Proj)) {
			return true;
		}
		
		return false;
	}
	*/
	}
