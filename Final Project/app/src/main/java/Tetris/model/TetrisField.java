package model;

import java.util.ArrayList;
import java.awt.Color;

public class TetrisField extends TetrisArray
{
	protected boolean continueMoving;
	protected boolean endGame;
	protected TetrisShape prevShapePos;
	protected TetrisArray prevState;

	public TetrisField()
	{
		super();
		endGame = false;
	}

	public TetrisArray add(TetrisShape shape)
	{
		TetrisArray currentState = new TetrisArray();
		continueMoving = true;

		//Adding Block at the top
		// checks for the center block at row 0 (since all the shapes have a block at the center of row 0)
		// for the straight shape, also have a chance of overlapping at the center of row 4
		int center = this.numCols/2;

		if (this.getBlock(0, center).getColor() != null || (this.getBlock(1, center).getColor() != null && this.getBlock(3, center).getColor() !=null))
		{
			continueMoving = false;
			endGame = true;
			return prevState;
		}
		
		//Combining the TetrisField and TetrisShape.
		//If there is overlap, returns null (controller will return the previous state in that case)
		//and permanently adds the shape to the field.
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
			
			
				if(this.getBlock(i, j).getColor() != null)
				{
					currentState.adjust(i, j, new Block(this.getBlock(i, j).getColor()));
				}
				else if(shape.getBlock(i, j).getColor() != null)
				{
					currentState.adjust(i, j, new Block(shape.getBlock(i, j).getColor()));
				}
			}
		}
		
		for (int i = 0; i < numRows; i++)
		{
			for (int j = 0; j < numCols; j++)
			{

				if(i < 15 && this.getBlock(i + 1, j).getColor() != null && shape.getBlock(i, j).getColor() != null)
				{
					continueMoving = false;
					cementShape(shape);
				}
			}
		}
		
		for (int k = 0; k < numCols; k++)
		{
			if(shape.getBlock(15, k).getColor() != null)
			{
				continueMoving = false;
				cementShape(shape);
			}
		}
		prevShapePos = shape;
		prevState = currentState;
		return currentState;
	}

	public boolean endGame()
	{
		return endGame;
	}

	public boolean continueMoving()
	{
		return continueMoving;
	}

	public boolean canMoveLeft(TetrisShape shape)
	{
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				if(j > 0 && this.getBlock(i, j - 1).getColor() != null && shape.getBlock(i, j).getColor() != null)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean canMoveRight(TetrisShape shape)
	{
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				if(j < numCols - 1 && this.getBlock(i, j + 1).getColor() != null && shape.getBlock(i, j).getColor() != null)
				{
					return false;
				}
			}
		}
		return true;
	}

	//permanently adds the current shape to the field when it touches an occupied block
	private void cementShape(TetrisShape shape)
	{
		for(int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				if(shape.getBlock(i, j).getColor() != null)
				{
					this.adjust(i, j, new Block(shape.getBlock(i, j).getColor()));
				}
			}
		}
	}

	/*
	 *Creates an arraylist containing the row number of each full row
	 */
	public ArrayList<Integer> locateFullRow()
	{

		ArrayList<Integer> rowsFilled = new ArrayList<Integer>();
		boolean addRow = true;

		for(int i = 0; i < numRows; i++)
		{
			addRow = true;

			for(int j = 0; j < numCols; j++)
			{
				if(this.blockArray.get(i).get(j).getColor() == null)
				{
					addRow = false;
				}
			}
			
			if(addRow == true)
			{
				rowsFilled.add(i);
			}
		}
		return rowsFilled;
	}

	/*
	 *Step through the list of full rows, call that row, and set each block in it to null
	 */
	public void clearRows()
	{
		ArrayList<Integer> fullRows = locateFullRow();
		for(int row: fullRows)
		{
			for(int i = 0; i < numCols; i++)
			{
				this.blockArray.get(row).get(i).setColor(null);
			}
		}
		
		//iterate through the array starting from the the row above the lowest cleared row to move each block down
		int numRowsCleared = fullRows.size();
		int start = 14;
		
		if (numRowsCleared > 0)
		{
			start = fullRows.get(numRowsCleared-1);
		}
		
		Color currentColor;
		
		while(numRowsCleared != 0)
		{
			for(int i = start; i >= 0; i--)
			{
				for(int j = 0; j < numCols; j++)
				{
					if(this.blockArray.get(i).get(j).getColor() != null && this.blockArray.get(i + 1).get(j).getColor() == null)
					{
						currentColor = this.blockArray.get(i).get(j).getColor();
						this.blockArray.get(i).get(j).setColor(null);
						this.blockArray.get(i + 1).get(j).setColor(currentColor);
					}
				}
			}
			numRowsCleared--;
		}
	}

	public void clearField()
	{
		for (int i = 0; i < numRows; i++)
		{
			for(int j = 0; j < numCols; j++)
			{
				this.blockArray.get(i).get(j).setColor(null);
			}
		}
	}
}
