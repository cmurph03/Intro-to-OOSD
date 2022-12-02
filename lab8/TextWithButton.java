import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class TextWithButton implements ActionListener
{
    JFrame mainFrame;
    JPanel mainPanel;
    JLabel label;
    JTextField answerField;
    JButton submitButton;
    BoxLayout layout;

    public TextWithButton()
    {
	//top level container that establishes the layout
        this.mainFrame = new JFrame("Button Demo");
	this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//special container for everything else with a layout
	this.mainPanel = new JPanel();
	this.mainPanel.setPreferredSize(new Dimension(300, 100));
	this.layout = new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS);
	this.mainPanel.setLayout(this.layout);

	//add the label to the mainPanel first so it's at the top
	this.label = new JLabel("");
	this.label.setAlignmentX(Component.CENTER_ALIGNMENT);
	this.mainPanel.add(this.label);

	//text field for input text
	this.answerField = new JTextField();
	this.answerField.setPreferredSize(new Dimension(300, 30));
	this.mainPanel.add(this.answerField);

	//create a button for submitting the user's answer
	this.submitButton = new JButton("Submit");
	this.submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
	//use an anonymous listener
	this.submitButton.addActionListener(this);

	//Add the button to container
	this.mainPanel.add(this.submitButton);

	//Take up excess space on the bottom with a box filler
	Dimension minSize = new Dimension(300, 10);
	Dimension prefSize = new Dimension(300, 40);
	Dimension maxSize = new Dimension(300, Short.MAX_VALUE);
	this.mainPanel.add(new Box.Filler(minSize, prefSize, maxSize));

	//add the panel to the frame
	this.mainFrame.add(this.mainPanel);
	//auto-size
	this.mainFrame.pack();
	this.mainFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
	//Retrieve the user's answer and return it using a label
	String answer = this.answerField.getText();
	this.label.setText("You entered: " + answer);

	//disable both the submit button and the text field
	this.submitButton.setEnabled(false);
	this.answerField.setEnabled(false);
	this.mainPanel.repaint();
        
	//add the label to the frame
	this.mainFrame.pack();

    }
}
