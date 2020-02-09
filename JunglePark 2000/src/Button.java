//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Jungle Park 2000
// Files: JunglePark.java, ParkGUI.java, Animal.java, Button.java, Tiger.java,
// Deer.java, AddAnimalButton.java, ClearButton.java, JungleParkTests.java
// Course: CS300 Summer 2019
//
// Author: Kunlun Wang
// Email: kwang358@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: N/A
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This a super class for any Button that can be added to a PApplet application This class
 * implements the ParkGUI interface
 * 
 * @author: Kunlun Wang, Mouna Kacem
 *
 */

// You can notice from the final display window for our JunglePark application
// shown in Figure 1, that we'll add three buttons "Add Tiger", "Add Deer", and "Clear Park"
// buttons. All these buttons would share similar functionalities and have similar state.
// Therefore, we created a new class called Button to serve as the base class (aka super class)
// for each of the Button classes that we may create in this program.
// The Button class implements also our JungleGUI interface.

// It implements one constructor and overrides the four methods
// defined in the JungleGUI interface.

// To help you further understand the code for drawing a button,
// we note that the processing method for drawing a rectangle is called rect(),
// and it takes four parameters: 1) the x-position of the upper left corner,
// 2) the y-position of the upper left corner, 3) the x-position of the lower right corner,
// 4) the y-position of the lower right corner.
// These corner positions must be calculated so that the button appears centered
// around it's position field with the appropriate WIDTH and HEIGHT.

// The fill() method is used to set the drawing color. When the mouse is over a button,
// its filling color is set to dark gray by calling fill(100),
// and when the mouse is not over this button, its filling color is set to light gray fill(200).

// Besides, the processing method text() is used to draw a text to the display window.
// Processing text() method takes three parameters: 1) the string of text to draw,
// 2) the x-position that this text should be centered around, and
// 3) the y-position that this text should be centered around.

public class Button implements ParkGUI {
  private static final int WIDTH = 85; // Width of the Button
  private static final int HEIGHT = 32; // Height of the Button
  protected JunglePark processing; // PApplet object where the button will be displayed
  private float[] position; // array storing x and y positions of the Button with respect to
                            // the display window
  protected String label; // text/label that represents the button


  /**
   * Button is a constructor that serves to create new Button object at a specific position of the
   * display window and initialize the instance filed
   * 
   * @param x x coordinate of the button object in the display window
   * @param y y coordinate of the button object in the display window
   * @param processing PApplet object that represents the display window
   */
  public Button(float x, float y, JunglePark processing) {
    this.processing = processing; // set the display window where the animal objects will be drawn
    this.position = new float[2]; // create a float array
    this.position[0] = x; // set the x position of the button
    this.position[1] = y; // set the y position of the button
    this.label = "Button"; // set the label for the button
  }

  /**
   * draw() method is an overridden method that draws the button to the display window.
   */
  @Override
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver())
      processing.fill(100); // set the fill color to dark gray if the mouse is over the button
    else
      processing.fill(200); // set the fill color to light gray otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    processing.fill(0); // set the fill color to black
    processing.text(label, position[0], position[1]); // display the text of the current button
  }

  /**
   * mousePressed() method is an overridden method, and also a callback method that will call each
   * time when the user presses the mouse and will print "A button was pressed".
   */
  @Override
  public void mousePressed() {
    if (isMouseOver())
      System.out.println("A button was pressed.");
  }

  /**
   * mouseReleased() is a callback method that will call each time the mouse is released.
   */
  @Override
  public void mouseReleased() {}

  /**
   * isMouseOver () is the method that checks if the mouse is over a given button object
   * 
   * @return true if the mouse is over the given button object, false otherwise
   */
  @Override
  public boolean isMouseOver() {
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
        && this.processing.mouseX < this.position[0] + WIDTH / 2
        && this.processing.mouseY > this.position[1] - HEIGHT / 2
        && this.processing.mouseY < this.position[1] + HEIGHT / 2)
      return true;
    return false;
  }
}
