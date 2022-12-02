package controller;

import model.*;

import java.awt.event.*;
import javax.swing.Timer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class BlockController implements KeyListener
{
	protected TetrisShape currentTetrisShape;
	protected TetrisShape nextTetrisShape;
	protected TetrisArray currentState;
	protected TetrisArray previousState;
	protected TetrisField tetrisField;
	protected TetrisUserInterface ui;
	protected TetrisFactory factory;
	protected Timer timer;
	protected ScoreController scoreController;
	protected HighScores highScores;
	protected String difficulty;
	private boolean endGame;
	private boolean continueMoving;

	public BlockController(TetrisUserInterface ui, HighScores highScores, String difficulty)
	{
		this.ui = ui;
		this.factory = new TetrisFactory();
		this.tetrisField = new TetrisField();
		this.previousState = new TetrisArray();
		this.endGame = false;
		this.continueMoving = true;

		this.highScores = highScores;
		this.difficulty = difficulty;
	}

	
	//Changes the current shape
	public void addTetrisShape(String shape, Color color)
	{
		currentTetrisShape = factory.getShape(shape, color);
	}

	public String getRandomShape()
	{
		String shapes[] = new String[]{"LShape", "ZShape", "SShape", "Square", "Square", "TShape", "Straight"};
		Random random = new Random();
		int randomShape = random.nextInt(shapes.length);
		return shapes[randomShape];
	}

	public Color getRandomColor()
	{
		Color colors[] = new Color[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA};
		Random random = new Random();
		int randomColor = random.nextInt(colors.length);
		return colors[randomColor];
	}


	/*
	 *Sets the difficulty by determining the period of the timer
	 */
	public void setDifficulty(String difficulty, ActionListener l)
	{

		if(difficulty.equals("easy"))
		{
			timer = new Timer(3000, l);
		}
		else if(difficulty.equals("medium"))
		{
			timer = new Timer(2000, l);
		}
		else if(difficulty.equals("hard"))
		{
			timer = new Timer(1000, l);
		}
		timer.start();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(continueMoving)
		{
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if (tetrisField.canMoveRight(currentTetrisShape))
				{
					currentTetrisShape.moveHorizontally(1);
					updateState();
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if (tetrisField.canMoveLeft(currentTetrisShape))
				{
					currentTetrisShape.moveHorizontally(-1);
					updateState();
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				currentTetrisShape.rotateShape();
				updateState();
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				currentTetrisShape.moveVertically();
				updateState();
			}
		}
	}
	
	/*
	 * moves the currentTetrisShape down one cell, updates the state, the checks for any full rows and updates
	 * if there are any
	 */
	public void timerCallback()
	{
		continueMoving = tetrisField.continueMoving(); 

		if (continueMoving)
		{
		
			currentTetrisShape.moveVertically();
		}

		updateState();
		ArrayList<Integer> fullRows = getFullRows();
		if(fullRows.size() >= 1)
		{
			System.out.println("Clearing rows");
			clearRow();
			scoreController.calculateScore(fullRows.size());
			System.out.println(scoreController.getScore());
			updateState();
		}	
	}

	//Adds a controller to keep track of the scores so that view does not interact directly
	public void addScoreController(ScoreController controller)
	{
		this.scoreController = controller;
	}

	/*
	 *Updates the current state of the TetrisArray then calls updateView
	 *this is done based on the timer and when the shape is affected by the keyListener
	 */
	public void updateState()
	{
			
		currentState = tetrisField.add(currentTetrisShape);
		
		continueMoving = tetrisField.continueMoving();
		endGame = tetrisField.endGame();

		ui.updateView(currentState);
	}

	/*
	 *Returns true when the game is over
	 */
	public boolean endGame()
	{
		return endGame;
	}

	//Returns false when a new block needs to be added
	public boolean continueMoving()
	{
		return continueMoving;
	}

	//Called when the game is over
	public void endTimer()
	{
		System.out.println("Timer Stoped");
		timer.stop();

		// Adding a highscore
		System.out.println(this.scoreController.getScore());
		highScores.addHighScore(this.scoreController.getScore());

		//Saving highscores with HighScoresController
		System.out.println("Trying to save this highscore through HighScoreController");
		HighScoreController highScoreController = new HighScoreController();
		System.out.println(this.difficulty);
		highScoreController.saveHighScores(this.difficulty, highScores);
	}

	public void resetTimer()
	{
		timer.restart();
	}

	//Locate any full rows each time the ui is updated so the score can be calculated
	public ArrayList<Integer> getFullRows()
	{
		ArrayList<Integer> fullRows = new ArrayList<Integer>();
		fullRows = tetrisField.locateFullRow();

		return fullRows;
	}

	//Clear the full rows and move all the blocks down
	public void clearRow()
	{
		tetrisField.clearRows();
	}

	public void restartGame()
	{
		tetrisField.clearField();
		updateState();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		//not used but need to over ride
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		//not used but need to over ride
	}
}
