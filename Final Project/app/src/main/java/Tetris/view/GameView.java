package view;
import model.*;
import controller.*;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class GameView extends JPanel
{
	private int resolutionX;
	private int resolutionY;
	private ArrayList<String> currentBlocks;
	private ArrayList<Color> currentColors;

	public BlockController controller;
	private GamePanel gamePanel;
	private JFrame frame;

	public GameView(String difficulty, HighScores highScores)
	{
		resolutionX = 800;
		resolutionY = 780;

		frame = new JFrame("Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(resolutionX, resolutionY));
		
		ScoreController scoreController = new ScoreController();

		gamePanel = new GamePanel((int)(resolutionX * 0.7) - 20, 770);
		this.add(gamePanel.getGameArea());
		
		controller = new BlockController(gamePanel, highScores, difficulty);
		
		//Action listener for the restart button on the side panel
		ActionListener restart = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				GameView gameView = new GameView(difficulty, highScores);
			}
		};
		
		//Action listener for the quit button on the side panel
		ActionListener quit = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
                MainScreenGUI mainScreenGUI = new MainScreenGUI();
			}
		};
		
		//Displays score
		Border scoreBorder = BorderFactory.createLineBorder(Color.black, 2);
		JLabel scoreLabel = new JLabel();
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		scoreLabel.setText(String.valueOf(scoreController.getScore()));
		scoreLabel.setBackground(Color.white);
		scoreLabel.setOpaque(true);
		scoreLabel.setFont((new Font("sansSerif", Font.PLAIN, 40)));
		scoreLabel.setBorder(scoreBorder);
		
		SidePanel sidePanel = new SidePanel((int)(resolutionY* 0.3) - 20, resolutionY, restart, quit);
		this.add(sidePanel);
		this.setBackground(Color.LIGHT_GRAY);
		sidePanel.add(scoreLabel);
		
		currentBlocks = new ArrayList<String>();
		currentColors = new ArrayList<Color>();
		
		//action listener for the timer (passed to controller when setting difficulty)	
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(controller.continueMoving() == false)
				{
					//Set up the next shape and its color
					String nextShape = controller.getRandomShape();
					Color nextColor = controller.getRandomColor();
					currentBlocks.add(nextShape);
					currentColors.add(nextColor);
					String nextShape2 = controller.getRandomShape();
					Color nextColor2 = controller.getRandomColor();
					currentBlocks.add(nextShape2);
					currentColors.add(nextColor2);
					sidePanel.drawNextFigure(currentBlocks.get(1), currentColors.get(1));
					controller.addTetrisShape(currentBlocks.get(0), currentColors.get(0));
					currentBlocks.remove(0);
					currentColors.remove(0);
				}

				if(controller.endGame() == true)
				{
					controller.endTimer();
					int choice = JOptionPane.showConfirmDialog(frame, "You lose. Play again?", "Results", JOptionPane.YES_NO_OPTION);
					if(choice == 0)
					{
						frame.dispose();
						GameView gameView = new GameView(difficulty, highScores);
					}
					else
					{
						frame.dispose();
						
						HighScoreController highScoresController = new HighScoreController();
						
						HighScores easy = highScoresController.loadHighScores("easy");
						HighScores medium = highScoresController.loadHighScores("medium");
						HighScores hard = highScoresController.loadHighScores("hard");

						HighScoresDisplay easyDisplay = new HighScoresDisplay("Easy", 200, highScoresController.getHighScores(easy));
						HighScoresDisplay mediumDisplay = new HighScoresDisplay("Medium", 200, highScoresController.getHighScores(medium));
						HighScoresDisplay hardDisplay = new HighScoresDisplay("Hard", 200, highScoresController.getHighScores(hard));
						
						HighScoresGUI highScores = new HighScoresGUI(easyDisplay, mediumDisplay, hardDisplay);
					}
				}
				controller.timerCallback();
				scoreLabel.setText(String.valueOf(scoreController.getScore()));
			}
		};
		
		// setting difficulty from value passed by MainScreenGUI
		controller.setDifficulty(difficulty, listener);
		controller.addScoreController(scoreController);
		
		//randomly call the first shape
		String firstShape = controller.getRandomShape();
		Color firstColor = controller.getRandomColor();
		currentBlocks.add(firstShape);
		currentColors.add(firstColor);
		String secondShape = controller.getRandomShape();
		Color secondColor = controller.getRandomColor();
		currentBlocks.add(secondShape);
		currentColors.add(secondColor);
		
		//add the first shape
		sidePanel.drawNextFigure(currentBlocks.get(1), currentColors.get(1));
		controller.addTetrisShape(firstShape, firstColor);
		controller.updateState();
		currentBlocks.remove(0);
		currentColors.remove(0);
		
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(controller);
		frame.setFocusable(true);
	}
}
