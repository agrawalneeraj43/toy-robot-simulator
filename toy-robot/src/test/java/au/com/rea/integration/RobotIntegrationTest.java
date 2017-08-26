package au.com.rea.integration;

import au.com.rea.controller.RobotController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class RobotIntegrationTest {
    private RobotController controller;

    @Before
    public void before() {
        controller = new RobotController();
    }

    @Test
    public void shouldPlace() throws Exception {
        controller.input("PLACE 3,2,EAST");
        assertEquals("3,2,EAST", controller.input("REPORT"));
    }

    @Test
    public void shouldPlaceAndMove() throws Exception {
    	controller.input("PLACE 3,2,EAST");
        controller.input("MOVE");
        assertEquals("4,2,EAST", controller.input("REPORT"));
    }

    @Test
    public void shouldPlaceAndRotate() throws Exception {
    	controller.input("PLACE 3,4,EAST");
        controller.input("LEFT");
        assertEquals("3,4,NORTH", controller.input("REPORT"));
    }

    @Test
    public void shouldPlaceAndHonourAnotherPlace() throws Exception {
    	  controller.input("PLACE 3,2,EAST");
        controller.input("MOVE");
        controller.input("PLACE 3,4,EAST");
        assertEquals("3,4,EAST", controller.input("REPORT"));
    }

    @Test
    public void shouldMoveAndRotate() throws Exception {
        controller.input("PLACE 1,2,EAST");
        controller.input("MOVE");
        controller.input("MOVE");
        controller.input("LEFT");
        controller.input("MOVE");
        assertEquals("3,3,NORTH", controller.input("REPORT"));
    }

    @Test
    public void shouldIgnoreInputsBeforeValidPlace() throws Exception {
        controller.input("PLACE -1,0,NORTH");
        controller.input("LEFT");
        assertEquals("", controller.input("REPORT"));
    }

    @Test
    public void shouldNotFallOutsideTable() throws Exception {
        controller.input("PLACE 10,2,EAST");
        controller.input("MOVE");
        controller.input("PLACE 4,4,NORTH");
        controller.input("MOVE");
        controller.input("LEFT");

        for (int i = 0; i < 7; i++) {
            controller.input("MOVE");
        }

        assertEquals("0,5,WEST", controller.input("REPORT"));
    }

    @Test
    public void shouldReturnEmptyStringOnPlace() throws Exception {
        assertEquals("", controller.input("PLACE 3,0,EAST"));
    }

    @Test
    public void shouldReturnEmptyStringOnLeft() throws Exception {
        assertEquals("", controller.input("LEFT"));
    }

    @Test
    public void shouldReturnEmptyStringOnRight() throws Exception {
        assertEquals("", controller.input("RIGHT"));
    }

    @Test
    public void shouldReturnEmptyStringOnMOVE() throws Exception {
        assertEquals("", controller.input("MOVE"));
    }
}
