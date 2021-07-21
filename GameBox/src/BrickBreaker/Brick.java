package BrickBreaker;

import java.awt.Color;
import java.awt.Graphics;

public class Brick {
	public int x;
	public int y;
	private int color;
	public boolean isBroken=false;
	
	public Brick(int x,int y,int color) {
		this.x=x;
		this.y=y;
		this.color=color;
	}
	
	public void Draw(Graphics g) {
		if(color==1) {
			g.setColor(Color.green);
		}else if(color==2) {
			g.setColor(Color.BLUE);
		}else if(color==3) {
			g.setColor(Color.red);
		}else if(color==4){
			g.setColor(Color.magenta);
		}else {
			g.setColor(Color.YELLOW);
		}
		g.fillRect(x, y, 60, 20);
	}
}
