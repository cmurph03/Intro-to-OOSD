package controller;

import model.*;

public class ScoreController
{
	protected Scores currentScore;

	public ScoreController()
	{
		currentScore = new Scores();
	}

	public int getScore()
	{
		return currentScore.getScore();
	}

	public void calculateScore(int rows)
	{
		currentScore.calculateScore(rows);
	}

	public void resetScore()
	{
		currentScore.resetScore();
	}
}
