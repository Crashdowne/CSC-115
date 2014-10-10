import java.awt.Graphics;

public class RecursiveTriangle extends DrawableItem{ //: inherit code and data from DrawableItem
	private final int size;
	
	public RecursiveTriangle(int size) {
		super(size, size); // initialize the inherited DrawableItem parts
		this.size = size;
	}

	public void draw(Graphics graphics) {
		drawTriangle(graphics, 0, 30, this.size);
	}

	// Change this method so that it recursively produces the Sierpinski triangle.
	private static void drawTriangle(Graphics graphics, int x, int y, int base) {
		// use Theorem of Pythagoras to draw an equilateral triangle
		int b2 = base*base;
		int height = (int) Math.sqrt(b2 - b2/4);

		// *FIXME*: Use recursion to produce the Sierpinski triangle.
		// if the base is > 0, split this triangle into three smaller triangles
		// otherwise, draw the triangle

		// draw base:
		graphics.drawLine(x, y, x+base, y);

		// draw sides:
		graphics.drawLine(x, y, x + base/2, y + height);
		graphics.drawLine(x + base, y, x + base/2, y + height);
	}

	public static void main(String[] args) throws java.io.IOException {
		RecursiveTriangle t = new RecursiveTriangle(400);
		t.displayInWindow("Recursive Triangle");
	}
}