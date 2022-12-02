package model;

import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Color;

public class StraightTest
{
	private Straight straight;
	private Color color;
	private Color tempColor;
	
	@Before
	public void setUp()
	{
		straight = new Straight(Color.blue);
	}
	
	@Test
	public void checkOriginPositionBlock1()
	{
		color=Color.blue;
		tempColor = straight.blockArray.get(0).get(4).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
	
	@Test
	public void checkOriginPositionBlock2()
	{
		color=Color.blue;
		tempColor = straight.blockArray.get(1).get(4).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
	
	@Test
	public void checkOriginPositionBlock3()
	{
		color=Color.blue;
		tempColor = straight.blockArray.get(2).get(4).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
	
	@Test
	public void checkOriginPositionBlock4()
	{
		color=Color.blue;
		tempColor = straight.blockArray.get(3).get(4).getColor();
		assertEquals("Block should be visible", color, tempColor );
	}
}
