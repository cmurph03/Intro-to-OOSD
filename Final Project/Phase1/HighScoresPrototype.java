import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;

public class HighScoresPrototype
{
    private JFrame mainFrame;

    public HighScoresPrototype()
    {
	//top level container
	mainFrame = new JFrame("High Scores Display");
	mainFrame.setPreferredSize(new Dimension(800, 900));
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	//set up objects for each high score column
	HighScores easy = new HighScores("Easy", 200);
	HighScores medium = new HighScores("Medium", 200);
	HighScores hard = new HighScores("Hard", 200);


	// set up container for the high scores page
	JPanel highScoresDisplay = new JPanel();
	highScoresDisplay.setBackground(new Color(211,211,211));
	highScoresDisplay.setLayout(new BorderLayout());


	//add the columns to the page
	highScoresDisplay.add(easy, BorderLayout.WEST);
        highScoresDisplay.add(medium, BorderLayout.CENTER);
        highScoresDisplay.add(hard, BorderLayout.EAST);

	//give some fake numbers for display
	easy.add(100);
	medium.add(200);
	hard.add(300);

	//make a container for the back to main page button
	JButton back = new JButton("Return to Main Page");
	back.setPreferredSize(new Dimension(800, 50));
	back.setFont(new Font("Serif", Font.BOLD, 30));
	highScoresDisplay.add(back, BorderLayout.SOUTH);

	//make a label for the top of the page
	JLabel pageTitle = new JLabel("HIGH SCORES");
	pageTitle.setHorizontalAlignment(JLabel.CENTER);
	pageTitle.setFont(new Font("Serif", Font.BOLD, 48));
	pageTitle.setPreferredSize(new Dimension(800, 200));
	highScoresDisplay.add(pageTitle, BorderLayout.NORTH);
	pageTitle.setForeground(Color.black);

	//place the display on the mainFrame
	mainFrame.add(highScoresDisplay);
	mainFrame.pack();
	mainFrame.setVisible(true);


    }

    public JFrame getFrame()
    {
	return mainFrame;
    }
}
