package view;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class ButtonsPanel extends JPanel
{
    public ButtonsPanel(int x)
    {
        //TODO: Change y to make responsive
        this.setPreferredSize(new Dimension(x, 40));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);

        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        this.setLayout(layout);

        JButton restartButton = new JButton("Restart");
        restartButton.setPreferredSize(new Dimension(x / 2 - 10, 40 - 10));
        this.add(restartButton);
        JButton quitButton = new JButton("Quit");
        quitButton.setPreferredSize(new Dimension(x / 2 - 10, 40 - 10));
        this.add(quitButton);
    }    
}
