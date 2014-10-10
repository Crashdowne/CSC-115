/**
 * A graphical component that uses a DrawableItem to draw its content.
 */
public class DrawingPanel extends javax.swing.JPanel{
	private final DrawableItem itemToDraw;
	
	public DrawingPanel(DrawableItem itemToDraw) {
		this.itemToDraw = itemToDraw;
		this.setPreferredSize(new java.awt.Dimension(itemToDraw.getWidth(), itemToDraw.getHeight()));
	}

	// override from JPanel
	public void paintComponent(java.awt.Graphics graphics) {
		itemToDraw.draw(graphics);
	}
}