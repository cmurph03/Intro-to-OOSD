import org.junit.*;
import static org.junit.Assert.*;

public class TriangleTest
{
    @Test
    public void isEquilateralExpectTrue()
    {
        Triangle t = new Triangle(10,10,10);
        boolean result = t.isEquilateral();
        assertEquals("isEquilateral() "+t, true, result);
    }

     @Test
    public void isNotNull()
    {
        Triangle t = new Triangle(0,0,0);
        boolean result = t.isEquilateral();
        assertNull("A triangle with sides "+t+" cannot exist.", t);
    }
    
    @Test
    public void isIsoscelesExpectTrue()
    {
	Triangle t = new Triangle(4,12,4);
	boolean result= t.isIsosceles();
	assertEquals("isIsosceles() " +t, true, result);
    } 
}
