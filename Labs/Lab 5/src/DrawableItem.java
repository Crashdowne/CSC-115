import java.awt.Graphics;
import javax.swing.JFrame;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * An object that can be drawn onto a window or into an image file.
 * Subclasses should override the draw(graphics) method.
 *
 */
 
public abstract class DrawableItem {
	// The width and height of the drawing area:
	protected final int width;
	protected final int height;

	/** Initialize a drawable item with a drawing area given by width and height. */
	public DrawableItem(int width, int height) {
		this.width  = width;
		this.height = height;
	}

	/** Get the width of the drawing area. */
	public int getWidth() {
		return width;
	}

	/** Get the height of the drawing area. */
	public int getHeight() {
		return height;
	}

	/**
	 * Do the work to draw this item with the given graphics context.
	 *
	 * NOTE:
	 * This method may be called repeatedly, whenever the system thinks
	 * that the item needs to be re-drawn.
	 */
	public abstract void draw(Graphics graphics);
		// "abstract" like an interface method
		// subclasses must provide an implementation

	/** Create a window and draw this item onto it. */
	public void displayInWindow(String windowTitle) {
		JFrame window = new JFrame();
		window.setTitle(windowTitle);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// ...exit when the window is closed

		window.setContentPane(new DrawingPanel(this));
			// when the window needs to be drawn, use this item to supply the action

		window.pack(); // layout the graphical components
		window.setVisible(true); // make the window visible
	}

	/** Draw this item into an image file. */
	public void saveAsPNG(String fileName) throws java.io.IOException{
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(java.awt.Color.BLACK);
		this.draw(graphics);
		graphics.dispose();
		ImageIO.write(image, "png", new File(fileName));
	}
}