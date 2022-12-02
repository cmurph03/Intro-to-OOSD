package model;

import java.awt.Color;
import java.util.ArrayList;

public class SShape extends TetrisShape
{
	public SShape(Color color)
	{
		super(color);

		//add shape to the center top of the shapeArray
		center = numCols/2;

		this.blockArray.get(1).get(center-1).setColor(this.shapeColor);
		this.blockArray.get(1).get(center).setColor(this.shapeColor);
		this.blockArray.get(0).get(center).setColor(this.shapeColor);
		this.blockArray.get(0).get(center+1).setColor(this.shapeColor);
	}
	
	public void rotateShape()
	{
		int i = 0;
		boolean located = false;

		while (located == false)
		{
			for (int j=0; j<numCols-1; j++)
			{
				if(blockArray.get(i).get(j).getColor() != null && blockArray.get(i).get(j+1).getColor() != null)
				{
					if(i!=0 && (blockArray.get(i+1).get(j).getColor() != null))
					{
						blockArray.get(i+1).get(j-1).setColor(null);
						blockArray.get(i+1).get(j).setColor(null);
						blockArray.get(i-1).get(j).setColor(shapeColor);
						blockArray.get(i+1).get(j+1).setColor(shapeColor);
						located = true;
					}
					else if (i!= 0 && j != 0)
					{
						blockArray.get(i-1).get(j).setColor(null);
						blockArray.get(i+1).get(j+1).setColor(null);
						blockArray.get(i+1).get(j-1).setColor(shapeColor);
						blockArray.get(i+1).get(j).setColor(shapeColor);
						located = true;
					}
					else
					{
						located = true;
					}
				}
			}
			i++;
		}
	}
}

