package model;

import java.awt.Color;
import java.util.ArrayList;

public class Square extends TetrisShape
{
	public Square(Color color)
	{
		super(color);
		
		//add the shape to the center top of the shapeArray
		center = numCols/2;

		this.blockArray.get(0).get(center).setColor(this.shapeColor);
		this.blockArray.get(0).get(center+1).setColor(this.shapeColor);
		this.blockArray.get(1).get(center).setColor(this.shapeColor);
		this.blockArray.get(1).get(center+1).setColor(this.shapeColor);
	}

	public void rotateShape()
	{
		//Does not have an effect on a square
	}
}


