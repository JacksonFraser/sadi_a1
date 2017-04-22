package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Deque;

import model.ConsoleGameEngineCallbackImpl;
import model.interfaces.PlayingCard;
import view.AppFrame;
import view.ToolBar;

public class DealController implements ActionListener{
	
	private AppFrame appFrame;
	public DealController(AppFrame appFrame) {
		this.appFrame = appFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		appFrame.getGameEngine().addGameEngineCallback(new ConsoleGameEngineCallbackImpl());
		appFrame.getGameEngine().addPlayer(appFrame.getPlayer());
		appFrame.getGameEngine().dealPlayer(appFrame.getPlayer(), 1000);
		appFrame.getGameEngine().calculateResult();
	}

}
