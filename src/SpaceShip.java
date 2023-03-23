import javax.swing.ImageIcon;

public class SpaceShip {
	private int x,y,w,h;
	private int dx,dy;
	private ImageIcon shipImg;

	public SpaceShip() {
		w=0;
		y=0;
		w=80;
		h=100;
		shipImg = new ImageIcon("");
	}
	
	public SpaceShip(int xV, int yV,ImageIcon i){
	
x=xV;
y=yV;
w=150;
h=150;
shipImg= i;
dx=1;
dy=0;

}
//getters and setters
public int getX() {
	return x;
}
public int getY() {
	return y;
}
public int getW() {
	return w;
}

public int getH() {
	return h;
}
public int getdx() {
	return dx;
}
public int getdy() {
	return dy;
}
public void setdy(int hi) {
	dy=hi;
}
public ImageIcon getShipImg() {
	return shipImg;
}

public void setShipX(int dx) {
	x=dx;
}
public void setX(int dx) {
	x+=dx;
}
//speed up
//public void setdX(int dxn) {
	//dx=dx*dxn;
//}



public void reverseHorz() {
	 dx = dx*-1;
}
public void increase(int speed) {
	if(dx>0) {
	dx+=speed;
	} else {
		dx-=speed;
	}
}
public void move(int screenW, int screenH)
{
	x+=dx;
	y+=dy;
	//if((x+w)>screenW || x<0) {
		//reverseHorz();
	//}
			
	
}
public boolean wallHit(int screenW,int screenH) {
	return((x+w)>screenW || x<0);
}
}