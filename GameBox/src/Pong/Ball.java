package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	public int xPos;
	public int yPos;
	public int xVel=5;
	public int yVel=5;

	public Ball(int xPos,int yPos) {
		this.xPos=xPos;
		this.yPos=yPos;
	}public void draw(Graphics g){
		g.setColor(Color.white);
		g.fillOval(xPos, yPos, 25, 25);
	}
}
