package model;

import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Color;

public class BlockTests
{
	private Block block;
	private Color testColor;
	private Color tempColor;
	
	@Test
	public void testNoArguementConstructor()
	{
		block = new Block();
		Color tempColor;
		testColor = null;
		tempColor = block.getColor();
		
		assertEquals("Null constructor should have set the default constructor to null", testColor, tempColor);
	}
	
	@Test
	public void testArguementConstructor()
	{
		block = new Block(Color.blue);
		testColor = Color.blue;
		tempColor = block.getColor();
		
		assertEquals("Arguement constructor should have set the color to blue", testColor, tempColor);
	}
	
	@Test
	public void testSetColor()
	{
		block = new Block();
		block.setColor(Color.red);
		testColor = Color.red;
		tempColor = block.getColor();
		
		assertEquals("Set color method should have set the color to red", testColor, tempColor);
	}
}
