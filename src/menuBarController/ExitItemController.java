package menuBarController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitItemController implements ActionListener {

	//Terminates the program
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);

	}

}
