import javax.swing.*;
import java.awt.*;

public class HighScores extends JPanel
{
    private JList currentScores;
    private String[] scores;
    private int width;

    public HighScores(String title, int width)
    {
       
	//each set of high scores will be a separate panel.
	//in the class that sets up the game display, HighScores will
	//be called 3 times to create 3 panels to display in a 
	//border layout to  display three columns

	this.setBackground(new Color(211, 211, 211));
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
	//Create the title for the column
	JLabel columnTitle = new JLabel(title);
	columnTitle.setForeground(Color.black);
	columnTitle.setAlignmentX((float)0.5);
	columnTitle.setFont(new Font("Serif", Font.PLAIN, 36));

	//initialize the highscores and set all to 0
	this.scores = new String[10];
	this.currentScores = new JList(this.scores);
	//this.currentScores.setEnabled(false);
	this.currentScores.setForeground(Color.black);
	this.currentScores.setPreferredSize(new Dimension(width,width*4));
	this.currentScores.setBackground(new Color(211,211,211));
	this.currentScores.setAlignmentX((float)0.5);
	this.currentScores.setFont(new Font("Serif", Font.PLAIN, 32));

	//add the label and the list to the column
	this.add(columnTitle);
	this.add(this.currentScores);

    }

    public void add(int score)
    {
	try {

	    for(int i = 0; i<10; i++)
	    {
		int num = Integer.valueOf(i);
	        if(num < score)
	        {
		    this.scores[i] = Integer.toString(score);
		    break;
	        }
	    }
	}
	    catch(NumberFormatException e) {
		    System.out.println("Error with adding to high score");
	    }
	    
	this.currentScores.revalidate();
        this.currentScores.repaint();
    }
}

