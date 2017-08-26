package au.com.rea.model;

import au.com.rea.model.Direction;

/**
 * Enum class for the directions EAST,WEST,NORTH,SOUTH.
 */
public enum Direction {
		 NORTH, EAST, SOUTH, WEST;
	

  /**
   * Returns the next direction in the sequence.
   * It cycles to the first element if last in sequence
   *
   * @return  Next enum constant
   */
  public Direction getNext() {
      if (this.ordinal() < Direction.values().length - 1) {
          return Direction.values()[this.ordinal() + 1];
      }
      else {
          return Direction.values()[0];
      }
  }

  /**
   * Returns the previous direction in the sequence.
   * It cycles to the last element if first in sequence
   *
   * @return  Previous enum
   */
  public Direction getPrevious() {
      if (this.ordinal() == 0) {
          return Direction.values()[Direction.values().length - 1];
      }
      else {
          return Direction.values()[this.ordinal() - 1];
      }
  }

   
}
