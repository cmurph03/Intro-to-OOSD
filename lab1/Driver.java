/*
 * Driver for Circle2D class
 */

public class Driver
{
   public static void main(String []args)
   {
		Point2D c = new Point2D(1, 1);
		double r = 10;
		
		Circle2D circle1 = new Circle2D();
		Circle2D circle2 = new Circle2D(c, r);
		
		System.out.println(circle1.toString());
		System.out.println(circle2.toString());
         }
}
