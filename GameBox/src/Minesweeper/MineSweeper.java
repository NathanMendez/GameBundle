package Minesweeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class MineSweeper {
	
	public final int BOMBCOUNT = 10;
	public final int LENGTH = 9;
	public final int WIDTH = 9;
	
	Timer t = new Timer();

	
	JButton[] x = new JButton[LENGTH*WIDTH];
	boolean loss = false;
	boolean win=false;
	public int gameScore=0;
	
	public void playLossAnimation() {
		if(!loss) {
			loss=true;
			for(JButton b:x) {
				b.doClick();
			}
		}
	}
	
	public void addScore() {
		gameScore++;
		if(gameScore==(WIDTH*LENGTH)-BOMBCOUNT) {
			win=true;
		}
	}
	
	public Color assignColor(int count) {
		if(count==1) {
			return Color.BLUE;
		}else if(count==2) {
			return Color.green;
		}else if(count==3) {
			return Color.PINK;
		}else if(count==4) {
			return Color.YELLOW;
		}else if(count==5) {
			return Color.CYAN;
		}else {
			return Color.MAGENTA;
		}
	}
	
	public Tile[][] generateTable() {
		Tile[][] table = new Tile[LENGTH][WIDTH];

		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j <WIDTH; j++) {
				table[i][j] = new Tile(false);
			}
		}
		
		for (int bomb = 0; bomb < BOMBCOUNT; bomb++) {
			
			int randCol = ThreadLocalRandom.current().nextInt(0,LENGTH);
			int randR = ThreadLocalRandom.current().nextInt(0,WIDTH);
			
			if(table[randCol][randR].isMine==true) {
				bomb=bomb-1;
				continue;
			}else {
				table[randCol][randR].isMine=true;
			}

		}
		
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j <WIDTH; j++) {
				
				try {

					if(table[i][j+1].isMine){
						table[i][j].mineCount++;
					}
					
				} catch (Exception e) {
				}
				
				try {
					if(table[i+1][j].isMine){
						table[i][j].mineCount++;
					}
				} catch (Exception e) {
				}
				
				try {
					if(table[i+1][j+1].isMine){
						table[i][j].mineCount++;
					}
				} catch (Exception e) {
				}
				
				try {
					if(table[i+1][j-1].isMine){
						table[i][j].mineCount++;
					}
				} catch (Exception e) {
				}
				
				try {
					if(table[i][j-1].isMine){
						table[i][j].mineCount++;
					}
				} catch (Exception e) {
				}
				
				try {
					if(table[i-1][j-1].isMine){
						table[i][j].mineCount++;
					}
				} catch (Exception e) {
				}
				
				try {
					if(table[i-1][j].isMine){
						table[i][j].mineCount++;
					}
				} catch (Exception e) {
				}
				
				try {
					if(table[i-1][j+1].isMine){
						table[i][j].mineCount++;
					}
				} catch (Exception e) {
				}
				
			}
		}
		
		return table;
	}
	

	public MineSweeper() {	
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JButton reset = new JButton(":)");
		JTextField bombCount = new JTextField("10");
		
		int index=0;
		
		Tile[][] table = generateTable();
		
		frame.setTitle("Minesweeper");
		frame.setSize(400,500);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panel.setBackground(Color.black);
		panel2.setBackground(Color.black);

		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				@SuppressWarnings("unused")
				MineSweeper m = new MineSweeper();
			}
			
		});
		
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < WIDTH; j++) {
				
				JButton b = new JButton();
				
				int length = i;
				int width = j;
				b.setBackground(Color.black);
				b.setFocusPainted(false);
				
				b.addActionListener(new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent e) {
						int mineCount = table[length][width].mineCount;
						if(table[length][width].isMine) {
							reset.setText(":(");
							b.setForeground(Color.red);
							b.setFont(new Font("Arial",Font.PLAIN,10));
							b.setText("X");
							playLossAnimation();

						}else if(mineCount>0&&loss==false) {
							b.setText(""+table[length][width].mineCount);
							b.setForeground(assignColor(mineCount));
							addScore();
							if(win==true) {
								frame.dispose();
								@SuppressWarnings("unused")
								Win win = new Win();
							}
						}else if(loss==false){
							b.setBackground(new Color(45,45,45));
							addScore();
							b.setEnabled(false);
							if(win==true) {
								frame.dispose();
								@SuppressWarnings("unused")
								Win win = new Win();

							}


						}
					}
				});
				
				panel.add(b);
				
				x[index]=b;
				index++;
			}
			
		}
		panel.setLayout(new GridLayout(LENGTH,WIDTH));

		panel2.setLayout(null);
		panel.setBounds(13, 90, 360, 360);
		reset.setBounds(160,20,60,60);
		reset.setForeground(Color.white);
		reset.setBackground(Color.black);
		
		panel2.add(bombCount);
		panel2.add(panel);
		panel2.add(reset);
		
		frame.add(panel2);

		frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MineSweeper sweep = new MineSweeper();
	}
	
}
