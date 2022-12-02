package view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;

public class GameScoreBoardPanel extends JPanel{
    public GameScoreBoardPanel(int x)
    {
        this.setPreferredSize(new Dimension(x, 600));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
    }
}
