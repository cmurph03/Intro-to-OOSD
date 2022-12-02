package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.Iterator;

import controller.*;
import model.*;

public class MainScreenGUI
{
	private MainScreenFrame mainScreenFrame;
	private DifficultyPanel difficultyPanel;
	private JLabel gameTitleLabel;
	private JButton playButton;
	private JButton difficultyButton;
	private JLabel levelLabel;
	private JButton seeHighScoresButton;

	private HighScores easy;
	private HighScores medium;
	private HighScores hard;

	private ArrayList<String> difficultiesList = new ArrayList<String>();
	private int difficultiesCounter;
	
	public MainScreenGUI() {
		HighScoreController highScoresController = new HighScoreController();
		this.easy = highScoresController.loadHighScores("easy");
		this.medium = highScoresController.loadHighScores("medium");
		this.hard = highScoresController.loadHighScores("hard");

		gameTitleLabel = new JLabel();
		gameTitleLabel.setText("TETRIS");
		gameTitleLabel.setForeground(new Color(0, 0, 0));
		gameTitleLabel.setFont(new Font("Serif", Font.BOLD, 130));
		gameTitleLabel.setBounds(150, 20, 500, 120);
		Border border = BorderFactory.createLineBorder(Color.black, 3);
		gameTitleLabel.setBorder(border);
		gameTitleLabel.setBackground(new Color(24, 123, 205));
		gameTitleLabel.setOpaque(true);
		gameTitleLabel.setHorizontalAlignment(JLabel.CENTER);

		Border border1 = BorderFactory.createLineBorder(Color.black, 1);
		playButton = new JButton();
		playButton.setText("PLAY!");
		playButton.setForeground(new Color(255, 255, 255));
		playButton.setFont(new Font("sansSerif", Font.PLAIN, 40));
		playButton.setBounds(290, 200, 200, 50);
		playButton.setBackground(new Color(65, 169, 76));
		playButton.setOpaque(true);
		playButton.setBorder(border1);

		playButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mainScreenFrame.dispose();

						HighScores highScoresToUse = null;
						switch (difficultiesList.get(difficultiesCounter)) {
							case ("easy"): {
								highScoresToUse = easy;
							}
							case ("medium"): {
								highScoresToUse = medium;
							}
							case ("hard"): {
								highScoresToUse = hard;
							}
						}
						GameView gameView = new GameView(difficultiesList.get(difficultiesCounter), highScoresToUse);
					}
				});

		difficultyButton = new JButton();
		difficultyButton.setText("Change Level");
		difficultyButton.setForeground(new Color(0, 0, 0));
		difficultyButton.setFont(new Font("sansSerif", Font.PLAIN, 15));
		difficultyButton.setBounds(45, 15, 130, 40);
		difficultyButton.setHorizontalAlignment(JLabel.CENTER);

		Border border2 = BorderFactory.createLineBorder(Color.black, 2);
		levelLabel = new JLabel();
		levelLabel.setForeground(Color.black);
		levelLabel.setFont((new Font("sansSerif", Font.PLAIN, 20)));
		levelLabel.setBounds(220, 15, 130, 40);
		levelLabel.setBorder(border2);
		levelLabel.setHorizontalAlignment(JLabel.CENTER);
		levelLabel.setBackground(Color.white);
		levelLabel.setOpaque(true);

		difficultiesCounter = 0;
		difficultiesList.add("easy");
		difficultiesList.add("medium");
		difficultiesList.add("hard");
		levelLabel.setText(difficultiesList.get(difficultiesCounter));

		difficultyButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (difficultiesCounter == 2) {
							difficultiesCounter = 0;
							levelLabel.setText(difficultiesList.get(difficultiesCounter));
						} else {
							levelLabel.setText(difficultiesList.get(difficultiesCounter + 1));
							difficultiesCounter++;
						}
						System.out.println("Difficulty was changed to " + difficultiesList.get(difficultiesCounter));
					}
				});

		Border border3 = BorderFactory.createLineBorder(Color.black, 1);
		seeHighScoresButton = new JButton();
		seeHighScoresButton.setText("See All Highscores");
		seeHighScoresButton.setForeground(new Color(255, 255, 255));
		seeHighScoresButton.setFont(new Font("sansSerif", Font.PLAIN, 20));
		seeHighScoresButton.setBounds(285, 400, 200, 50);
		seeHighScoresButton.setBackground(new Color(65, 169, 76));
		seeHighScoresButton.setOpaque(true);
		seeHighScoresButton.setBorder(border3);

		seeHighScoresButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						HighScoreController highScoresController = new HighScoreController();

						HighScoresDisplay easyDisplay = new HighScoresDisplay("Easy", 200, highScoresController.getHighScores(easy));
						HighScoresDisplay mediumDisplay = new HighScoresDisplay("Medium", 200, highScoresController.getHighScores(medium));
						HighScoresDisplay hardDisplay = new HighScoresDisplay("Hard", 200, highScoresController.getHighScores(hard));

						mainScreenFrame.dispose();

						HighScoresGUI highScores = new HighScoresGUI(easyDisplay, mediumDisplay, hardDisplay);
					}
				});

		difficultyPanel = new DifficultyPanel();
		difficultyPanel.add(difficultyButton);
		difficultyPanel.add(levelLabel);

		mainScreenFrame = new MainScreenFrame(new HighScores[]{easy, medium, hard});
		mainScreenFrame.add(gameTitleLabel);
		mainScreenFrame.add(playButton);
		mainScreenFrame.add(difficultyPanel);
		mainScreenFrame.add(seeHighScoresButton);
		mainScreenFrame.setLayout(null);
	}

	public String getDifficulty()
	{
		return difficultiesList.get(difficultiesCounter);
	}

}
