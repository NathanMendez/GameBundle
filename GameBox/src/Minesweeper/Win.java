package Minesweeper;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Win {
	public Win() {
		JFrame f = new JFrame();
		f.setTitle("Win");
		f.setSize(300,200);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		
		JPanel p = new JPanel();
		p.setBackground(Color.black);
		
		JTextField field = new JTextField("        You win! ");
		field.setEditable(false);
		field.setBackground(Color.black);
		field.setForeground(Color.WHITE);
		JButton close = new JButton("Close");
		
		
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				
			}
		});
		
		
		JButton restart = new JButton("Reset");
		restart.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				MineSweeper sweep = new MineSweeper();
						
				}
			});
		
		p.setLayout(null);
		
		field.setBounds(90, 40, 100, 20);
		p.add(field);
		
		close.setBounds(20, 120, 70, 20);
		p.add(close);
		
		restart.setBounds(180, 120, 70, 20);
		p.add(restart);
		
		f.add(p);
		
		f.setVisible(true);
	}public static void main(String[] args) {
		@SuppressWarnings("unused")
		Win win = new Win();
	}
}
