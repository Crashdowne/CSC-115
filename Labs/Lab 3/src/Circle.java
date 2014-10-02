public class Circle implements Shape {

	private int radius;  //radius
	private static final double PI = 3.14;
	private Point position; // position is the (x,y) coordinates of center of the circle
	
	public Circle () {
		this.radius = 0;
		this.position = new Point();
	}
	
	public Circle (int radius) {
		this.radius = radius;
		this.position = new Point();
	}
	
	public Circle (int radius, Point position) {
		this.radius = radius;
		this.position = position;
	}
	
	public double area ()
	{
		double area = PI*radius*radius;
		return area;
	}
	
	public double perimeter ()
	{
		double perimeter = 2*PI*radius;
		return perimeter;
	}
	
	public boolean contains (Point p)
	{
		if (p.getX() < Math.abs(radius)  && p.getY() < Math.abs(radius))
		{
			return true;
		}
		
		else
		{
			return false;
		}	
	}
}