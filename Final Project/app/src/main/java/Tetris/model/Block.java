package model;

import java.awt.Color;

public class Block 
{
	protected Color blockColor;

	public Block(Color color)
	{
		this.blockColor = color;
	}

	public Block()
	{
		this.blockColor = null;
	}

	public void setColor(Color color)
	{
		this.blockColor = color;
	}

	public Color getColor()
	{
		return this.blockColor;
	}
}
