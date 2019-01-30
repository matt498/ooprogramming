package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;

import javax.swing.JPanel;

public class Player extends AbstractGameObject {
	int score = 0;
	
	public Player(JPanel parent, HashMap<String, GameObject> hgo, 
			int w, int h, int x, int y, int speedX, int speedY) {
		this.parent = parent;
		this.hgo = hgo;
		this.w = w;
		this.h = h;
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}

	public void update() {
		y += speedY;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRoundRect(x, y, w, h, 10, 10);
	}
}
