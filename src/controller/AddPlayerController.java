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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (cpf.getName().equals("") || cpf.getName().length() > 15) {
			JOptionPane.showMessageDialog(cpf, "Please enter a valid name");
		} else {
			setPlayer(new SimplePlayer("1", cpf.getName(), cpf.getPoints()));
			appFrame.setPlayer(player);
			cpf.dispose();
		}
	}

	public SimplePlayer getPlayer() {
		return player;
	}

	public void setPlayer(SimplePlayer player) {
		this.player = player;
	}
	

}
