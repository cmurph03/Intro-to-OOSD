import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;

public class MyFrame extends JFrame
{
	public MyFrame()
	{
		this.setTitle("Tetris"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(800,900); 
		this.getContentPane().setBackground(new Color(211,211,211));
		this.setVisible(true); 
	}
}
