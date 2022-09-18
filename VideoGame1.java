import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.Font;
import java.util.Random;
//import javax.swing.*;

/**
 * VideoGame1
 * ----------
 * This class instantiates a small graphics-based video game where you move around one little shape
 * (using the arrow keys) and try to crash into some other little shapes. 
 * The VideoGame1 class extends the JFrame class, which is a class built into Java's Swing package of graphics classes.
 * The JFrame is essentially a window that opens on your computer screen and which you can add things into.
 * The VideoGame1 class also implements the KeyListener and ActionListener interfaces.
 * (Although we are not currently using the ActionListener interface for anything, so the ActionPerformed method is left blank)
 * The KeyListener interface requires that I have 3 methods:
 * keyPressed(), keyTyped(), and keyReleased() -- Though I only use the first of these; the others are left blank.
 * Implementing the KeyListener interface makes it easier to add a keyListener (which is this class itself),
 * which will listen for keyboard keys being pressed and when a key is pressed, the keyPressed() method will be called,
 * and this can be used to update the location of the shape that is being moved around.
 * The game keeps track of your score. When you have got all three shapes that you're supposed to chase, you win.
 * 
 * You use the arrow keys to move around. Type 'Q' to quit.
 *
 * @author David Nixon    (ALL RIGHTS RESERVED. DO NOT UPLOAD THIS CODE ANYWHERE ON THE INTERNET.)
 * @version March 2021
 */
public class VideoGame1 extends JFrame implements KeyListener, ActionListener  {
    
    // INSTANCE VARIABLES:
    // -------------------
    
    // the width and height of the window (the "JFrame") where the video game happens:
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    
    private int totalNumberOfShapes = 4; // including the one you'll be moving around.
    private Shape [] shapeList; // Where we keep our shapes. The one at shapeList[0] is the one you'll be moving around. 
    
    private int collisionDistance = 20; // how close you can get to another thing before we consider you to have collided.
                                        // This is essentially pixel distance: how many pixels you are away.
                                        
    // The following array is how we keep track of whether you've collided with any of the other items.
    // We won't actually use the first element of this array, since index 0 is where we keep the first shape, 
    // the one we're moving around, and we don't need to check if it has hit itself. 
    // But if hasCollidedWith[1] is true, then the shape at index 0 has collided with the shape at index 1 .
    private boolean [] hasCollidedWith;
    
    private int score = 0;
    
    private int speed = 10; // how many pixels you move each time you move.  The higher the number, the faster you go.
    
    private boolean itsTimeToQuit = false;
    
    // private Timer timer;  // in case we want something to happen every so often.

    /**
     * Constructor for objects of class VideoGame1
     */
    public VideoGame1()
    {
        // Here's where I create my four shapes 
       // FivePointedStar s1 = new FivePointedStar(randX(),randY(),50, Color.RED);
       // FivePointedStar s2 = new FivePointedStar(randX(),randY(),50, Color.GREEN);
        //FivePointedStar s3 = new FivePointedStar(randX(),randY(),50, Color.ORANGE);
      //  FivePointedStar s4 = new FivePointedStar(randX(),randY(),50, Color.MAGENTA);
        Cat cat = new Cat(randX(), randY(), 50, Color.RED);
        Dog d1 = new Dog(randX(), randY(), 50, Color.BLACK);
        Mouse m2 = new Mouse(randX(), randY(), 50, Color.BLUE);
        Cheese c1 = new Cheese(randX(), randY(), 50, Color.ORANGE);
        
        // create the shapeList:
        this.shapeList = new Shape[this.totalNumberOfShapes];
        // Now I will add my shapes:
        this.shapeList[0] = d1; // whatever goes in this first spot will be the one that you'll move around
        this.shapeList[1] = cat;
        this.shapeList[2] = m2;
       // this.shapeList[3] = s4;
        this.shapeList[3] = c1;
        
        // initalize the hasCollidedWith array:
        this.hasCollidedWith = new boolean[this.totalNumberOfShapes];
        // Make them start out as all false (since no collisions have happened yet.)
        for (int i =0 ; i < this.hasCollidedWith.length; i++){
            this.hasCollidedWith[i] = false;
        }
        
        // Set the size of the JFrame window, what happens when they try to close the window, and what the title is:
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Video Game 1");
        
        this.addKeyListener(this); // This makes sure that the game listens for key presses, and when it senses a key press,
                                   // It calls the keyTyped, keyPressed, or keyReleased method. (see below).
        
        // If I wanted something to happen in my video game regardless of whether anyone pressed a key,
        // I could have a timer trigger an ActionListener every so often:
        //timer = new Timer(1000, this); // every 1 second (1000 milliseconds), trigger the ActionListener
        //timer.start();
    }

    /**
     * main()
     * ------
     * This just creates a VideoGame1 instance (which is a JFrame object, a window with stuff inside it), and makes it visible. 
     */
    public static void main(String[] args){
        VideoGame1 v = new VideoGame1();
        v.setVisible(true);
        
        //Testing 
        Cat cat = new Cat(20,20, 10, Color.BLACK);
        Dog dog = new Dog(20,20, 10, Color.BLACK);
        Mouse mouse = new Mouse(20,20, 10, Color.BLACK);
        Cheese cheese = new Cheese(20,20, 10, Color.BLACK);
        
        runAllTests(cat, dog, mouse, cheese);
        
        
    }
    
    /**
     * runAllTests
     * this functions calls all the tests for the various shapes
     * @param cat: cat object
     * @param dog: dog object
     * @param mouse: mouse object 
     * @param cheese: cheese object 
     */
    public static void runAllTests(Cat cat, Dog dog, Mouse mouse, Cheese cheese) {
    	runCatTest(cat);
        System.out.println();
        runDogTest(dog);
        System.out.println();
        runMouseTest(mouse);
        System.out.println();
        runCheeseTest(cheese);
        System.out.println();
    }
    
    /**
     * runCatTest
     * Performs tests on the getArea, getColor, and getWidth
     * @param cat: cat object 
     */
    public static void runCatTest(Cat cat) {
    	System.out.println("Running cat tests.");
    	if (cat.getArea() == 200.0) {
    		System.out.println("getArea: Passed: " + cat.getArea());
    	}
    	else {
    		System.out.println("getArea: Failed: " + cat.getArea());
    	}
    	
    	if (cat.getColor().equals(Color.BLACK)) {
    		System.out.println("getColor: Passed: " + cat.getColor());
    	}
    	else {
    		System.out.println("getColor: Failed: " + cat.getColor());
    	}
    	
    	if (cat.getWidth() == 10) {
    		System.out.println("getWidth: Passed: " + cat.getWidth());
    	}
    	else {
    		System.out.println("getWidth: Failed: " + cat.getWidth());
    	}
	 
    }
    
    /**
     * runDogTest
     * Performs tests on the getArea, getColor, and getWidth
     * @param dog: dog object 
     */
    public static void runDogTest(Dog dog) {
    	System.out.println("Running dog tests.");
    	if (dog.getArea() == 464.1592653589793) {
    		System.out.println("getArea: Passed: " + dog.getArea());
    	}
    	else {
    		System.out.println("getArea: Failed: " + dog.getArea());
    	}
    	
    	if (dog.getColor().equals(Color.BLACK)) {
    		System.out.println("getColor: Passed: " + dog.getColor());
    	}
    	else {
    		System.out.println("getColor: Failed: " + dog.getColor());
    	}
    	
    	if (dog.getWidth() == 10) {
    		System.out.println("getWidth: Passed: " + dog.getWidth());
    	}
    	else {
    		System.out.println("getWidth: Failed " + dog.getWidth());
    	}
	 
    }
    
    /**
     * runMouseTest
     * Performs tests on the getArea, getColor, and getDiameter
     * @param mouse: mouse object 
     */
    public static void runMouseTest(Mouse mouse) {
    	System.out.println("Running mouse tests.");
    	if (mouse.getArea() == 471.238898038469) {
    		System.out.println("getArea: Passed: " + mouse.getArea());
    	}
    	else {
    		System.out.println("getArea: Failed: " + mouse.getArea());
    	}
    	
    	if (mouse.getColor().equals(Color.BLACK)) {
    		System.out.println("geColor: Passed: " + mouse.getColor());
    	}
    	else {
    		System.out.println("getColor: Failed " + mouse.getColor());
    	}
    	
    	if (mouse.getDiameter() == 10) {
    		System.out.println("getWidth: Passed: " + mouse.getDiameter());
    	}
    	else {
    		System.out.println("getWidth: Failed: " + mouse.getDiameter());
    	}
	 
    }
    
    /**
     * runCheeseTest
     * Performs tests on the getArea, getColor, and getWidth
     * @param cheese: cheese object 
     */
    public static void runCheeseTest(Cheese cheese) {
    	System.out.println("Running cheese tests.");
    	if (cheese.getArea() == 50.0) {
    		System.out.println("getArea: Passed: " + cheese.getArea());
    	}
    	else {
    		System.out.println("getArea: Failed: " + cheese.getArea());
    	}
    	
    	if (cheese.getColor().equals(Color.BLACK)) {
    		System.out.println("getColor: Passed: " + cheese.getColor());
    	}
    	else {
    		System.out.println("getColor: Failed: " + cheese.getColor());
    	}
    	
    	if (cheese.getWidth() == 10) {
    		System.out.println("getWidth: Passed: " + cheese.getWidth());
    	}
    	else {
    		System.out.println("getWidth: Failed: " + cheese.getWidth());
    	}
	 
    }
    
    

    /**
     * paint()
     * -------
     * The paint method is called automatically when you create a JFrame object, so you don't need to call it.
     * This one will print out all the shapes in my shapeList (unless they've been collided with).
     * It will also print out the score, and if you've won, it will print that out.
     * If one of the shapes has gotten away, then you lose, so we'll print that out.
     * If you quit (or have won or lost), it will print out goodbye and wait 4 seconds before exiting the program.
     */
    public void paint(Graphics g){
        super.paint(g);
        
        // Here we call the draw method for all the other Shapes in the Shape array, so long as it hasn't been collided with yet.
        // (NOTE that there might be different kinds of shapes in here! So we're calling the draw method even though we don't 
        //       know whose draw method is being called. This is related to the notion of polymorphism.)
        for (int i = 0; i < shapeList.length; i++){
            if (!this.hasCollidedWith[i]) shapeList[i].draw(g);
        }
        
        printScore(g); // to print out the score so far.
        
        // Check if we've gotten all the shapes
        if (this.score >= this.totalNumberOfShapes - 1){
            g.setFont(new Font("serif", Font.ITALIC, 24));
            g.setColor(Color.GREEN);
            g.drawString("YOU WON!", 50, 150);
            this.itsTimeToQuit = true;
            
        }
        
        // Check if any shapes got away  (i.e., went off the board)
        else if (aShapeGotAway()) {
            g.setFont(new Font("serif", Font.ITALIC, 24));
            g.setColor(Color.MAGENTA);
            g.drawString("Oh no! A shape got away! You lost!", 50, 150);
            this.itsTimeToQuit = true;
            
        }
        
        // If it's quittin' time, write GOODBYE on the JFrame, then wait 3 seconds and exit.
        if (this.itsTimeToQuit){
            g.setFont(new Font("serif", Font.PLAIN, 24));
            g.setColor(Color.RED);
            g.drawString("GOODBYE!", 175, 250);
            try {
                TimeUnit.SECONDS.sleep(4); // sleep for 4 seconds.
            }
            catch (Exception e){
                System.out.println("HUH. problem with sleep."); 
            } 
            System.exit(0);
        }

    }
    
    /**
     * printScore()
     * ------------
     * This just prints the score using the drawString method of the Graphics package.
     */
    private void printScore(Graphics g){
        g.setFont(new Font("serif", Font.PLAIN, 24));
        g.setColor(Color.BLACK);
        String s = "Score: " + this.score;
        g.drawString(s, 50, 50);
    }

    /**
     * keyPressed()
     * ------------
     * Since we added a keyListener to our JFrame, and since our JFrame IS a keyListener,
     * this method will get called when someone presses a key. The argument will automatically be set 
     * and it will contain information about which key was pressed. 
     * This method is one of three required by the KeyListener interface.
     * (The other two we don't use in this program, so they're just empty).
     * I use this to listen for the pressing of the arrow keys and to then move the first shape around
     */
    public void keyPressed(KeyEvent e) {
        // x and y are the current coordinates of the first shape in shapeList.
        // That's the one we'll move based on the key pressed.
        int x = this.shapeList[0].getX();
        int y = this.shapeList[0].getY();
        
        int kc = e.getKeyCode(); // this gives us a code corresponding to which key was pressed.
        
        // Based on which key was pressed, we change the location of the first shape: 
        // (Reminder: this.speed is the number of pixels you move at a time.)
        if (kc == 38){ // UP ARROW KEY
            this.shapeList[0].setY(y - this.speed); 
        }
        else if (kc == 40){ // DOWN ARROW KEY
            this.shapeList[0].setY(y + this.speed);
        }
        else if (kc == 37){ // LEFT ARROW KEY
            this.shapeList[0].setX(x - this.speed);
        }
        else if (kc == 39){ // RIGHT ARROW KEY
            this.shapeList[0].setX(x + this.speed);
        }
        else if (kc == 81) { // Q (for Quit)
            this.itsTimeToQuit = true;
        }
        
        checkForCollisions();
        
        updateTheOtherShapePositions(); // now the others get a chance to move
        
        // After we change the values of the x and y of our favorite shape, it's time to repaint!
        repaint(); // this basically just clears the screen and calls the paint() method again.
    }
    
    public void keyTyped(KeyEvent e) { // not used, but required by the KeyListener interface
    }

    public void keyReleased(KeyEvent e){ // not used, but required by the KeyListener interface
    }
    
    /**
     * checkForCollisions()
     * --------------------
     * This method will check to see if the first item in shapeList has collided with any of the other elements in the shapeList,
     * and if so, set the proper variables.
     */
    private void checkForCollisions(){
        // the x and y of the shape that moves around:
        int x = this.shapeList[0].getX();
        int y = this.shapeList[0].getY();
        int dist = 0; // to keep track of the distance between the first shape and others.
        
        // Strategy:
        // iterate down the list of other shapes (besides the one at index 0 , which is the one moving around),
        // and check the distance between shape 0 and them. 
        // If that item hasn't already been collided with and if the distance is less than this.collisionDistance,
        // then set the appropriate boolean and increment the score.
        for (int i = 1; i < this.shapeList.length; i++){
            int otherX = this.shapeList[i].getX();
            int otherY = this.shapeList[i].getY();
            dist = distance(x, y, otherX, otherY);
            if (!this.hasCollidedWith[i] && dist < this.collisionDistance){
                this.hasCollidedWith[i] = true;
                this.score++;
                System.out.println("Collision with item " + i);
            }
        }
    }

    /**
     * updateTheOtherShapePositions()
     * ------------------------------
     * The other shapes try to run away from your shape.
     * (But only if they haven't been collided with.)
     */
    private void updateTheOtherShapePositions(){
        int x = this.shapeList[0].getX();
        int y = this.shapeList[0].getY();
        // the speed at which other shapes run away from you is about 1/5 of the speed you move:
        int speed  = (int)((double)this.speed / 5.0); 
        for (int i = 1; i < this.shapeList.length; i++){
            if (this.hasCollidedWith[i]) continue; // skip if it's already been collided with.
            int otherX = this.shapeList[i].getX();
            int otherY = this.shapeList[i].getY();
            
            if (x > otherX) this.shapeList[i].setX(otherX - speed);
            else this.shapeList[i].setX(otherX + speed);
            if (y > otherY) this.shapeList[i].setY(otherY - speed);
            else this.shapeList[i].setY(otherY + speed);
        }
    }
    
    /**
     * aShapeGotAway()
     * ---------------
     * This checks through the list of shapes that are running away to see if any of them went off the board.
     */
    private boolean aShapeGotAway(){
        for (int i = 1; i < this.shapeList.length; i++){
            int x = this.shapeList[i].getX();
            int y = this.shapeList[i].getY();
            if (x < 0 || x > FRAME_WIDTH || y < 0 || y > FRAME_HEIGHT) return true;
        }
        return false;
        
    }
    
    /**
     * actionPerformed
     * ---------------
     * This is the only method required of the ActionListener interface.
     * If an ActionEvent is triggered, do this code.
     * For example, if you had a Timer (the one from the Swing class), it will 
     *  trigger an ActionEvent every x milliseconds, and this method would get called.
     *  Currently we're not using this, so it's blank.
     */
    public void actionPerformed(ActionEvent e) {        
    }
    
    
    /**
     * distance
     * --------
     * This calculates the distance between two points (x1,y2) and (x2,y2)
     * using our old friend, the Pythagorean Theorem.
     */
    private int distance(int x1, int y1, int x2, int y2){
        int x_dist = Math.abs(x1-x2);
        int y_dist = Math.abs(y1-y2);
        int x_squared = x_dist * x_dist;
        int y_squared = y_dist * y_dist;
        
        return (int)Math.sqrt(x_squared + y_squared);
    }
    
    /**
     * randX()
     * -------
     * This returns a random number to be used as an x value for some item placed within the frame.
     * It takes into account the width of the frame, and also makes sure that the x isn't right on the edge of the frame.
     */
    private int randX(){
        int buffer = 50; // so that the number returned isn't right on the edge.
        Random r = new Random();
        return r.nextInt((FRAME_WIDTH - buffer*2) + 1) + buffer;
    }
    
    /**
     * randY()
     * -------
     * This returns a random number to be used as an y value for some item placed within the frame.
     * It takes into account the height of the frame, and also makes sure that the y isn't right on the edge of the frame.
     */
    private int randY(){
        int buffer = 50; // so that the number returned isn't right on the edge.
        Random r = new Random();
        return r.nextInt((FRAME_HEIGHT - buffer*2) + 1) + buffer;
    }


} // end VideoGame1 class
