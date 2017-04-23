package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.EditorModel;

public class EditorPanel extends JPanel {
	
	private EditorModel model;
	private JTextArea textArea = new JTextArea("");
	public EditorPanel(){
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	public EditorModel getEditorModel(){
		return model;
	}
	public void AddToTextArea(String message){
		textArea.append(message+"\n");
	}

}
