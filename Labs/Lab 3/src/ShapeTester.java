public class ShapeTester {

	public static void main(String[] args) {
	
		Rectangle r1 = new Rectangle(2, 4);
		Shape r2 = new Rectangle();
		
		Circle c1 = new Circle();
		
		Shape c2 = new Circle(3, new Point(2, -1));
		
		Shape [] shapes = new Shape[4];
		
		shapes[0] = r2;
		shapes[1] = r1;
		shapes[2] = c1;
		shapes[3] = c2;

        System.out.print("\n");
		for(int i=0; i<shapes.length; i++) {
			System.out.println("Perimeter of shape " + (i+1) + ": " + shapes[i].perimeter());
		}

		System.out.println("\n");
		for(int i=0; i<shapes.length; i++) {
			System.out.println("Area of shape " + (i+1) + ": " + shapes[i].area());
		}
		
		System.out.println("\n");
		Shape rect = new Rectangle(4, 4);
		Point p = new Point(0,0);
		System.out.println(rect.contains(p));
		
		Point p2 = new Point(4,5);
		System.out.println(rect.contains(p2));
		
		Circle c = new Circle(2, new Point(7, -5));
		Point p3 = new Point(9,-7);
		System.out.println(c.contains(p3) + "\n");
	}

}