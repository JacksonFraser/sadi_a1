package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import menuBarController.AboutItemController;
import menuBarController.ExitItemController;

public class MenuBar extends JMenuBar {
	/**
	 * Simple menu for displaying "About" and "Exit" options
	 */
	private static final long serialVersionUID = 1L;
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem aboutItem = new JMenuItem("about");
	private JMenuItem exitItem = new JMenuItem("exit");

	public MenuBar(){
		fileMenu.add(aboutItem);
		fileMenu.add(exitItem);
		add(fileMenu);
		exitItem.addActionListener(new ExitItemController());
		aboutItem.addActionListener(new AboutItemController());
	}
}
