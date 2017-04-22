package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AppFrame;
import view.CreatePlayerFrame;

public class AddPlayerFrameController implements ActionListener {
	private AppFrame appframe;
	


	@Override
	public void actionPerformed(ActionEvent e) {
		CreatePlayerFrame cpf = new CreatePlayerFrame();
		
	}

}
