package BrickBreaker;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	public int x;
	public int y;
	public int velX=5;
	public int velY=5;
	
	public Ball(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public void Draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 20, 20);
	}
}
