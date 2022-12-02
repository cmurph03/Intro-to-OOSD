package model;

import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Color;

public class LShapeTest
{
	private LShape lShape;
	private Color color;
	private Color tempColor;
	
	@Before
	public void setUp()
	{
		lShape = new LShape(Color.blue);
	}
	
	@Test
	public void checkOriginPositionBlock1()
	{
		color=Color.blue;
		tempColor = lShape.blockArray.get(0).get(4).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
	
	@Test
	public void checkOriginPositionBlock2()
	{
		color=Color.blue;
		tempColor = lShape.blockArray.get(0).get(5).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
	
	@Test
	public void checkOriginPositionBlock3()
	{
		color=Color.blue;
		tempColor = lShape.blockArray.get(0).get(3).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
	
	@Test
	public void checkOriginPositionBlock4()
	{
		color=Color.blue;
		tempColor = lShape.blockArray.get(1).get(3).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
}
