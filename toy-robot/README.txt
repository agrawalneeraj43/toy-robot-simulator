Toy Robot Simulator
===================


Description
-----------

- This is a command line application 

- It is a simulation of a toy robot moving on a square tabletop,
  of dimensions 5 units x 5 units considering no other obstructions on the table surface.

- The robot is free to roam around the surface of the table and is
  prevented from falling to destruction. Any movement that would result in the
  robot falling from the table has been prevented and further valid
  movement commands are allowed.

- PLACE will put the toy robot on the table in position X,Y and facing NORTH,SOUTH, EAST or WEST.
  
- The origin (0,0) is considered to be the SOUTH WEST most corner.

- The first valid command to the robot is a PLACE command, after that, any  sequence of commands may be issued, in any order, including another PLACE
  command. The application will discard all commands in the sequence until  a valid PLACE command has been executed.

- MOVE will move the toy robot one unit forward in the direction it is  currently facing.

- LEFT and RIGHT will rotate the robot 90 degrees in the specified direction  without changing the position of the robot.

- REPORT will announce the X,Y and F of the robot on standard output

- A robot that is not on the table will ignore the MOVE, LEFT, RIGHT  and REPORT commands

- Input is from the standard input


### Example a

    PLACE 0,0,NORTH
    MOVE
    REPORT

Output:

    0,1,NORTH

### Example b

    PLACE 0,0,NORTH
    LEFT
    REPORT

Output:

    0,0,WEST

### Example c

    PLACE 1,2,EAST
    MOVE
    MOVE
    LEFT
    MOVE
    REPORT

Output

    3,3,NORTH

Build and Execution Steps
-------------------------

This is a simple Java application and could be built using the following maven command
mvn clean install

The above command generates the SNAPSHOT jar and install it in local repository.

Run the above generated jar from command line after navigating to the jar directory as under:
java -jar toy-robot-1.0-SNAPSHOT.jar 

Use 'EXIT/exit' to quit the application




