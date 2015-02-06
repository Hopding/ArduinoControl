package com.ajd1.robotbtrccontrollerv1;

import jssc.SerialPort;
import jssc.SerialPortException;

//SerialControl class is used by the GUI class to send bytes over serial to the Arduino.
public class SerialControl {
	static SerialPort serialPort;
	final private byte FORWARD = 1;
	final private byte REVERSE = 2;
	final private byte RIGHT = 3;
	final private byte LEFT = 4;
	final private byte STOP = 5;
	
	public SerialControl(String comPort) throws SerialPortException {
		serialPort = new SerialPort(comPort);
		serialPort.openPort();
		serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
	}
	
	public void close() throws SerialPortException {
		serialPort.closePort();
	}
	
	public void forward() throws SerialPortException {
		serialPort.writeByte(FORWARD);
	}
	
	public void reverse() throws SerialPortException {
		serialPort.writeByte(REVERSE);
	}
	
	public void right() throws SerialPortException {
		serialPort.writeByte(RIGHT);
	}
	
	public void left() throws SerialPortException {
		serialPort.writeByte(LEFT);
	}
	
	public void stop() throws SerialPortException {
		serialPort.writeByte(STOP);
	}

}
