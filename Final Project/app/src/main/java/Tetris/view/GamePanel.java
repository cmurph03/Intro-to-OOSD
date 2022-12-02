package view;
import model.*;
import controller.*;
import model.TetrisArray;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class GamePanel implements TetrisUserInterface 
{
    protected JPanel gameArea;
    protected int x;
    protected int y;

    public GamePanel(int x, int y)
    {
        x = x;
        y = y;
        gameArea = new JPanel();
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        gameArea.setLayout(layout);
        gameArea.setPreferredSize(new Dimension(x, y));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        gameArea.setBorder(border);
    }


    public void updateView(TetrisArray gameScreen) 
    {
        this.cleanUp();

        for (int row = 0; row < 16; row++)
        {
            JPanel rowPanel = new JPanel();
            FlowLayout layout = (FlowLayout)rowPanel.getLayout();
            layout.setVgap(0);
            layout.setHgap(0);
            for (int column = 0; column < 9; column++)
            {
                Block modelBlock = gameScreen.getBlock(row, column);
                Color modelColor = modelBlock.getColor();
                if (modelColor != null)
                {
                    ViewBlock viewBlock = new ViewBlock(modelColor);
                    rowPanel.add(viewBlock);
                }
                else
                {
                    ViewBlock viewBlock = new ViewBlock();
                    rowPanel.add(viewBlock);
                }
            }
            gameArea.add(rowPanel);
        }
        gameArea.revalidate();
        gameArea.repaint();
    }

    private JPanel setUpGameArea(int x, int y)
    {

        return gameArea;
    }

    private void cleanUp()
    {
        int numRows = this.gameArea.getComponentCount();
        this.gameArea.removeAll();
    }
    
    public JPanel getGameArea()
    {
		return gameArea;
    }
}
