package model;

import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Color;

public class SShapeTest
{
	private SShape sShape;
	private Color color;
	private Color tempColor;
	
	@Before
	public void setUp()
	{
		sShape = new SShape(Color.blue);
	}
	
	@Test
	public void checkOriginPositionBlock1()
	{
		color=Color.blue;
		tempColor = sShape.blockArray.get(1).get(3).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
	
	@Test
	public void checkOriginPositionBlock2()
	{
		color=Color.blue;
		tempColor = sShape.blockArray.get(1).get(4).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
	
	@Test
	public void checkOriginPositionBlock3()
	{
		color=Color.blue;
		tempColor = sShape.blockArray.get(0).get(4).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
	
	@Test
	public void checkOriginPositionBlock4()
	{
		color=Color.blue;
		tempColor = sShape.blockArray.get(0).get(5).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}

	@Test
	public void checkNoAdditonalBlocks()
	{
		boolean works = true;
		for(int i=2; i<16; i++)
		{
			for (int j=0; j<9; j++)
			{
				if (sShape.getBlock(i, j).getColor() != null)
				{	
					works = false;
				}
			}
		}
		assertTrue("Blocks populated below the initial block", works);
	}

	@Test
	public void testMoveVertically()
	{
		boolean works = true;
		sShape.moveVertically();
		if(sShape.getBlock(0,4).getColor() != null)
		{
			works = false;
		}
		assertTrue("Move vertically does not get rid of previous blocks", works);
	}

	@Test
	public void testMoveLeft()
	{
		boolean works = true;
		sShape.moveHorizontally(-1);
		if(sShape.getBlock(0,5).getColor() != null)
		{
			works = false;
		}
		assertTrue("Move left does not work", works);
	}

	@Test
	public void testMoveRight()
	{
		boolean works = true;
		sShape.moveHorizontally(1);
		if(sShape.getBlock(0,4).getColor() != null)
		{
			works = false;			
		}
		assertTrue("Move right does not work", works);
	}
}
