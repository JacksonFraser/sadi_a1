package view;


import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.AddPlayerFrameController;
import controller.DealController;
import controller.PlaceBetController;

public class ToolBar extends JToolBar {

	private JButton startButton = new JButton("Start Game!");
	private JButton betButton = new JButton("Place Bet");
	private JButton addPlayerButton = new JButton("Add Player");
	private AppFrame appFrame;
	
	public ToolBar(AppFrame appFrame) {
		this.appFrame = appFrame;
		this.setAppFrame(appFrame);
		
		add(startButton);
		startButton.addActionListener(new DealController(appFrame));
		
		add(betButton);
		betButton.addActionListener(new PlaceBetController(appFrame));
		add(addPlayerButton);
		addPlayerButton.addActionListener(new AddPlayerFrameController(this));

	}

	public AppFrame getAppFrame() {
		return appFrame;
	}

	public void setAppFrame(AppFrame appFrame) {
		this.appFrame = appFrame;
	}
}