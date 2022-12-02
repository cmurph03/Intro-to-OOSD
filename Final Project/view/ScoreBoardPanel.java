package view;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;

public class ScoreBoardPanel extends JPanel{
    public ScoreBoardPanel(int x)
    {
        // TODO: Get Y programmatically so it extends all the way to the bottom
        this.setPreferredSize(new Dimension(x, 600));
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);

        ScoreBoardItem itemTest = new ScoreBoardItem(x, 1200, 15, false);
        this.add(itemTest);
        ScoreBoardItem itemTest2 = new ScoreBoardItem(x, 800, 12, false);
        this.add(itemTest2);
        ScoreBoardItem itemTest3 = new ScoreBoardItem(x, 300, 4, false);
        this.add(itemTest3);
        ScoreBoardItem itemTest4 = new ScoreBoardItem(x, 200, 2, true);
        this.add(itemTest4);
        ScoreBoardItem itemTest5 = new ScoreBoardItem(x, 100, 1, false);
        this.add(itemTest5);
    }
}
