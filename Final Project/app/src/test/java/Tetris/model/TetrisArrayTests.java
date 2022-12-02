package model;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.awt.Color;

public class TetrisArrayTests
{
	private TetrisArray array;

	@Before
	public void setUp()
	{
		array = new TetrisArray();
	}

	@Test
	public void testGetNumRows()
	{
		assertEquals("Error: getNumRows does not work", 16, array.getNumRows());
	}

	@Test public void testGetNumCols()
	{
		assertEquals("Error: getNumCols does not work", 9, array.getNumColumns());
	}

	@Test public void testGetNullBlock()
	{
		Block block = array.getBlock(3,4);
		assertNull("Error: getBlock does not work for null blocks", block.getColor());
	}

	@Test
	public void testAdjustandGetColorBlock()
	{
		Block block = new Block(Color.RED);
		array.adjust(3, 4, block);
		assertEquals("Error: adjust does not work or getBlock with a non-null block doesn't work", block, array.getBlock(3, 4));
	}


}
