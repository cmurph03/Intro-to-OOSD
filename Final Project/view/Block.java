package view;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;

public class Block extends JPanel {
    public Block(int side, Color color, boolean active)
    {
        this.setPreferredSize(new Dimension(side, side));
        if (active)
        {
            this.setBackground(color);
            Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
            this.setBorder(border);
        }
    }    
}
