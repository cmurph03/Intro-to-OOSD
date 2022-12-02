package model;

import java.awt.Color;

public abstract class TetrisShape extends TetrisArray
{
	int center;
	
	protected Color shapeColor;

	public TetrisShape(Color color)
	{
		this.shapeColor = color;
	}

	public void moveVertically()
	{	
		//Make sure that it can't move out of bounds by checking that the last row is empty
		boolean canMove = true;
		for(int j=0; j<numCols; j++)
		{
			if(this.blockArray.get(numRows-1).get(j).getColor() != null)
			{
				canMove = false;
			}
		}
		
		if (canMove == true)
		{
			for (int i=14; i>=0; i--)
			{
				for (int j=0; j<numCols; j++)
		 		{
					if(this.blockArray.get(i).get(j).getColor() != null)
					{
						this.blockArray.get(i).get(j).setColor(null);
						this.blockArray.get(i+1).get(j).setColor(this.shapeColor);
					}
		 		}	
		 	}
		}
	}

	public void moveHorizontally(int direction)
	{
		boolean canMove = true;

		//to move left
		if(direction < 0)
		{
			for (int i=0; i<numRows; i++)
			{
				if(this.blockArray.get(i).get(0).getColor() != null)
				{
					canMove = false;
				}
			}

			if (canMove == true)
			{
				for (int i=0; i<numRows; i++)
				{
					for (int j=1; j<numCols; j++)
					{
						if(this.blockArray.get(i).get(j).getColor() != null)
						{
							this.blockArray.get(i).get(j).setColor(null);
							this.blockArray.get(i).get(j-1).setColor(this.shapeColor);
						}
					}
				}
			}
		}
		//to move right
		else if(direction > 0)
		{
			for (int i=0; i<numRows; i++)
			{
				if(this.blockArray.get(i).get(numCols-1).getColor() != null)
				{
					canMove = false;
				}
			}

			if (canMove == true)
			{
				for (int i=0; i<numRows; i++)
				{
					for (int j=numCols-2; j>=0; j--)
					{
						if(this.blockArray.get(i).get(j).getColor() != null)
						{
							this.blockArray.get(i).get(j).setColor(null);
							this.blockArray.get(i).get(j+1).setColor(this.shapeColor);
						}
					}
				}
			}
		}
	}
	
	public abstract void rotateShape();
}
