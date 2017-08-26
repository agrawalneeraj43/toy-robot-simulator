package au.com.rea.model;

import au.com.rea.model.Direction;
import au.com.rea.model.TableTop;

/**
 * This class defines the methods which are allowed to perform by robot
 *
 * States: 
 * isPlaced  Denotes if the robot been placed on the table top?
 * x     X-position on the table top 
 * y     Y-position on the table top 
 * face  Enum representing direction of the robot
 * 
 */
public class Robot {
	private boolean isPlaced;
	private int x;
	private int y;
	private Direction face;

	public void place(int x, int y, Direction face) {
		if (isValidMove(x) && isValidMove(y)) {
			this.x = x;
			this.y = y;
			this.face = face;
			isPlaced = true;
		}
	}

	public String report() {
		if (isPlaced) {
			return (x + "," + y + "," + face).toUpperCase();
		}

		return "";
	}

	public void left() {
		if (isPlaced) {
			face = face.getPrevious();
		}
	}

	public void right() {
		if (isPlaced) {
			face = face.getNext();
		}
	}

	public void move() {
		if (isPlaced) {
			moveForward();
		}
	}

	/**
	 * Moves the robot forward/backward based on its face direction
	 */
	private void moveForward() {
		switch (face) {
			case NORTH:
				if (isValidMove(y + 1)) {
					y++;
				}
				break;
			case SOUTH:
				if (isValidMove(y - 1)) {
					y--;
				}
				break;
			case EAST:
				if (isValidMove(x + 1)) {
					x++;
				}
				break;
			case WEST:
				if (isValidMove(x - 1)) {
					x--;
				}
				break;
		}
	}

	/**
	 * Checks if the move is valid on the table top
	 *
	 * @param position
	 *          To be position after the move for validity check
	 * @return TRUE if valid position on the table
	 */
	private static boolean isValidMove(int position) {
		if (position >= 0 && position <= TableTop.LENGTH) {
			return true;
		}

		return false;
	}
}
