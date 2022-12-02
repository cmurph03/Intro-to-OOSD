package view;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class NextFigurePanel extends JPanel {
    public NextFigurePanel(int length) 
    {
        this.setPreferredSize(new Dimension(length, length));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        this.setLayout(layout);

        drawNextFigure();
    }

    private void drawNextFigure()
    // prototype, obviously will be changed later
    {
        for (int j = 0; j<4; j++)
        {
            this.add(new Block(56, Color.RED, false));
        }
        for (int j = 0; j<2; j++)
        {
            this.add(new Block(56, Color.RED, false));
            for (int k = 0; k < 2; k++)
            {
                this.add(new Block(56, Color.RED, true));
            }
            this.add(new Block(56, Color.RED, false));
        }
    }
}

