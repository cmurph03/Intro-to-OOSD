package model;

import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Color;

public class TetrisFactoryTests
{
	private TetrisFactory factory;

	@Before
	public void setUp()
	{
		factory = new TetrisFactory();
	}

	@Test
	public void testGetLShape()
	{
		TetrisShape shape = factory.getShape("LShape", Color.RED);
		LShape lshape = new LShape(Color.RED);
		boolean matches = false;
		for (int i=0; i<shape.getNumRows(); i++)
		{
			for (int j=0; j<shape.getNumColumns(); j++)
			{
				if (shape.getBlock(i,j).getColor() == lshape.getBlock(i,j).getColor())
				{
					matches = true;
				}
				else
				{
					matches = false;
				}
			}
		}
		assertTrue("Error: did not load LShape properly", matches);
	}

	@Test
	public void testGetSShape()
	{
		TetrisShape shape = factory.getShape("SShape", Color.RED);
		SShape newShape = new SShape(Color.RED);
		boolean matches = false;
		for (int i=0; i<shape.getNumRows(); i++)
		{
			for (int j=0; j<shape.getNumColumns(); j++)
			{
				if (shape.getBlock(i,j).getColor() == newShape.getBlock(i,j).getColor())
				{
					matches = true;
				}
				else
				{
					matches = false;
				}
			}
		}
		assertTrue("Error: did not load SShape properly", matches);
	}

	@Test
	public void testGetStraightShape()
	{
		TetrisShape shape = factory.getShape("Straight", Color.RED);
		Straight newShape = new Straight(Color.RED);
		boolean matches = false;
		for (int i=0; i<shape.getNumRows(); i++)
		{
			for (int j=0; j<shape.getNumColumns(); j++)
			{
				if (shape.getBlock(i,j).getColor() == newShape.getBlock(i,j).getColor())
				{
					matches = true;
				}
				else
				{
					matches = false;
				}
			}
		}
		assertTrue("Error: did not load Straight shape properly", matches);
	}

	@Test
	public void testGetSquareShape()
	{
		TetrisShape shape = factory.getShape("Square", Color.RED);
		Square newShape = new Square(Color.RED);
		boolean matches = false;
		for (int i=0; i<shape.getNumRows(); i++)
		{
			for (int j=0; j<shape.getNumColumns(); j++)
			{
				if (shape.getBlock(i,j).getColor() == newShape.getBlock(i,j).getColor())
				{
					matches = true;
				}
				else
				{
					matches = false;
				}
			}
		}
		assertTrue("Error: did not load Square shape properly", matches);
	}

	@Test
	public void testGetTShape()
	{
		TetrisShape shape = factory.getShape("TShape", Color.RED);
		TShape newShape = new TShape(Color.RED);
		boolean matches = false;
		for (int i=0; i<shape.getNumRows(); i++)
		{
			for (int j=0; j<shape.getNumColumns(); j++)
			{
				if (shape.getBlock(i,j).getColor() == newShape.getBlock(i,j).getColor())
				{
					matches = true;
				}
				else
				{
					matches = false;
				}
			}
		}
		assertTrue("Error: did not load TShape properly", matches);
	}

	@Test
	public void testGetZShape()
	{
		TetrisShape shape = factory.getShape("ZShape", Color.RED);
		ZShape newShape = new ZShape(Color.RED);
		boolean matches = false;
		for (int i=0; i<shape.getNumRows(); i++)
		{
			for (int j=0; j<shape.getNumColumns(); j++)
			{
				if (shape.getBlock(i,j).getColor() == newShape.getBlock(i,j).getColor())
				{
					matches = true;
				}
				else
				{
					matches = false;
				}
			}
		}
		assertTrue("Error: did not load ZShape properly", matches);
	}


	
}
