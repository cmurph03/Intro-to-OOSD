package model;

import java.awt.Color;
import java.util.ArrayList;

public class Straight extends TetrisShape
{

	public Straight(Color color)
	{
		super(color);

		//add shape to the center top of shapeArray
		center = numCols/2;

		this.blockArray.get(0).get(center).setColor(this.shapeColor);
		this.blockArray.get(1).get(center).setColor(this.shapeColor);
		this.blockArray.get(2).get(center).setColor(this.shapeColor);
		this.blockArray.get(3).get(center).setColor(this.shapeColor);
	}

	public void rotateShape()
	{
		int i = 0;
		boolean located = false;

		while (!located && i<numRows)
		{
			for (int j = 0; j < numCols - 1; j++) 
			{
				if (blockArray.get(i).get(j).getColor() != null && blockArray.get(i + 1).get(j).getColor() != null && blockArray.get(i + 2).get(j).getColor() != null && blockArray.get(i + 3).get(j).getColor() != null)
				{
				    if (j >= 1 && j <= 6 )
				    {
						blockArray.get(i).get(j).setColor(null);
						blockArray.get(i + 2).get(j).setColor(null);
						blockArray.get(i + 3).get(j).setColor(null);

						blockArray.get(i + 1).get(j - 1).setColor(shapeColor);
						blockArray.get(i + 1).get(j + 1).setColor(shapeColor);
						blockArray.get(i + 1).get(j + 2).setColor(shapeColor);
					}

				    else if (j >= 2 && j == 7)
					{
						blockArray.get(i).get(j).setColor(null);
						blockArray.get(i + 2).get(j).setColor(null);
						blockArray.get(i + 3).get(j).setColor(null);

						blockArray.get(i + 1).get(j - 2).setColor(shapeColor);
						blockArray.get(i + 1).get(j - 1).setColor(shapeColor);
						blockArray.get(i + 1).get(j + 1).setColor(shapeColor);
					}

					located = true;
				}
				else if (blockArray.get(i).get(j).getColor() != null && blockArray.get(i).get(j+1).getColor() != null && blockArray.get(i).get(j+2).getColor() != null && blockArray.get(i).get(j+3).getColor() != null)
				{
				    if (blockArray.get(i+1).get(j+1).getColor() == null && blockArray.get(i+2).get(j+1).getColor() == null)
						blockArray.get(i).get(j).setColor(null);
						blockArray.get(i).get(j+2).setColor(null);
						blockArray.get(i).get(j+3).setColor(null);

						blockArray.get(i-1).get(j+1).setColor(shapeColor);
						blockArray.get(i+1).get(j+1).setColor(shapeColor);
						blockArray.get(i+2).get(j+1).setColor(shapeColor);
						located = true;
				}
			}
			i++;
		}
	}
}

