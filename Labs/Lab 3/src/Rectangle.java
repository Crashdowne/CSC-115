public class Rectangle implements Shape {

	private int length; //length units along x axis
	private int width;  //width units along y axis
	private Point position; // position is the (x,y) coordinates of lower left corner of the rectangle
	
	public Rectangle() {
		this.length = 0;
		this.width = 0;
		this.position = new Point();
	}

	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
		this.position = new Point();
	}
	
	public Rectangle(int length, int width, Point position) {
		this.length = length;
		this.width = width;
		this.position = position;
	}
	
	public double area()
	{
		double area = length*width;
		return area;
	}
	
	public double perimeter()
	{
		double perimeter = length*2 + width*2;
		return perimeter;
	}
	
	public boolean contains(Point p)
	{
		if (p.getX() < width && p.getY() < length)
		{
			return true;
		}
		
		else 
		{
			return false;
		}
	}
}