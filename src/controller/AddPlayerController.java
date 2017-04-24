package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.AppFrame;
import view.CreatePlayerFrame;
import view.GUIClient;

public class AddPlayerController implements ActionListener {
	private CreatePlayerFrame cpf;
	private SimplePlayer player;
	private AppFrame appFrame;

	public AddPlayerController(CreatePlayerFrame cpf) {
		this.cpf = cpf;
		this.player = player;
		this.appFrame = cpf.getAppFrame();
	}
	
	//Creates the player from the values in the CreatePlayerFrame
	@Override
	public void actionPerformed(ActionEvent e) {
		if (cpf.getName().equals("") || cpf.getName().length() > 15) {
			cpf.displayErrorMessage("Invalid Name Input");
		} else {
			appFrame.setPlayer(new SimplePlayer("1", cpf.getName(), cpf.getPoints()));
			appFrame.getEditorPanel().addToTextArea("New Player '"+appFrame.getPlayer().getPlayerName()+"' has been added");
			appFrame.getGameEngine().addPlayer(appFrame.getPlayer());
			cpf.dispose();
		}
	}


}
