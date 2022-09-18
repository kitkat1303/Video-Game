import java.awt.Graphics;
import java.awt.Color;

/**
 * Cat 
 * --------------- 
 * This class is for a cat shape centered at x and y. The
 * constructor takes in a width parameter so that the cat can be any size. The
 * width describes the width of a square that the cats head fits inside.
 * 
 * @author Katarina McGaughy
 * @version March 2021
 */
public class Cat extends Shape {

	// width of the cats head
	private int width;
	//catColor represents the color of the cat
	private Color catColor;

	/**
	 * Cat Constructor that takes in an x and y coordinate and width PRECONDITIONS:
	 * all parameters must be at least 0, and less than the width of the enclosing
	 * JFrame
	 */
	public Cat(int x, int y, int newWidth) {
		super(x, y);
		setWidth(newWidth);
		this.catColor = Color.RED;

	}

	/**
	 * Cat Constructor that takes in an x and y coordinate, width, and color
	 * PRECONDITIONS: all parameters must be at least 0, and less than the width of
	 * the enclosing JFrame
	 */
	public Cat(int x, int y, int newWidth, Color c) {
		super(x, y);
		setWidth(newWidth);
		this.catColor = c;
	}

	/**
	 * getArea() 
	 * --------- 
	 * This returns a VERY ROUGH approximation of the area of
	 * the cat
	 */
	public double getArea() {
		double rectangle = (this.width * this.width);
		double triangle = (rectangle / 2);
		return rectangle + triangle + triangle;

	}

	/**
	 * draw() 
	 * ------ 
	 * This method actually draws the star.
	 */
	public void draw(Graphics g) {
		int x = getX(); // the center of the star is
		int y = getY(); // at these coordinates.

		// The next four ints define the coordinates of the square
		// that represents the head of the cat

		int left = x - (this.width / 2);
		int right = x + (this.width / 2);
		int top = y - (this.width / 2);
		int bottom = y + (this.width / 2);

		// represent point of tip of right ear
		int topRightEarX = right - (this.width / 4);
		int topLeftEarX = left + (this.width / 4);

		// represent where right ear connects to head
		int bottomRightEarX = x + (this.width / 6);
		int bottomRightEarY = top;

		// represent where left ear connects to head
		int bottomLeftEarX = x - (this.width / 6);
		int bottomLeftEarY = top;

		// represent point of tip of left ear
		int topRightEarY = top - (this.width / 2);
		int topLeftEarY = top - (this.width / 2);

		// is chin of cat
		int chinX = x;
		int chinY = bottom + (this.width / 2);

		// eyes
		int widthEyesNose = (this.width / 8);
		int rightEyeX = x + (this.width / 6);
		int rightEyeY = y - (this.width / 10);
		int leftEyeX = x - (this.width / 6);
		int leftEyeY = y - (this.width / 10);

		// nose
		int noseX = x;
		int noseY = bottom - (this.width / 4);

		// mouth
		int middleX = x;
		int middleY = noseY + (this.width / 4);
		int rightX = x + (this.width / 6);
		int rightY = noseY + (this.width / 4);
		int leftX = x - (this.width / 6);
		int leftY = noseY + (this.width / 4);

		// this draws outline of the cat
		g.setColor(catColor);
		g.drawLine(left, top, topLeftEarX, topLeftEarY);
		g.drawLine(topLeftEarX, topLeftEarY, bottomLeftEarX, bottomLeftEarY);
		g.drawLine(bottomLeftEarX, bottomLeftEarY, bottomRightEarX, bottomRightEarY);
		g.drawLine(bottomRightEarX, bottomRightEarY, topRightEarX, topRightEarY);
		g.drawLine(topRightEarX, topRightEarY, right, top);
		g.drawLine(right, top, right, bottom);
		g.drawLine(right, bottom, chinX, chinY);
		g.drawLine(chinX, chinY, left, bottom);
		g.drawLine(left, bottom, left, top);

		// draw mouth
		g.drawLine(noseX, noseY, middleX, middleY);
		g.drawLine(middleX, middleY, rightX, rightY);
		g.drawLine(middleX, middleY, leftX, leftY);

		// nose
		g.fillOval(noseX, noseY, widthEyesNose, widthEyesNose);

		// eyes
		g.fillOval(rightEyeX, rightEyeY, widthEyesNose, widthEyesNose);
		g.fillOval(leftEyeX, leftEyeY, widthEyesNose, widthEyesNose);

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
		this.catColor = c;
	}

	/**
	 * getColor() 
	 * ---------- 
	 * This returns the color of the star as a Color object
	 * from the java.awt.Color class
	 */
	public Color getColor() {
		return this.catColor;
	}

	/**
	 * setWidth() 
	 * ---------- 
	 * This sets the rough width of the star; the star fits
	 * inside a square whose width is w. PRECONDITION: w should be smaller than the
	 * width of the JFrame that the star is to be drawn inside or else it might not
	 * be visible. w needs also to be greater than 0.
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
	 * This returns the width of the square that the star fits
	 * inside.
	 */
	public int getWidth() {
		return this.width;
	}
	
	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}

		Cat that = (Cat) other;

		if (this.getWidth() != that.getWidth()) {
			return false;
		}

		return true;

	}

}
