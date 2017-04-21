package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.AddPlayerController;
import controller.DealController;
import controller.PlaceBetController;

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
		addPlayerButton.addActionListener(new AddPlayerController());

	}
}