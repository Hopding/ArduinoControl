package com.ajd1.robotbtrccontrollerv1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import jssc.SerialPortException;
import java.awt.Font;

//RobotBTRCControllerV1GUI class uses a JFrame to display a GUI with four JButtons
//MouseListeners and KeyListeners are used to detect user input and call methods
//in the SerialControl class.
public class RobotBTRCControllerV1GUI {
	private SerialControl serial;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotBTRCControllerV1GUI window = new RobotBTRCControllerV1GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SerialPortException 
	 */
	public RobotBTRCControllerV1GUI() throws SerialPortException {
		String port = JOptionPane.showInputDialog("Enter a COM port (e.g. COM0)");
		serial = new SerialControl(port);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnForward = new JButton();
		btnForward.setFont(new Font("Arial", Font.PLAIN, 11));
		btnForward.setText("FORWARD");
		btnForward.addKeyListener(keyList);
		btnForward.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				try {
					serial.forward();
				} catch (SerialPortException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					serial.stop();
				} catch (SerialPortException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		btnForward.setBounds(162, 9, 90, 75);
		frame.getContentPane().add(btnForward);
		
		JButton btnReverse = new JButton("REVERSE");
		btnReverse.setFont(new Font("Arial", Font.PLAIN, 11));
		btnReverse.setForeground(Color.BLACK);
		btnReverse.setFocusable(false);
		btnReverse.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				try {
					serial.reverse();
				} catch (SerialPortException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					serial.stop();
				} catch (SerialPortException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});

		btnReverse.setBounds(162, 175, 90, 75);
		frame.getContentPane().add(btnReverse);
		
		JButton btnRight = new JButton("RIGHT");
		btnRight.setFont(new Font("Arial", Font.PLAIN, 11));
		btnRight.setFocusable(false);
		btnRight.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				try {
					serial.right();
				} catch (SerialPortException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					serial.stop();
				} catch (SerialPortException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		btnRight.setBounds(261, 87, 75, 77);
		frame.getContentPane().add(btnRight);
		
		JButton btnLeft = new JButton("LEFT");
		btnLeft.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLeft.setFocusable(false);
		btnLeft.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				try {
					serial.left();
				} catch (SerialPortException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					serial.stop();
				} catch (SerialPortException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		btnLeft.setBounds(84, 87, 75, 77);
		frame.getContentPane().add(btnLeft);
	}
	
	KeyListener keyList = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent ev) {
		}

		@Override
		public void keyPressed(KeyEvent ev) {
			char keyChar = Character.toUpperCase(ev.getKeyChar());
			int keyCode = ev.getKeyCode();
			if (keyCode == KeyEvent.VK_UP || keyChar == KeyEvent.VK_W) {
				try {
					serial.forward();
				} catch (SerialPortException e1) {
					System.out.println(e1.getMessage());
				}
			}
			
			if (keyCode == KeyEvent.VK_DOWN || keyChar == KeyEvent.VK_S) {
				try {
					serial.reverse();
				} catch (SerialPortException e1) {
					System.out.println(e1.getMessage());
				}
			}
			
			if (keyCode == KeyEvent.VK_RIGHT || keyChar == KeyEvent.VK_D) {
				try {
					serial.right();
				} catch (SerialPortException e1) {
					System.out.println(e1.getMessage());
				}
			}
			
			if (keyCode == KeyEvent.VK_LEFT || keyChar == KeyEvent.VK_A) {
				try {
					serial.left();
				} catch (SerialPortException e1) {
					System.out.println(e1.getMessage());
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent ev) {
			try {
				serial.stop();
			} catch (SerialPortException e1) {
				System.out.println(e1.getMessage());
			}
		}
		
	};
	
}

