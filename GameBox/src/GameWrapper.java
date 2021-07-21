import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameWrapper {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(600,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Game Select");
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		
		JLabel Tittle = new JLabel("Game Bundle");
		Tittle.setFont(new Font("Arial",Font.PLAIN,40));
		Tittle.setForeground(Color.white);
		Tittle.setBounds(160,-90,300,300);
		
		JLabel label = new JLabel("Choose a game.");
		label.setFont(new Font("Arial",Font.PLAIN,20));
		label.setForeground(Color.white);
		label.setBounds(210,10,200,200);
		
		JButton BrickBreaker = new JButton("Brick Breaker");
		BrickBreaker.setBounds(120,180,120,40);
		BrickBreaker.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();	
				BrickBreaker.BrickBreaker brick = new BrickBreaker.BrickBreaker();
			}
		});

		JButton Pong = new JButton("Pong");
		Pong.setBounds(320,180,120,40);
		Pong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();	
				Pong.Game pong = new Pong.Game();
			}
		});
		
		

		JButton MineSweeper = new JButton("Mine Sweeper");
		MineSweeper.setBounds(120,280,120,40);
		MineSweeper.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();	
				Minesweeper.MineSweeper sweep = new Minesweeper.MineSweeper();
			}
		});
		
		JLabel version = new JLabel("v1");
		version.setFont(new Font("Arial",Font.PLAIN,20));
		version.setForeground(Color.white);
		version.setBounds(550,450,200,200);
		
		JLabel Message = new JLabel("More Games Comming Soon...");
		Message.setFont(new Font("Arial",Font.PLAIN,20));
		Message.setForeground(Color.white);
		Message.setBounds(0,420,290,250);

		panel.setLayout(null);
		panel.add(Tittle);
		panel.add(label);
		panel.add(MineSweeper);
		panel.add(Pong);
		panel.add(BrickBreaker);
		panel.add(version);
		panel.add(Message);
		
		
		
		frame.add(panel);
		
		frame.setVisible(true);

	}
}
