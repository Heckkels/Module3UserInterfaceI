package heck_module3ct_userinterface;

//Application to illustrate different stylizations of menus with Java. 

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem; 
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;



//Main Class
public class UserInterface {

	public static void main(String[] args) {
		
		//Create JFrame
		JFrame interfaceFrame = new JFrame("User Interface I");
		interfaceFrame.setSize(300, 200);
		
		//Create Menu Bar
		JMenuBar menuBar = new JMenuBar();
		JMenu interfaceMenu = new JMenu("Click Here!");
		
		//Create Date and Time MenuItem and Components 
		JTextField dateNTimeField = new JTextField(10);
		dateNTimeField.setEditable(false);		
		JMenuItem dateNtime = new JMenuItem("Date and Time");
		
		LocalDateTime now = LocalDateTime.now();		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		String formatDateNTime = now.format(format);
		
		//Action Listener to Retrieve Current Time when Pressed
			dateNtime.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dateNTimeField.setText("It is currently: " + formatDateNTime);

				}
			});
			
		//Create Text Box MenuItem and Components
		JMenuItem textBox = new JMenuItem("Text Box");
			
		//Action Listener to Print dateNtime's Text to a New Text File
			textBox.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						FileOutputStream logText = null;
						PrintWriter outFS = null;
								
						logText = new FileOutputStream("log.txt");
						outFS = new PrintWriter(logText);
						
						outFS.println(formatDateNTime);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		
		//Create Green Background MenuItem and Components
		JMenuItem greenBKG = new JMenuItem("Make it Green");
		
			greenBKG.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Color backgroundColor = new Color(0, 153, 0);
					interfaceFrame.getContentPane().setBackground(backgroundColor);
				}
				
			});
		
		
		//Create Exit Program MenuItem and Components
		JMenuItem exit = new JMenuItem("Exit Program");
			exit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					interfaceFrame.setVisible(false);
				}
			});
		
		
		
		
		interfaceMenu.add(dateNtime);
		interfaceMenu.add(textBox);
		interfaceMenu.add(greenBKG);
		interfaceMenu.add(exit);
		
		interfaceFrame.add(dateNTimeField);
		
		interfaceFrame.setJMenuBar(menuBar);
		menuBar.add(interfaceMenu);
		
		interfaceFrame.setVisible(true);
		
	}
	
}
