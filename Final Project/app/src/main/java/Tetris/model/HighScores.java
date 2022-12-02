package model;

import java.io.Serializable;
import java.util.*;

public class HighScores implements Serializable
{
	private ArrayList<Integer> scores;

	public HighScores()
	{
		scores = new ArrayList<Integer>();  
	}

	public ArrayList<Integer> getHighScores()
	{
		return scores;
	}

	public void addHighScore(int score)
	{
		//add the new score to the list
		this.scores.add(score);

		//sort the scores into order
		Collections.sort(this.scores);

		//remove the last integer from the list if longer than 10
		if(scores.size() > 10)
		{
			this.scores.remove(10);
		}
	}
}

