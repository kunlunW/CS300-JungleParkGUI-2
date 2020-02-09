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
 * This class serves to create a new animal and add it to the park, and it will provide two types of
 * button, one for adding tiger and one for adding deer
 * 
 * @author: Kunlun Wang, Mouna Kacem
 *
 */

// Now, let's create an AddAnimalButton class. This class must extend the provided Button
// class that implements the ParkGUI interface. This class defines only one instance field,
// and one constructor provided in the following. To implement this class, you need only to
// override one method: mousePressed() method. When the user presses the AddAnimalButton,
// a new animal will be created and added to the park. The type of the animal, either tiger
// or deer is determined using the type field defined in the AddAnimalButton class.
public class AddAnimalButton extends Button {


  private String type; // type of the animal to add

  /**
   * AddAnimalButton is a constructor that will create a new Button object positioned at a given
   * position of the display window. Also it will initialize the instance fields
   * 
   * @param type the string literal that represents the specific type of animal the user wishes to
   *        add
   * @param x x-coordinate of the button object in the display window
   * @param y y-coordinate of the button object in the display window
   * @param park PApplet object that represents the display window
   */
  public AddAnimalButton(String type, float x, float y, JunglePark park) {
    super(x, y, park); // // call the super class with position and the park reference
    this.type = type.toLowerCase();
    this.label = "Add " + type;
  }

  /**
   * mousePressed () is an overridden callback method that will call each time the user presses the
   * mouse. When the user presses the AddAnimalButton, a new animal will be created and added to the
   * park.
   */

  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      switch (type) {
        case "tiger":
          // Initializes new tiger object to the GUI objects
          processing.listGUI.add(new Tiger(processing));
          break;
        case "deer":
          // Initializes new deer object to the GUI objects
          processing.listGUI.add(new Deer(processing));
          break;
      }
    }
  }
}
