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
 * This class represents a Deer in the JunglePark application
 * 
 * @author: Kunlun Wang & Mouna Kacem
 *
 */
public class Deer extends Animal {

  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the
                                             // neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
                                 // to be created

  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer


  /**
   * Constructor that creates a new Deer object to be positioned at a random position of the display
   * window and initializes its instance fields
   * 
   * @param processing PApplet object that represents the display window
   */
  public Deer(JunglePark processing) {

    // call the super class to create a new Deer object positioned at a
    // random position of the display window
    super(processing, IMAGE_FILE_NAME);
    // set the identification
    this.id = nextID;
    // set the label
    this.label = TYPE + id;

    ++nextID;

  }


  /**
   * This method checks if there is a threat, specifically a tiger, is present within the alerting
   * range of the deer (current object)
   * 
   * note: 1) guiObjects refers the the GUI array list that stores all the graphic content 2) how to
   * access listGUI: Notice carefully that the class Deer extends the class Animal. The class Animal
   * defines a protected field named processing of type JunglePark. So, the field processing is
   * directly accessible from the class Deer.
   * 
   * @param scanRange ant int that will be passed in as a parameter that will represent the alerting
   *        range of deer
   * 
   * @return threatPresent true if threat is within the range, false otherwise
   */

  public boolean scanForThreat(int scanRange) {

    boolean threatPresent = false;
    // use processing which is a JunglePark object to access the listGUI which is an
    // arrayList declared in JunglePark class
    for (int i = 0; i < processing.listGUI.size(); i++) {
      ParkGUI graphAtIndexI = processing.listGUI.get(i);
      if (graphAtIndexI instanceof Tiger) {
        // THIS keyword over here refers to the current class object
        // which is the Deer object
        if (((Tiger) graphAtIndexI).isClose(this, scanRange)) {
          threatPresent = true;
          break;
        }
      }
    }
    return threatPresent;
  }

  /**
   * The method serves to define the behavior of Deer Object in Jungle park for scanning the threat
   * in the neighboring area. If the the deer scans any Tiger object in its proximity, it will
   * display "Threat!" over it's head.
   */
  @Override
  public void action() {
    // if a tiger object is within the range of a deer, then it will specify the
    // color of the font, and then put a string literal above the deer's head.
    if (scanForThreat(SCAN_RANGE) == true) {
      this.processing.fill(0); // specify font color: black
      this.processing.text("THREAT!", this.getPositionX(),
          this.getPositionY() - this.image.height / 2 - 4);
    }

  }
}
