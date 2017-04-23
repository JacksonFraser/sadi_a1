package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Deque;

import javax.swing.JOptionPane;

import model.ConsoleGameEngineCallbackImpl;
import model.GUIGameEngineCallbackImpl;
import model.interfaces.PlayingCard;
import view.AppFrame;
import view.EditorPanel;
import view.ToolBar;

public class DealController implements ActionListener {

	private AppFrame appFrame;

	public DealController(AppFrame appFrame) {
		this.appFrame = appFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (appFrame.getPlayer() == null)
			appFrame.displayErrorMessage("Please Create Player Before Starting Game");
		else if (appFrame.getPlayer().getPoints() < appFrame.getPlayer().getBet()) {
			appFrame.displayErrorMessage("Not Enough Points");
		} else {
			appFrame.getGameEngine().addGameEngineCallback(new GUIGameEngineCallbackImpl(appFrame));
			appFrame.getPlayer().placeBet(appFrame.getBet());
			appFrame.getGameEngine().addPlayer(appFrame.getPlayer());
			appFrame.getGameEngine().dealPlayer(appFrame.getPlayer(), 1000);
			appFrame.getGameEngine().calculateResult();
		}
	}

}
