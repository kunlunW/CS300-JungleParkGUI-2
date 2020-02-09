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
 * The Tiger class represents a Tiger and its associated behavior in the JunglePark application
 * 
 * note: Tiger class represents the animal type for tiger objects. It is a subclass of the Animal
 * class which implements the ParkGUI interface. It inherits the methods defined in the ParkGUI
 * interface and can override their behaviors if needed. It also inherits the protected fields and
 * all the public methods defined in the Animal class.
 * 
 * @author: Kunlun Wang & Mouna Kacem
 * 
 */

public class Tiger extends Animal {
  private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for
                                             // food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger
  private int deerEatenCount;

  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
    this.deerEatenCount = 0;
  }



  // To hop on the food Deer, the tiger moves forward the position of food, and eats it.
  // Make sure to release the mouse if it is over the Tiger as it will take the position of food
  // straight away.
  // Make sure also to remove the eaten food from the JunglePark (listGUI).


  // recall that the return type is a ParkGUI object --> either an animal or button

  /**
   * The scanForFood method is a private helper class which serves to check if a deer is present in
   * the neighboring area of Tiger
   * 
   * @return food a ParkGUI object ( which is a graphic object) if deer within the range, return
   *         true, return null otherwise
   */
  private ParkGUI scanForFood(int scanRange) {

    for (int i = 0; i < processing.listGUI.size(); i++) {
      ParkGUI food = processing.listGUI.get(i);
      if (food instanceof Deer) {
        // THIS keyword over here refers to the current object which is a Tiger object
        if ((this).isClose((Deer) food, scanRange)) {
          return food;
        }
      }
    }
    return null;
  }

  /**
   * The hop method defines the Tiger's behavior to move to the position of deer and consumes it.
   * 
   * @param food a ParkGUI object passed from the private helper class
   */
  public void hop(Deer food) {
    // declare a ParkGUI object to temporarily store the object the tiger will eat, and set
    // it to null
    ParkGUI animalToEat = null;

    this.setPositionX(food.getPositionX()); // moves to x position of the food
    this.setPositionY(food.getPositionY()); // moves to y position of the food
    this.mouseReleased(); // mouse released will trigger some action
    // Temporarily store the content of the listGUI to a arrayList guiObject
    ArrayList<ParkGUI> guiObject = processing.listGUI;
    // The for loop checks if the object in the listGUI is the same object of the food
    // if so, simply remove that specific object from the the arrayList
    for (int i = 0; i < guiObject.size(); i++) {
      ParkGUI deerObjectAtIndexI = guiObject.get(i);

      // here we can not use instanceof because the tiger want to kill
      // the exact tiger at the specific location
      if (food.equals(deerObjectAtIndexI)) {
        animalToEat = deerObjectAtIndexI;
        guiObject.remove(animalToEat);
        this.deerEatenCount++;
      }
    }
  }

  /**
   * the action method defines the Tiger's behavior in the Jungle Park which is to scanForFood()
   * 
   */
  @Override
  public void action() {
    ParkGUI food = scanForFood(SCAN_RANGE);
    if (food != null) {
      hop((Deer) food);
    }

    if (deerEatenCount > 0) {
      displayDeerEatenCount(); // display deerEatenCount
    }
  }

  public int getDeerEatenCount() {
    return this.deerEatenCount;
  }


  /**
   * disPlayDeerEatenCount method serves to display the number of eaten deers if any on the top of
   * the tiger image
   */
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(),
        this.getPositionY() - this.image.height / 2 - 4);
  }
}
