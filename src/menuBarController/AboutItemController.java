package menuBarController;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import view.AboutFrame;

public class AboutItemController implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent e) {
		AboutFrame aFrame = new AboutFrame();
	}

}
