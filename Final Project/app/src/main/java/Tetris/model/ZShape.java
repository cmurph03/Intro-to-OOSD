package model;

import java.awt.Color;
import java.util.ArrayList;

public class ZShape extends TetrisShape
{
	public ZShape(Color color)
	{
		super(color);
		
		//add the shape to the center top of the array
		center = numCols/2;

		this.blockArray.get(0).get(center-1).setColor(color);
		this.blockArray.get(0).get(center).setColor(color);
		this.blockArray.get(1).get(center).setColor(color);
		this.blockArray.get(1).get(center+1).setColor(color);
	}

	public void rotateShape()
	{
		int i = 0;
		boolean located = false;

		while (!located && i<numRows)
		{
			for (int j=0; j<numCols-2; j++)
			{
				if(blockArray.get(i).get(j).getColor() != null && blockArray.get(i).get(j+1).getColor() != null)
				{
					if(i!=0 && j != 0 && (blockArray.get(i-1).get(j+1).getColor() != null))
					{
						blockArray.get(i-1).get(j+1).setColor(null);
						blockArray.get(i).get(j+1).setColor(null);
						blockArray.get(i+1).get(j+1).setColor(shapeColor);
						blockArray.get(i).get(j-1).setColor(shapeColor);
						located = true;
					}
					else if (i!=0 && j < numCols - 3 && blockArray.get(i+1).get(j+2).getColor() != null)
					{
						blockArray.get(i+1).get(j+1).setColor(null);
						blockArray.get(i+1).get(j+2).setColor(null);
						blockArray.get(i-1).get(j+1).setColor(shapeColor);
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
