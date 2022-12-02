package view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class SidePanel extends JPanel 
{
	protected NextFigurePanel nextFigurePanel;

	public SidePanel(int x, int y, ActionListener restart, ActionListener quit)
	{
		this.setPreferredSize(new Dimension(x, y));
		FlowLayout layout = new FlowLayout();
		layout.setVgap(0);
		this.setLayout(layout);

		Border border = BorderFactory.createLineBorder(Color.BLACK);
		this.setBorder(border);

		nextFigurePanel = new NextFigurePanel(x);
		this.add(nextFigurePanel);
		ButtonsPanel buttonsPanel = new ButtonsPanel(x, restart, quit);
		this.add(buttonsPanel);
		//GameScoreBoardPanel scoreBoardPanel = new GameScoreBoardPanel(x);
		//this.add(scoreBoardPanel);
	}

	public void drawNextFigure(String shape, Color color)
	{
		nextFigurePanel.drawNextFigure(shape, color);
	}
}
