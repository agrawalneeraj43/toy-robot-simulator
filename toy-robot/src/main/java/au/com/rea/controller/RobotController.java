package au.com.rea.controller;

import au.com.rea.model.Direction;
import au.com.rea.model.Robot;

/**
 * Controller class which acts as adapter between input and Robot object.
 */
public class RobotController {
	private static String ERROR_MSG_INVALID_INPUT = "Invalid input";
	private Robot robot;

	public RobotController() {
		robot = new Robot();
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	/**
	 * Invokes appropriate operation based on input
	 *
	 * @param input  Raw operation
	 * @return Report text, invalid input error message or empty string
	 */
	public String input(String input) {
		if (input != null) {
			input = input.trim().toLowerCase();

			switch (input) {
				case "move":
					robot.move();
					break;
				case "right":
					robot.right();
					break;
				case "left":
					robot.left();
					break;
				case "report":
					return robot.report();
				default:
					if (isValidPlaceCommand(input)) {
						invokePlaceCommand(input);
					} else {
						return ERROR_MSG_INVALID_INPUT;
					}
			}
		}

		return "";
	}

	/**
	 * Parses the input and invokes the PLACE command.
	 *
	 * @param input  Raw input
	 * 
	 */
	private void invokePlaceCommand(String input) {
		String[] args = input.replaceAll("place ", "").split(",");

		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		Direction face = Direction.valueOf(args[2].toUpperCase());

		robot.place(x, y, face);
	}

	/**
	 * Matches the PLACE command input against a regular expression.
	 *
	 * @param input  Place command input
	 * @return TRUE if a valid-formatted command
	 */
	private boolean isValidPlaceCommand(String input) {
		return input.matches("^place [0-9]+,[0-9]+,(north|south|east|west)");
	}
}