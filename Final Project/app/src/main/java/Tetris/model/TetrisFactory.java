package model;

import java.awt.Color;

public class TetrisFactory
{
	public TetrisShape getShape(String shape, Color color)
	{
		if(shape.equals("LShape"))
		{
			return new LShape(color);
		}
		else if(shape.equals("ZShape"))
		{
			return new ZShape(color);
		}
		else if(shape.equals("SShape"))
		{
			return new SShape(color);
		}
		else if(shape.equals("Square"))
		{
			return new Square(color);
		}
		else if(shape.equals("TShape"))
		{
			return new TShape(color);
		}
		else if(shape.equals("Straight"))
		{
			return new Straight(color);
		}
		return null;
	}
}
