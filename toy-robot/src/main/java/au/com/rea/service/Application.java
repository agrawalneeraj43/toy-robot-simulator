package au.com.rea.service;

import java.util.Scanner;
import au.com.rea.controller.RobotController;

public class Application {

	/**
	 * Command-line Java program main method. Passes input to the adapter, quits
	 * on the word EXIT.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		RobotController adapter = new RobotController();
		Scanner scan = new Scanner(System.in);
		String input;

		System.out.println("To quit the application type EXIT");

		while (true) {
			input = scan.nextLine();
			if (!input.equalsIgnoreCase("exit")) {
				// Output response from the controller class (e.g. REPORT)
				System.out.println(adapter.input(input));
			} else
				break;
		}
		scan.close();

	}

}
