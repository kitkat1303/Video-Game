import java.awt.*;

/* Class Shape
 *
 * By Rob Nash (with minor edits by David Nixon)
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

// the superclass in our inheritance hierarchy
// all "common" features, functions and data should go here
// for example, all shapes in Java2D have a x,y that declares their position
// and many of the shapes exposed have a width and a height (but not all, so we didn't put width and height here)
// Note that this class is mostly empty, as there is no algorithm generic enough to guess an arbitrary shape's area 
// (future subclasses must override getArea() to provide something reasonable)
// Also, the draw method is empty too, as we don't know what shape to draw here! 
// (again, our subclasses will need to replace this method with one that actually draws things)


class Shape extends Object {
	private int x = 0;
	private int y = 0;
	
	/**
	 * constructor
	 * -----------
	 * This takes in two integers, the x and y coordinates of the shape on the screen
	 * PRECONDITION: a and b must not be negative, and should not be larger than the enclosing JFrame
	 */
	public Shape( int a, int b ) {
		this.x = a;
		this.y = b;
	}
	
	/**
	 * getArea()
	 * ---------
	 * This should be overridden in child classes. After all, we can't have a shape with -1 area!
	 */
	public double getArea(){ return -1; }
	
	/**
	 * draw()
	 * ------
	 * This will also be overridden in child classes to draw the appropriate shape.
	 */
	public void draw( Graphics g ){}
	
	/**
	 * getX()
	 * ------
	 * This returns the shape's x coordinate.
	 */
	public int getX() { return this.x; }
	
	/**
	 * getY()
	 * ------
	 * This returns the shape's y coordinate.
	 */
	public int getY() { return this.y; }
	
	/**
	 * setX()
	 * ------
	 * This sets the shape's x coordinate.
	 * PRECONDITION: x should not be negative, and should be less than the width of the enclosing JFrame
	 */
	protected void setX(int newX) { this.x = newX; }
	
	/**
	 * setY()
	 * ------
	 * This sets the shape's y coordinate.
	 * PRECONDITION: y should not be negative, and should be less than the height of the enclosing JFrame
	 */
	protected void setY(int newY) { this.y = newY; }
}