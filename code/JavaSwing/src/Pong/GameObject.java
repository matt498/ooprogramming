package Pong;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface GameObject {
	public void update();
	public void paint(Graphics g);
	public Rectangle getBounds();
	
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public int getSpeedX();
	public int getSpeedY();
	public void setSpeedX(int sx);
	public void setSpeedY(int sy);
}
