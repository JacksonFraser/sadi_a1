package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.EditorModel;

public class EditorPanel extends JPanel {
	
	private EditorModel model;
	private JTextArea textArea = new JTextArea("");
	public EditorPanel(EditorModel model){
		this.model = model;
		textArea.setText(model.getDocument());
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

}
