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
import java.util.ArrayList;

/**
 * JunglePark class extends PApplet (Links to an external site.) class. This makes our JunglePark
 * class to BE a PApplet which inherits its predefined properties and behaviors. JunglePark mainly
 * serves as the driver of the program which is responsible for
 * 
 * note: Note that PApplet is a specific type that represents the Processing window for a graphic
 * application or program. It provides good ways to create a new window and draw graphics onto it.
 * 
 * more info about callback method view: https://www.quora.com/What-are-callback-methods-in-Java
 * 
 * @author Kunlun Wang & Mouna Kacem
 *
 */
public class JunglePark extends PApplet {

  private PImage backgroundImage; // PImage object that represents the background image
  protected ArrayList<ParkGUI> listGUI; // ArrayList storing the current graphical objects (animals
                                        // present in the Jungle Park and buttons)


  // This list can contain objects instances of any class that implements the provided
  // interface ParkGUI. In other words, listGUI will contain all graphic objects created
  // by the JunglePark application including the animals and the buttons if any.
  // the arraylist is initialized in the callback setup() method overridden
  // in the JunglePark class. Note that listGUI is a protected field.
  // It has a package visibility. It is also visible to any subclasses.

  /**
   * CallBack method Defines initial environment properties such as screen size and to load
   * background images and fonts as the program starts Initializes the backgroundImage and listGUI
   * instance fields.
   * 
   * 
   * RECALL that the code inside setup() method runs once when the PApplet program first starts, and
   * the code inside draw() method runs continuously.
   */

  @Override
  public void setup() {
    this.getSurface().setTitle("Jungle Park"); // Displays text in the title of the display window
    this.textAlign(PApplet.CENTER, PApplet.CENTER); // Sets the current alignment for drawing text
                                                    // to CENTER
    this.imageMode(PApplet.CENTER); // Sets the location from which images are drawn to CENTER
    this.rectMode(PApplet.CORNERS); // Sets the location from which rectangles are drawn.
    // rectMode(CORNERS) interprets the first two parameters of rect() method as the location
    // of one corner, and the third and fourth parameters as the location of the opposite corner.
    // rect() method draws a rectangle to the display window
    this.focused = true; // Confirms that our Processing program is "focused," meaning that
    // it is active and will accept mouse or keyboard input.
    backgroundImage = this.loadImage("images/background.png"); // load the background image

    listGUI = new ArrayList<ParkGUI>(); // create the listGUI ArrayList that would store all the
    // graphic objects (animals and buttons) that would be drawn on the display window

    listGUI.add(new AddAnimalButton("Tiger", 43, 16, this));
    // add the "Add Tiger" button to the display window
    listGUI.add(new AddAnimalButton("Deer", 129, 16, this));
    // add the "Add Deer" button to the display window
    listGUI.add(new ClearButton(215, 16, this));
    // add the "Clear Park" button to the display window
  }

  /**
   * Sets the size of the application display window
   */
  @Override
  public void settings() {
    size(800, 632); // sets the size of the display window to 800 x 632 pixels
  }


  /**
   * Callback method called in an infinite loop. It draws the Jungle Park's window display
   */
  @Override
  public void draw() {
    // Set the color used for the background of the Processing window
    this.background(245, 255, 250); // Set the mint cream color background
    this.image(backgroundImage, this.width / 2, this.height / 2); // draw the background image at
    // the center of the display window
    // traverse the tigers array and draw each stored tiger
    for (int i = 0; i < listGUI.size(); i++) {
      listGUI.get(i).draw();


      if (listGUI.get(i) instanceof Animal) { // checking if index i in the listGUI arrayList
        // is an instance of Animal

        Animal animal = (Animal) listGUI.get(i); // cast that specific element to the Animal type
        animal.action(); // call the action method
      }
    }
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  @Override
  public void mousePressed() {
    // traverse listGUI and call mousePressed() of the first graphical object
    // which the mouse is over
    for (int i = 0; i < listGUI.size(); i++)
      if (listGUI.get(i).isMouseOver()) {
        listGUI.get(i).mousePressed();
        break;
      }
  }

  /**
   * Callback method called each time the mouse is released
   */
  @Override
  public void mouseReleased() {
    // traverse listGUI and call mouseReleased() method defined for every graphic object
    for (int i = 0; i < listGUI.size(); i++)
      listGUI.get(i).mouseReleased();
  }

  /**
   * Callback method called each time the user presses a key
   */
  @Override
  public void keyPressed() {

    switch (Character.toUpperCase(this.key)) {
      case 'T': // add new tiger to the Jungle Park
        listGUI.add(new Tiger(this));
        break;

      case 'D':
        listGUI.add(new Deer(this));
        break;

      case 'R': // remove an animal from the Jungle Park if the mouse is over it
        // traverse the listGUI list and consider only animal objects to be removed if any
        for (int i = 0; i < listGUI.size(); i++) {
          if (listGUI.get(i) instanceof Animal && listGUI.get(i).isMouseOver()) {
            listGUI.remove(i);
            break; // remove the first animal which the mouse is over it while the
            // r-key is pressed
          }
        }
    }
  }

  /**
   * Removes all the animals from the park
   */
  public void clear() {
    for (int i = 0; i < listGUI.size(); i++) {
      if (listGUI.get(i) instanceof Animal) {
        listGUI.remove(i);
        i--;
      }
    }
  }



  /**
   * This main method starts the application
   * 
   * Utility class is not provided in the processing jar file for P3. Instead, our JunglePark is a
   * PApplet application.
   * 
   * To start it, we need just to call PApplet's main() method and give it the name of JunglePark
   * class as a parameter.
   * 
   * @param args
   */
  public static void main(String[] args) {
    // starts the application (calls PApplet main() method with the name
    // of the PApplet class to run as parameter)
    PApplet.main("JunglePark");
  }
}
