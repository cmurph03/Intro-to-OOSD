package view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;

public class ViewBlock extends JPanel
{
    private Color color;
    
    public ViewBlock()
    {
        this.setPreferredSize(new Dimension(48, 48));
        this.setBackground(Color.WHITE);
    }

    public ViewBlock(Color color)
    {
        this.color = color;

        this.setPreferredSize(new Dimension(48, 48));
        this.setBackground(this.color);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        this.setBorder(border);
    }
}
