import java.awt.Graphics;
import java.awt.Color;

/**
 * Mouse
 * ---------------
 * This class is for a mouse shape centered at x and y.
 * 
 * @author Katarina McGaughy 
 * @version March 2021
 */
public class Mouse extends Shape{
	

	//diameter represents the diameter of the mouses head
    private int diameter;
    //mouseColor represents the color of the mouse
    private Color mouseColor;
    
    /**
	 * Mouse
	 * Constructor that takes in an x and y coordinate, width
	 * PRECONDITIONS: all parameters must be at least 0, and less than the width of
	 * the enclosing JFrame
	 */
    public Mouse(int x, int y, int diameter){
        super(x,y);
        this.diameter = diameter;
        this.mouseColor = Color.RED;
        
    }
    
    /**
	 * Mouse
	 * Constructor that takes in an x and y coordinate, width, and color
	 * PRECONDITIONS: all parameters must be at least 0, and less than the width of
	 * the enclosing JFrame
	 */
     public Mouse(int x, int y, int diameter, Color c){
        super(x,y);
        this.diameter = diameter;
        this.mouseColor = c;
        
    }
    
    /**
     * getArea()
     * ---------
     * This returns a VERY ROUGH approximation of the area of the mouse
     */
    public double getArea(){ 
    	double head = (this.diameter * this.diameter * Math.PI);
    	int halfDiameter = this.diameter/2;
    	double ear = (halfDiameter * halfDiameter * Math.PI);
        return head + ear + ear;
        
    }
    
    /**
     * draw()
     * ------
     * This method actually draws the mouse.
     */
    public void draw( Graphics g ){
    	//center coordinates of head 
        int x = getX();   
        int y = getY();   
        
        //center of ears
        int leftEarX = x - (this.diameter/4);
        int leftEarY = y - (this.diameter/3);
        int rightEarX = x + (this.diameter/2);
        int rightEarY = y - (this.diameter/2);
        
        //eyes 
        int rightEyeX = x + (this.diameter/2);
        int rightEyeY = y + (this.diameter/3);
        int leftEyeX = x + (this.diameter/4);
        int leftEyeY = y + (this.diameter/3);
        
        //nose 
        int noseX = x + (this.diameter/2); 
        int noseY = y + (this.diameter/2);
        
        g.setColor(this.mouseColor);
        
        //draw head and ears 
        g.drawOval(x, y, this.diameter, this.diameter);
        g.drawOval(leftEarX, leftEarY, this.diameter/2, this.diameter/2);
        g.drawOval(rightEarX, rightEarY, this.diameter/2, this.diameter/2);
        
        //eyes and nose are 1/8 diameter of og diameter 
        g.fillOval(rightEyeX, rightEyeY, this.diameter/8, this.diameter/8);
        g.fillOval(leftEyeX, leftEyeY, this.diameter/8, this.diameter/8);
        
        //nose
        g.fillOval(noseX, noseY, this.diameter/8, this.diameter/8);
        
    }
    
    //
    // Getters and Setters: 
    // ---------------------
    
    /**
     * setColor()
     * ----------
     * This sets the color using a Color object from the java.awt.Color class
     */
    public void setColor(Color c){ 
    	this.mouseColor = c; 
    }
    
    /**
     * getColor()
     * ----------
     * This returns the color of the mouse as a Color object from the java.awt.Color class
     */
    public Color getColor(){ 
    	return this.mouseColor;  
    }
    
    /**
     * setDiameter()
     * ----------
     * This sets the diameter of the mouses head
     * PRECONDITION: w should be smaller than the diameter of the JFrame that the mouse is to be drawn inside
     *               or else it might not be visible.
     *               w needs also to be greater than 0.
     */
    public void setDiameter(int r){ 
    	if (r >=0 && r<=300) {
    		this.diameter = r; 
    	}
    	else {
    		System.out.println("Width must be between 0 and 300.");
    		System.out.println("Setting to default of 50.");
    		this.diameter = 50;
    	}
    	}
    
    /**
     * getWidth()
     * ----------
     * This returns the diameter of the circle that the mouse fits inside.
     */
    public int getDiameter(){ 
    	return this.diameter; 
    	}

    
    public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}

		Mouse that = (Mouse) other;

		if (this.getDiameter() != that.getDiameter()) {
			return false;
		}

		return true;

	}

}
