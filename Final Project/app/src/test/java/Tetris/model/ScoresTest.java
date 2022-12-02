package model;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ScoresTest
{
	private Scores scores;

	@Before
	public void setUp()
	{
		scores = new Scores();
	}

	@Test
	public void testGetScore()
	{
		assertEquals("Error: getScore does not work", 0, scores.getScore());
	}

	@Test
	public void testCalculateScore()
	{
		scores.calculateScore(1);
		assertEquals("Error: calculateScore does not work", 10, scores.getScore()); 
	}

	@Test
	public void testMultipleRowsCalculateScore()
	{
		scores.calculateScore(2);
		assertEquals("Error: calculateScores does not work with multiple rows", 25, scores.getScore());
	}

	@Test
	public void testMultipleCalcScoresCalls()
	{
		scores.calculateScore(1);
		scores.calculateScore(2);
		assertEquals("Error: multiple calls of calculateScore does not work", 35, scores.getScore());
	}
}

