package model;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class HighScoresTest 
{
    private HighScores highScores;

    @Before
    public void setUp()
    {
        this.highScores = new HighScores();
    }

    @Test
    public void testAddHighScore()
    {
        int score = 100;
        this.highScores.addHighScore(score);
        ArrayList<Integer> scores = this.highScores.getHighScores();

        assertEquals(scores.size(), 1, 0.0);
        assertEquals(scores.get(0), 100, 0.0);
    }

    @Test
    public void testGetHighScore()
    {
        int score = 100;
        int score2 = 200;
        this.highScores.addHighScore(score);
        this.highScores.addHighScore(score2);
        ArrayList<Integer> scores = this.highScores.getHighScores();

        assertEquals(scores.size(), 2, 0.0);
    }

    @Test
    public void testAddingMoreThanTenHighScores()
    {
        for (int i = 0; i < 10; i++)
        {
            this.highScores.addHighScore(i * 100);
        }

        int eleventhScore = 1100;
        this.highScores.addHighScore(eleventhScore);
        ArrayList<Integer> scores = this.highScores.getHighScores();

        assertEquals(scores.size(), 10, 0.0);
    }
}
