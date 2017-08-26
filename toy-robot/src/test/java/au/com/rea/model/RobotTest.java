package au.com.rea.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class RobotTest {
	private Robot robot;

	@Before
	public void before() {
		robot = new Robot();
	}

	@Test
	public void shouldNotPlaceInNegativeCoordinates() throws Exception {
		robot.place(-1, -1, Direction.NORTH);
		assertEquals(robot.report(), "");
	}

	@Test
	public void shouldNotPlaceOutsideTableTop() throws Exception {
		robot.place(TableTop.LENGTH + 1, TableTop.LENGTH + 1, Direction.NORTH);
		assertEquals(robot.report(), "");
	}

	@Test
	public void shouldIgnoreLeftIfNotPlaced() throws Exception {
		robot.left();
		assertEquals(robot.report(), "");
	}

	@Test
	public void shouldIgnoreRightIfNotPlaced() throws Exception {
		robot.right();
		assertEquals(robot.report(), "");
	}

	@Test
	public void shouldIgnoreIfNotPlaced() throws Exception {
		robot.report();
		assertEquals(robot.report(), "");
	}

	@Test
	public void shouldPlaceOnTable() throws Exception {
		robot.place(3, 4, Direction.EAST);
		assertEquals(robot.report(), "3,4,EAST");
	}

	@Test
	public void shouldHonourAnotherPlaceOnTable() throws Exception {
		robot.place(3, 4, Direction.EAST);
		robot.place(1, 2, Direction.WEST);
		assertEquals(robot.report(), "1,2,WEST");
	}

	@Test
	public void shouldRotateLeft() throws Exception {
		robot.place(3, 4, Direction.EAST);
		robot.left();
		assertEquals(robot.report(), "3,4,NORTH");
	}

	@Test
	public void shouldRotateLeftTwice() throws Exception {
		robot.place(3, 4, Direction.EAST);
		robot.left();
		robot.left();
		assertEquals(robot.report(), "3,4,WEST");
	}

	@Test
	public void shouldRotateLeftThrice() throws Exception {
		robot.place(3, 4, Direction.EAST);
		for (int i = 0; i < 3; i++) {
			robot.left();
		}
		assertEquals(robot.report(), "3,4,SOUTH");
	}

	@Test
	public void shouldRotateLeftFullRotation() throws Exception {
		robot.place(3, 4, Direction.EAST);
		for (int i = 0; i < 4; i++) {
			robot.left();
		}
		assertEquals(robot.report(), "3,4,EAST");
	}

	@Test
	public void shouldRotateRight() throws Exception {
		robot.place(3, 4, Direction.EAST);
		robot.right();
		assertEquals(robot.report(), "3,4,SOUTH");
	}

	@Test
	public void shouldRotateRightTwice() throws Exception {
		robot.place(3, 4, Direction.EAST);
		robot.right();
		robot.right();
		assertEquals(robot.report(), "3,4,WEST");
	}

	@Test
	public void shouldRotateRightThrice() throws Exception {
		robot.place(3, 4, Direction.EAST);
		for (int i = 0; i < 3; i++) {
			robot.right();
		}
		assertEquals(robot.report(), "3,4,NORTH");
	}

	@Test
	public void shouldRotateRightFullRotation() throws Exception {
		robot.place(3, 4, Direction.EAST);
		for (int i = 0; i < 4; i++) {
			robot.right();
		}
		assertEquals(robot.report(), "3,4,EAST");
	}

	@Test
	public void shouldMoveOnce() throws Exception {
		robot.place(3, 4, Direction.EAST);
		robot.move();
		assertEquals(robot.report(), "4,4,EAST");
	}

	@Test
	public void shouldMoveTwice() throws Exception {
		robot.place(3, 4, Direction.EAST);
		robot.move();
		robot.move();
		assertEquals(robot.report(), "5,4,EAST");
	}

	@Test
	public void shouldIgnoreMovingOutsideTable() throws Exception {
		robot.place(3, 4, Direction.EAST);
		for (int i = 0; i < TableTop.LENGTH + 1; i++) {
			robot.move();
		}
		assertEquals(robot.report(), "5,4,EAST");
	}

	@Test
	public void shouldCombineMoveAndRotate() throws Exception {
		robot.place(3, 4, Direction.EAST);
		robot.move();
		robot.right();
		robot.move();
		robot.left();
		robot.move();
		assertEquals(robot.report(), "5,3,EAST");
	}

	@Test
	public void shouldIgnoreMovingOutsideTableAllSides() throws Exception {
		robot.place(0, 0, Direction.NORTH);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < TableTop.LENGTH + 1; j++) {
				robot.move();
			}

			robot.right();
		}

		assertEquals(robot.report(), "0,0,NORTH");
	}
}
