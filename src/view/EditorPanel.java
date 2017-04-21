package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class EditorPanel extends JPanel {
	
	private JTextArea textArea = new JTextArea("Waiting for game to begin...");
	public EditorPanel(){
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

}
