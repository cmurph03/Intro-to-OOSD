package view;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class GamePanel extends JPanel {
    public GamePanel(int x, int y)
    {
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(x, y));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
        //TODO: just for prototype, remove afterwards

        for (int i = 0; i < 10; i++)
        {
            for (int j=0; j<9; j++)
            {
                Block b = new Block(56, Color.RED, false);
                this.add(b);
            }
        }
        drawFourthToLastRow();
        drawThirdToLastRow();
        drawSecondToLastRow();
        drawLastRow();
    }   
    private void drawFourthToLastRow()
    {
        for (int j=0; j<5; j++)
        {
            this.add(new Block(56, Color.YELLOW, false));
        }
        this.add(new Block(56, Color.ORANGE, true));
        for (int j=0; j<2; j++)
        {
            this.add(new Block(56, Color.YELLOW, false));
        }
        this.add(new Block(56, Color.RED, true));
    }

    private void drawThirdToLastRow()
    {
        this.add(new Block(56, Color.GREEN, false));
        for (int j=0; j<2; j++)
        {
            this.add(new Block(56, Color.YELLOW, true));
        }
        for (int j=0; j<2; j++)
        {
            this.add(new Block(56, Color.MAGENTA, true));
        }
        for (int j=0; j<2; j++)
        {
            this.add(new Block(56, Color.ORANGE, true));
        }
        this.add(new Block(56, Color.YELLOW, false));
        this.add(new Block(56, Color.RED, true));

    }

    private void drawSecondToLastRow()
    {
        for (int j=0; j<2; j++)
        {
            this.add(new Block(56, Color.YELLOW, true));
        }
        this.add(new Block(56, Color.GREEN, true));
        this.add(new Block(56, Color.MAGENTA, true));
        for (int j=0; j<2; j++)
        {
            this.add(new Block(56, Color.YELLOW, false));
        }
        this.add(new Block(56, Color.ORANGE, true));
        this.add(new Block(56, Color.BLUE, true));
        this.add(new Block(56, Color.RED, true));

    }    

    private void drawLastRow()
    {
        for (int j=0; j<3; j++)
        {
            this.add(new Block(56, Color.GREEN, true));
        }
        this.add(new Block(56, Color.MAGENTA, true));
        this.add(new Block(56, Color.MAGENTA, false));

        for (int j=0; j<3; j++)
        {
            this.add(new Block(56, Color.BLUE, true));
        }
        this.add(new Block(56, Color.RED, true));

    }
}
