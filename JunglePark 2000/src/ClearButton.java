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
 * This class serves to remove all the Animals from the park
 * 
 * @author: Kunlun Wang
 *
 */
public class ClearButton extends Button {

  /**
   * ClearButton is a subclass of Button and it will create a new Button object positioned at a
   * given position of the display window. And it will initialize the instance fields
   * 
   * @param x x-coordinate of the button object in the display window
   * @param y y-coordinate of the button object in the display window
   * @param park PApplet object that represents the display window
   */
  public ClearButton(float x, float y, JunglePark park) {
    super(x, y, park); // calls super class with position and the park reference
    this.label = "Clear Park";// Sets label of the button
  }

  /**
   * mousePressed () is a callback method that will call called each time the user presses the
   * mouse. If the mouse is over the button, it will clear up the entire display window
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {

      processing.clear(); // Calls the method that removes all the animals

    }
  }
}
