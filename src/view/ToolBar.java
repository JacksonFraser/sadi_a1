package view;


import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.AddPlayerFrameController;
import controller.DealController;

public class ToolBar extends JToolBar {

	private JButton startButton = new JButton("Start Game!");
	private JButton betButton = new JButton("Place Bet");
	private JButton addPlayerButton = new JButton("Add Player");
	private AppFrame appFrame;
	
	public ToolBar(AppFrame appFrame) {
		this.appFrame = appFrame;
		add(startButton);
		startButton.addActionListener(new DealController());
		add(betButton);
		add(addPlayerButton);
		addPlayerButton.addActionListener(new AddPlayerFrameController());

	}
}