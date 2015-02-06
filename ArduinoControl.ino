#include <AFMotor.h>

//Setup the motors
AF_DCMotor rightMotor(2, MOTOR12_1KHZ);
AF_DCMotor leftMotor(3, MOTOR34_1KHZ);

//Setup constants for the serial input
const byte DRIVE_FORWARD = 1;
const byte DRIVE_REVERSE = 2;
const byte TURN_RIGHT = 3;
const byte TURN_LEFT = 4;
const byte STOP = 5;

//Setup bytes to keep track of the input and the previous input
byte input;
byte prevInput;

void setup() {
 Serial.begin(9600); //Begin Serial
 //Set speed for the motors, range is 0-255
 rightMotor.setSpeed(255);
 leftMotor.setSpeed(255);
}

void loop() {
    input = Serial.read(); //Check the serial input
    
    //If a new command is send it will be read 
    //and the corresponding method called
    if (input != prevInput) {
      switch (input) {
       case 1:
       driveForward();
       break;
       
       case 2:
       driveReverse();
       break;
       
       case 3:
       turnRight();
       break;
       
       case 4:
       turnLeft();
       break;
       
       case 5:
       stopMoving();
       break;
      }
    }
    
    prevInput = input;
  
}

//Function to drive the robot forward
void driveForward() {
  rightMotor.run(FORWARD);
  leftMotor.run(FORWARD);
}

//Function to drive the robot backwards
void driveReverse() {
  rightMotor.run(BACKWARD);
  leftMotor.run(BACKWARD);
}

//Function to turn the robot right
void turnRight() {
  rightMotor.run(BACKWARD);
  leftMotor.run(FORWARD);
}

//Function to turn the robot left
void turnLeft() {
  rightMotor.run(FORWARD);
  leftMotor.run(BACKWARD);
}

//Function to cut power to motors,
//if robot is weighed down it will stop
void stopMoving() {
 rightMotor.run(RELEASE);
 leftMotor.run(RELEASE);

}
