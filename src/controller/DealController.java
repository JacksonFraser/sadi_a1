package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AppFrame;
import view.ToolBar;

public class DealController implements ActionListener{
	
	private AppFrame appFrame;
	public DealController(AppFrame appFrame) {
		this.appFrame = appFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		appFrame.getPlayerName();
	}

}
