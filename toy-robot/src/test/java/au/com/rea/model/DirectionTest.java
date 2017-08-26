package au.com.rea.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import au.com.rea.model.Direction;

public class DirectionTest {
	@Test
	public void shouldReturnTheNextElement() throws Exception {
		assertEquals(Direction.EAST, Direction.NORTH.getNext());
	}

	@Test
	public void shouldReturnFirstElementWhenAtLastElementAndCallNext() throws Exception {
		assertEquals(Direction.NORTH, Direction.WEST.getNext());
	}

	@Test
	public void shouldReturnThePreviousElement() throws Exception {
		assertEquals(Direction.EAST, Direction.SOUTH.getPrevious());
	}

	@Test
	public void shouldReturnLastElementWhenAtFirstElementAndCallPrev() throws Exception {
		assertEquals(Direction.WEST, Direction.NORTH.getPrevious());
	}
}