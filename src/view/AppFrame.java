package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;


public class AppFrame extends JFrame {
	private MenuBar menuBar = new MenuBar();
	private ToolBar toolbar = new ToolBar(this);
	private EditorPanel editorPanel = new EditorPanel();
	private StatusBar statusBar = new StatusBar();
	public AppFrame(){
		super("SADI Assignment 1");
		setLayout(new BorderLayout());
		setJMenuBar(menuBar);
		this.add(toolbar, BorderLayout.NORTH);
		this.add(editorPanel, BorderLayout.CENTER);
		this.add(statusBar, BorderLayout.SOUTH);
		setVisible(true);
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
