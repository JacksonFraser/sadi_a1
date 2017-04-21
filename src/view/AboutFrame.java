package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AboutFrame extends JFrame {
	public AboutFrame() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JTextArea textArea = new JTextArea(""
				+ "SADI ASSIGNMENT 1\n"
				+ "	\n"
				+ "Author: Jackson Fraser\n"
				+ "Contact: s3529589@student.rmit.edu.au");
		setBounds(200, 200, 300, 140);
		add(textArea);
		setVisible(true);
	}

}
