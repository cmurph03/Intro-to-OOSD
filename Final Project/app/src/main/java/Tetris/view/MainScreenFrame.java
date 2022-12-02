package view;

import model.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;

public class MainScreenFrame extends JFrame
{
	public MainScreenFrame(HighScores[] scores)
	{
		this.setTitle("Tetris"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(800,780); 
		this.getContentPane().setBackground(new Color(211,211,211));
		this.setVisible(true);

		view.HighScoresWindowAdapter windowAdapter = new view.HighScoresWindowAdapter(scores);
		this.addWindowListener(windowAdapter);
	}
}
