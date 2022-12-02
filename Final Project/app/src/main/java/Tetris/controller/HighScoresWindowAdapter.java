package view;

import model.*;

import java.awt.event.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class HighScoresWindowAdapter extends WindowAdapter
{
	HighScores[] scores;
	String[] fileNames;

	public HighScoresWindowAdapter(HighScores[] scores)
	{
		System.out.println("Window Adapter added");
		this.scores = scores;
		this.fileNames = new String[]{"easy", "medium", "hard"};
	}
	
	@Override
	public void windowClosing(WindowEvent e)
	{
		for (int i = 0; i < this.fileNames.length; i++) 
		{
			System.out.println("Saving a highscores for " + this.fileNames[i]);
			try 
			{
				FileOutputStream fileOutputStream = new FileOutputStream(this.fileNames[i]);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(this.scores[i]);
				objectOutputStream.close();
				fileOutputStream.close();
				System.out.println("Highscores for " + this.fileNames[i] + " were saved");
			} 
			catch (IOException exception) 
			{
				System.out.println("Could not save highscores");
				System.out.println(exception);
			}
		}
	}
}

