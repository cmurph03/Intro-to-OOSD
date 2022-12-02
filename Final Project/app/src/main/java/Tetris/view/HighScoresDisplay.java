package view;

import model.*;
import controller.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HighScoresDisplay extends JPanel
{
	private JList<Integer> currentScores;

	public HighScoresDisplay(String title, int width, DefaultListModel<Integer> scores)
	{
		//each set of high scores will be a separate panel.
		//in the class that sets up the game display, HighScoresDisplay will
		//be called 3 times to create 3 panels to display in a
		//border layout to  display the three columns

		this.setBackground(new Color(211, 211, 211));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		//Create the title for the column
		JLabel columnTitle = new JLabel(title);
		columnTitle.setForeground(Color.black);
		columnTitle.setAlignmentX((float)0.5);
		columnTitle.setFont(new Font("Serif", Font.PLAIN, 36));

		//initialize the highscores using the passed in array
		currentScores = new JList(scores);

		//this.currentScores.setEnabled(false);
		currentScores.setForeground(Color.black);
		currentScores.setPreferredSize(new Dimension(width,width*4));
		currentScores.setBackground(new Color(211,211,211));
		currentScores.setAlignmentX((float)0.5);
		currentScores.setFont(new Font("Serif", Font.PLAIN, 32));

		//add the label and the list to the column
		this.add(columnTitle);
		this.add(this.currentScores);
	}
}
