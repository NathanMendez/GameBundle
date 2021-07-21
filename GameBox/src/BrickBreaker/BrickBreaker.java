package BrickBreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class BrickBreaker extends JPanel implements ActionListener,KeyListener{

	private static final long serialVersionUID = 1L;
	
	final int LENGTH = 8;
	final int WIDTH = 5;
	
	int TILESREMAINING = LENGTH*WIDTH;
	int lives = 3;
	int TIMECONSTANT = 20;

	boolean lost = false;
	
	Timer t = new Timer(TIMECONSTANT,this);

	JFrame frame = new JFrame();

	Brick[][] bricks = new Brick[LENGTH][WIDTH];
	
	Ball ball = new Ball(200,200);
	
	Paddle player = new Paddle(300,500);

	public BrickBreaker() {
		int x = 20;
		int y = 20;

		for (int i = 0; i < WIDTH ;i++) {
			for (int j = 0; j < LENGTH; j++) {
				bricks[j][i]=new Brick(x,y,i);
				x=x+70;
			}
			y=y+30;
			x=20;
		}
		
		frame.setSize(600,600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Brick Breaker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(this);
		
		this.setBackground(Color.black);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		t.start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		ball.Draw(g);
		player.Draw(g);
		
		g.fillOval(540, 540, 10, 10);
		g.drawString("x"+lives, 555 ,548);
		g.drawString("Remaining: "+TILESREMAINING, 10, 548);
		
		if(lost==true) {
			g.drawString("Press Space to launch the ball", 220, 300);
		}
		
		else if(TILESREMAINING==0) {
			g.drawString("You have won the game!!", 220, 300);
		}
		
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				Brick brick = bricks[j][i];
				
				if(brick.isBroken) {
					continue;
				}else {
					brick.Draw(g);
				}
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {		
	}

	@Override
	public void keyPressed(KeyEvent e) {	
		int c = e.getKeyCode();

		if(c==KeyEvent.VK_LEFT) {
			if(player.x<=10) {
				player.x=10;
			}
			else {
				player.x-=player.velX;
			}
		}
		
		else if(c==KeyEvent.VK_RIGHT) {
			if(player.x>=480) {
				player.x=480;
			}else {
				player.x+=player.velX;
			}
		}
		else if(c==KeyEvent.VK_SPACE) {
			lost=false;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(t.isRunning()) {
			if(lives==0) {
				frame.dispose();
			}
			
			if(TILESREMAINING==LENGTH*WIDTH/-10) {
				t.stop();
				t.start();
				TIMECONSTANT=20;

			}
			else if(TILESREMAINING==LENGTH*WIDTH/2) {
				t.stop();
				t.start();
				TIMECONSTANT=10;
			}
			
			if(!lost) {
				ball.x+=ball.velX;
				ball.y+=ball.velY;
			}else {
				ball.x=player.x+40;
				ball.y=player.y-30;
			}
			
			if(ball.x<=0||ball.x>=560) {
				ball.velX*=-1;
			}if(ball.y<=0) {
				ball.velY*=-1;
			}if(ball.y>=530) {
				lost=true;
				lives--;
			}

			if(ball.y==player.y-10&&ball.x>=player.x-10&&ball.x<=player.x+90) {
				ball.velY*=-1;
			}
			
			if(ball.y<=LENGTH*WIDTH*100) {
				for (int i = 0; i < WIDTH; i++) {
					for (int j = 0; j < LENGTH; j++) {
						Brick brick = bricks[j][i];
						if(!brick.isBroken) {
							if(ball.y==brick.y&&ball.x>=brick.x-10&&ball.x<=brick.x+50) {
								ball.velY*=-1;
								Break(brick);
							}
							
							else if(ball.x==brick.x-20&&ball.y>=brick.y-10&&ball.y<=brick.y+10) {
								ball.velX*=-1;
								Break(brick);
							}
							
							else if(ball.x==brick.x+60&&ball.y>=brick.y-10&&ball.y<=brick.y+10) {
								ball.velX*=-1;
								Break(brick);
							}
							
							else if(ball.y==brick.y+20&&ball.x>=brick.x-10&&ball.x<=brick.x+50) {
								ball.velY=ball.velY*-1;
								Break(brick);
							}
							
						}else {
							continue;
						}
						
					}
				}
			}
			repaint();
		}
		
	}
	public void Break(Brick brick) {
		brick.x=-80;
		brick.y=-80;
		brick.isBroken=true;
		TILESREMAINING--;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		BrickBreaker g = new BrickBreaker();
	}
}
