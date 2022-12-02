
public class Circle2D {
	private Point2D center;
	private double radius;
	
	public Circle2D() {
		center = new Point2D();
		radius = 1.0;
	}
	
	public Circle2D(Point2D c, double r) {
		center = new Point2D(c.getX(), c.getY());
		radius = r;
	}
	
	Point2D getc() {
		return center;
	}
	
	double getr() {
		return radius;
	}
	
	public String toString() {
		String val = "Circle with radius " +radius+ " and center "+center.toString();
      return val;
	}
	
}

