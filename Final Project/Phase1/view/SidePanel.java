package view;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class SidePanel extends JPanel {
    public SidePanel(int x, int y)
    {
        this.setPreferredSize(new Dimension(x, y));
        FlowLayout layout = new FlowLayout();
        layout.setVgap(0);
        this.setLayout(layout);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);

        NextFigurePanel nextFigurePanel = new NextFigurePanel(x);
        this.add(nextFigurePanel);
        ButtonsPanel buttonsPanel = new ButtonsPanel(x);
        this.add(buttonsPanel);
        ScoreBoardPanel scoreBoardPanel = new ScoreBoardPanel(x);
        this.add(scoreBoardPanel);
    }
}
