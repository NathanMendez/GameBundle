package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	public int xPos;
	public int yPos;
	public int yVel = 10;
	public Paddle(int xPos,int yPos) {
		this.xPos=xPos;
		this.yPos=yPos;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(xPos, yPos, 10, 70);
	}
}
