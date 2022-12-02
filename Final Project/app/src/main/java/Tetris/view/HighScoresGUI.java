package view;
import model.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

public class HighScoresGUI
{
	private JFrame mainFrame;
	private JButton back;

	public HighScoresGUI(HighScoresDisplay easy, HighScoresDisplay medium, HighScoresDisplay hard)
	{
		//top level container
		mainFrame = new JFrame("High Scores Display");
		mainFrame.setPreferredSize(new Dimension(800, 780));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set up container for the high scores page
		JPanel scoresColumns = new JPanel();
		scoresColumns.setBackground(new Color(211,211,211));
		scoresColumns.setLayout(new BorderLayout());

		//add the columns to the page
		scoresColumns.add(easy, BorderLayout.WEST);
		scoresColumns.add(medium, BorderLayout.CENTER);
		scoresColumns.add(hard, BorderLayout.EAST);

		//make a container for the back to main page button
		back = new JButton("Return to Main Page");
		back.setPreferredSize(new Dimension(800, 50));
		back.setFont(new Font("Serif", Font.BOLD, 30));
		scoresColumns.add(back, BorderLayout.SOUTH);
		back.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                mainFrame.dispose();
                MainScreenGUI mainScreenGUI = new MainScreenGUI();
            }
        });

		//make a label for the top of the page
		JLabel pageTitle = new JLabel("HIGH SCORES");
		pageTitle.setHorizontalAlignment(JLabel.CENTER);
		pageTitle.setFont(new Font("Serif", Font.BOLD, 48));
		pageTitle.setPreferredSize(new Dimension(800, 200));
		scoresColumns.add(pageTitle, BorderLayout.NORTH);
		pageTitle.setForeground(Color.black);

		//place the display on the mainFrame
		mainFrame.add(scoresColumns);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	public void addReturnToMainListener(ActionListener l)
	{
		back.addActionListener(l);
	}

	public JFrame displayHighScores()
	{
		return mainFrame;
	}
}


