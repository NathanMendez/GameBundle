package Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements KeyListener,ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Timer t = new Timer(10,this);
	
	Paddle player = new Paddle(100,200);
	Paddle enemy = new Paddle(700,200);
	Ball ball = new Ball(400,250);
	
	int pointsP = 0,pointE = 0;
	
	boolean firstime=true,serve=false;
	
	Font f = new Font("TimesNewRoman",Font.BOLD,50);
	public Game() {
		
		JFrame frame = new JFrame();
		frame.setSize(800,500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(this);
		
		this.setBackground(Color.black);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.requestFocusInWindow();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		player.draw(g);
		enemy.draw(g);
		ball.draw(g);
		
		int yPos = 40;
		for (int i = 0; i < 10; i++) {
			g.fillRect(400, yPos, 10, 10);
			yPos+=40;
		}
		
		g.fillRect(0, 0, 800, 20);
		g.fillRect(0, 440, 800, 20);
		
		g.setFont(f);
		g.drawString(""+pointsP, 300, 80);
		g.drawString(""+pointE, 470, 80);


	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(t.isRunning()) {
			if(serve!=true) {
				ball.xPos=ball.xPos+ball.xVel*-1;
				ball.yPos=ball.yPos+ball.yVel*-1;
			}
			
			if(ball.xPos==player.xPos&&ball.yPos>=player.yPos-25&&ball.yPos<=player.yPos+65) {
				ball.xVel=ball.xVel*-1;
			}
			
			else if(ball.xPos==enemy.xPos-20&&ball.yPos>=enemy.yPos-25&&ball.yPos<=enemy.yPos+65) {
				ball.xVel=ball.xVel*-1;
			}
			
			if(ball.yPos<=25) {
				ball.yVel*=-1;
			}
			
			else if(ball.yPos>=420) {
				ball.yVel*=-1;
			}
			
			else if(ball.xPos>=800) {
				pointsP++;
				ball.xVel*=-1;
				ball.xPos=enemy.xPos+ball.xVel-30;
				ball.yPos=enemy.yPos+ball.yVel;
			}
			
			else if(ball.xPos<=0) {
				pointE++;
				ball.xVel*=-1;
				serve=true;
				ball.xPos=player.xPos+ball.xVel+30;
				ball.yPos=player.yPos+ball.yVel;
			}
			
			enemy.yPos=ball.yPos;
			if(enemy.yPos>=360) {
				enemy.yPos=360;
			}
			
			else {
				enemy.yPos+=enemy.yVel;
			}
			
			if(enemy.yPos<=30) {
				enemy.yPos=30;
			}
			
			else {
				enemy.yPos-=player.yVel;
			}
			this.repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if(firstime) {
			t.start();
		}
		
		if(c==KeyEvent.VK_UP) {
			if(serve==true) {
				ball.xPos=player.xPos+20;
				ball.yPos=player.yPos+20;
				ball.xVel*=-1;
			}
			
			if(player.yPos<=30) {
				player.yPos=30;
			}
			
			else {
				player.yPos-=player.yVel;
			}
		}
		
		else if(c==KeyEvent.VK_DOWN) {
			if(serve==true) {
				ball.xPos=player.xPos+20;
				ball.yPos=player.yPos+20;
			}
			
			if(player.yPos>=360) {
				player.yPos=360;
			}
			
			else {
				player.yPos+=player.yVel;
			
			}
		}
		
		else if(c==KeyEvent.VK_SPACE) {
			serve=false;
		}
		this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Game g = new Game();
	}
	

}
