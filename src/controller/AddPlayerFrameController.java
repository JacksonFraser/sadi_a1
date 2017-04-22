package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AppFrame;
import view.CreatePlayerFrame;
import view.ToolBar;

public class AddPlayerFrameController implements ActionListener {
	private AppFrame appframe;
	


	public AddPlayerFrameController(ToolBar toolBar) {
		this.appframe = toolBar.getAppFrame();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		CreatePlayerFrame cpf = new CreatePlayerFrame(this.appframe);
		
	}

}
