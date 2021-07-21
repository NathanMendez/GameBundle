package BrickBreaker;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	public int x;
	public int y;
	public int velX=10;
	
	public Paddle(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public void Draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, 100, 10);
	}
}
