package model;

public class Scores
{
	private int currentScore;

	public Scores()
	{
		currentScore = 0;
	}

	public int getScore()
	{
		return this.currentScore;
	}

	public void calculateScore(int rows)
	{
		 //A single row is 10 pts while each additional row is 50% more
		 // So the second row is 15 pts, a third 20, etc.
		 // The total score is calculated using a multiplication factor f
		 float f = 1;   
		 for (int i=0; i<rows; i++)
		 {
		    float factor = 10*f;
		    this.currentScore = this.currentScore + (int)factor;
		    f = f + 0.5f;
		 }
	}

	public void resetScore()
	{
		currentScore = 0;
	}
}
