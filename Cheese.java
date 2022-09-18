import java.awt.Graphics;
import java.awt.Color;

/**
 * Cheese 
 * --------------- 
 * This class is for a cheese shape centered at x and y
 * and draws a triangular cheese with holes.
 * 
 * @author Katarina McGaughy
 * @version March 2021
 */
public class Cheese extends Shape {

	// width is the width of two sides of the cheese (triangle)
	private int width;
	// cheeseColor is the color of the cheese
	private Color cheeseColor;

	/**
	 * Cheese 
	 * Constructor that takes in an x and y coordinate and width
	 * PRECONDITIONS: all parameters must be at least 0, and less than the width of
	 * the enclosing JFrame
	 */
	public Cheese(int x, int y, int newWidth) {
		super(x, y);
		this.width = newWidth;
		this.cheeseColor = Color.RED;

	}

	/**
	 * Cheese 
	 * Constructor that takes in an x and y coordinate, a width, and a color
	 * PRECONDITIONS: all parameters must be at least 0, and less than the width of
	 * the enclosing JFrame
	 */
	public Cheese(int x, int y, int newWidth, Color c) {
		super(x, y);
		this.width = newWidth;
		this.cheeseColor = c;

	}

	/**
	 * getArea() 
	 * --------- 
	 * This returns a VERY ROUGH approximation of the area of my
	 * cheese
	 */
	public double getArea() {
		double rectangle = (this.width * this.width);
		double triangle = (rectangle / 2);
		return triangle;

	}

	/**
	 * draw() 
	 * ------ 
	 * This method draws the cheese.
	 */
	public void draw(Graphics g) {
		int x = getX(); // the center of the cheese is
		int y = getY(); // at these coordinates.

		// The next four ints define the coordinates that outline the cheese.
		int left = x - (this.width / 2);
		int right = x + (this.width / 2);
		int top = y - (this.width / 2);
		int bottom = y + (this.width / 2);

		// circles in the cheese
		int diameterCheese = this.width / 7;
		int cheeseX1 = x - (this.width / 3);
		int cheeseY1 = y - (this.width / 10);
		int cheeseX2 = x - (this.width / 4);
		int cheeseY2 = y + (this.width / 6);
		int cheeseX3 = x;
		int cheeseY3 = y + (this.width / 4);

		// this draws outline of the cheese
		g.setColor(cheeseColor);
		g.drawLine(left, top, left, bottom);
		g.drawLine(left, bottom, right, bottom);
		g.drawLine(right, bottom, left, top);

		// this draws the circles in the cheese
		g.setColor(cheeseColor);
		g.drawOval(cheeseX1, cheeseY1, diameterCheese, diameterCheese);
		g.drawOval(cheeseX2, cheeseY2, diameterCheese, diameterCheese);
		g.drawOval(cheeseX3, cheeseY3, diameterCheese, diameterCheese);

	}

	//
	// Getters and Setters:
	// ---------------------

	/**
	 * setColor() 
	 * ---------- 
	 * This sets the color using a Color object from the
	 * java.awt.Color class
	 */
	public void setColor(Color c) {
		this.cheeseColor = c;
	}

	/**
	 * getColor() 
	 * ---------- 
	 * This returns the color of the cheese as a Color object
	 * from the java.awt.Color class
	 */
	public Color getColor() {
		return this.cheeseColor;
	}

	/**
	 * setWidth() 
	 * ---------- 
	 * This sets the rough width of the cheese; the cheese
	 * fits inside a square whose width is w. PRECONDITION: w should be smaller than
	 * the width of the JFrame that the cheese is to be drawn inside or else it
	 * might not be visible. w needs also to be greater than 0.
	 */
	public void setWidth(int w) {
		if (w >= 0 && w <= 300) {
			this.width = w;
		} else {
			System.out.println("Width must be between 0 and 300.");
			System.out.println("Setting to default of 50.");
			this.width = 50;
		}
	}

	/**
	 * getWidth() 
	 * ---------- 
	 * This returns the width two sides of the cheese
	 */
	public int getWidth() {
		return this.width;
	}
	
	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}

		Cheese that = (Cheese) other;

		if (this.getWidth() != that.getWidth()) {
			return false;
		}

		return true;

	}

}
