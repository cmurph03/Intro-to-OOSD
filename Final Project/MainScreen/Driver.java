import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class Driver
{
	public static void main(String[] args)
	{
		MyFrame myFrame = new MyFrame();
		ScoreBoard scoreBoard = new ScoreBoard();
		DifficultyPanel difficultyPanel = new DifficultyPanel();
		
		JLabel titleLabel = new JLabel();
		titleLabel.setText("TETRIS");
		titleLabel.setForeground(new Color(0,0,0));
		titleLabel.setFont(new Font("Serif",Font.BOLD,130));
		titleLabel.setBounds(150,20,500,120);
		Border border = BorderFactory.createLineBorder(Color.black,3);
		titleLabel.setBorder(border);
		titleLabel.setBackground(new Color(24,123,205));
		titleLabel.setOpaque(true);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		Border border1 = BorderFactory.createLineBorder(Color.black,1);
		JButton playButton = new JButton();
		playButton.setText("PLAY!");
		playButton.setForeground(new Color(255,255,255));
		playButton.setFont(new Font("sansSerif",Font.PLAIN,40));
		playButton.setBounds(290,200,200,50);
		playButton.setBackground(new Color(65,169,76));
		playButton.setOpaque(true);
		playButton.setBorder(border1);
		
		JButton difficultyButton = new JButton();
		difficultyButton.setText("Change Level");
		difficultyButton.setForeground(new Color(0,0,0));
		difficultyButton.setFont(new Font("sansSerif",Font.PLAIN,15));
		difficultyButton.setBounds(45,15,130,40);
		difficultyButton.setHorizontalAlignment(JLabel.CENTER);
		
		Border border2 = BorderFactory.createLineBorder(Color.black,2);
		JLabel level = new JLabel();
		level.setText("Intermediate");
		level.setForeground(Color.black);
		level.setFont((new Font("sansSerif",Font.PLAIN,20)));
		level.setBounds(220,15,130,40);
		level.setBorder(border2);
		level.setHorizontalAlignment(JLabel.CENTER);
		level.setBackground(Color.white);
		level.setOpaque(true);
		
		JLabel highScoreLabelTitle = new JLabel();
		highScoreLabelTitle.setText("High Score");
		highScoreLabelTitle.setForeground(new Color(255,255,255));
		highScoreLabelTitle.setFont(new Font("MV Boli",Font.PLAIN,20));
		highScoreLabelTitle.setBounds(25,-10,400,70);
		
		JLabel highScoreLabel = new JLabel();
		highScoreLabel.setText("205");
		highScoreLabel.setForeground(new Color(0,0,0));
		highScoreLabel.setFont(new Font("Serif",Font.PLAIN,16));
		highScoreLabel.setBackground(Color.white);
		highScoreLabel.setOpaque(true);
		highScoreLabel.setBounds(25,50,100,45);
		highScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		
		difficultyPanel.add(difficultyButton);
		difficultyPanel.add(level);
		
		scoreBoard.add(highScoreLabelTitle);
		scoreBoard.add(highScoreLabel);

		myFrame.add(titleLabel);
		myFrame.add(playButton);
		myFrame.add(difficultyPanel);
		myFrame.add(scoreBoard);
		myFrame.setLayout(null);
	}
}
