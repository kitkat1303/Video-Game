import java.awt.Graphics;
import java.awt.Color;

/**
 * Dog
 * ---------------
 * This class is for a dog shape centered at x and y.
 * 
 * @author Katarina McGaughy 
 * @version March 2021
 */
public class Dog extends Shape{
	
	//width represents the width of the dogs head 
    private int width;
    //dogColor represents the color of the dog
    private Color dogColor;
    
    /**
	 * Dog
	 * Constructor that takes in an x and y coordinate and width
	 * PRECONDITIONS: all parameters must be at least 0, and less than the width of
	 * the enclosing JFrame
	 */
    public Dog(int x, int y, int newWidth){
        super(x,y);
        this.width = newWidth;
        this.dogColor = Color.RED;
        
    }
    
    /**
	 * Dog
	 * Constructor that takes in an x and y coordinate, width, and color
	 * PRECONDITIONS: all parameters must be at least 0, and less than the width of
	 * the enclosing JFrame
	 */
     public Dog(int x, int y, int newWidth, Color c){
        super(x,y);
        this.width = newWidth;
        this.dogColor = c;
        
    }
    
    /**
     * getArea()
     * ---------
     * This returns a VERY ROUGH approximation of the area of the dog
     */
    public double getArea(){ 
    	double rectangle = (this.width * this.width);
    	double circle = (rectangle*Math.PI);
    	double triangle = rectangle*.5;
        return rectangle + circle + triangle;
        
    }
    
    /**
     * draw()
     * ------
     * This method actually draws the dog.
     */
    public void draw( Graphics g ){
        int x = getX();   // the center of the dog is
        int y = getY();   // at these coordinates.
        
        // The next four ints define the coordinates of the square that the dogs head fits inside.
        int left = x - (this.width / 2);
        int right = x + (this.width / 2);
        int top = y - (this.width / 2); //think this should be +
        int bottom = y + (this.width / 2);
        
        //represent upper left corner of ear
        int topLeftEarX = x - (this.width/4)-(this.width/2);
        int topLeftEarY = top;
        
        //represent point right corner or ear
        int topRightEarX = x+(this.width/2);
        int topRightEarY = top;
        
        //width of ears 
        int widthEars = this.width/4;
        
        //height of ears 
        int heightEars = this.width;
        
        //is chin of dog
        int chinX = x;
        int chinY = bottom + (this.width/2);
        
        //eyes
        int widthEyesNose = (this.width/8);
        int rightEyeX = x + (this.width/6);
        int rightEyeY = y - (this.width/10);
        int leftEyeX = x - (this.width/6);
        int leftEyeY = y - (this.width/10);
        
        //nose
        int noseX = x;
        int noseY = bottom - (this.width/4);
        
        //mouth 
        int middleX = x; 
        int middleY = noseY + (this.width/4);
        int rightX = x + (this.width/6); 
        int rightY = noseY + (this.width/4); 
        int leftX = x - (this.width/6); 
        int leftY = noseY + (this.width/4);
        
        
        //this draws outline of the dog
        g.setColor(dogColor);
        g.drawLine(left, top, right, top);
        g.drawLine(right, top, right, bottom);
        g.drawLine(right, bottom, chinX, chinY);
        g.drawLine(chinX, chinY, left, bottom);
        g.drawLine(left, bottom, left, top);
        
        //draw ears
        g.drawOval(topRightEarX, topRightEarY, widthEars, heightEars);
        g.drawOval(topLeftEarX, topLeftEarY, widthEars, heightEars);
        
        //draw mouth 
        g.drawLine(noseX, noseY, middleX, middleY);
        g.drawLine(middleX, middleY, rightX, rightY);
        g.drawLine(middleX, middleY, leftX, leftY);
        
        //nose
        g.fillOval(noseX, noseY, widthEyesNose, widthEyesNose);

		//eyes
		g.fillOval(rightEyeX, rightEyeY, widthEyesNose, widthEyesNose);
		g.fillOval(leftEyeX, leftEyeY, widthEyesNose, widthEyesNose);
        
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
    	this.dogColor = c; 
    }
    
    /**
     * getColor()
     * ----------
     * This returns the color of the dog as a Color object from the java.awt.Color class
     */
    public Color getColor(){ 
    	return this.dogColor;  
    }
    
    /**
     * setWidth()
     * ----------
     * This sets the rough width of the dog; the dog fits inside a square whose width is w.
     * PRECONDITION: w should be smaller than the width of the JFrame that the dog is to be drawn inside
     *               or else it might not be visible.
     *               w needs also to be greater than 0.
     */
    public void setWidth(int w){ 
    	if (w >=0 && w<=300) {
    		this.width = w; 
    	}
    	else {
    		System.out.println("Width must be between 0 and 300.");
    		System.out.println("Setting to default of 50.");
    		this.width = 50;
    	}
    	}
    
    /**
     * getWidth()
     * ----------
     * This returns the width of the square that the dog fits inside.
     */
    public int getWidth(){ 
    	return this.width; 
    }
    
    public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}

		Dog that = (Dog) other;

		if (this.getWidth() != that.getWidth()) {
			return false;
		}

		return true;

	}

}
