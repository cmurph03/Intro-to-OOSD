package view;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;

public class ScoreBoardItem extends JPanel{
    public ScoreBoardItem(int x, int score, int rowsCleaned, boolean active)
    {
        if (active)
        {
            this.setBackground(Color.YELLOW);
        }
        this.setPreferredSize(new Dimension(x, 30));
        JTextArea info = new JTextArea("Score: ");
        info.append(String.valueOf(score));
        info.append(", rows cleaned: ");
        info.append(String.valueOf(rowsCleaned));
        info.setEditable(false);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);

        this.add(info);
    }
}
