package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StatusBar extends JPanel {
	/**
	 * Pretty much here to look fancy
	 */
	private static final long serialVersionUID = 1L;
	private JLabel statusLabel1 = new JLabel("Status...");
	
	public StatusBar(){
		setLayout(new GridLayout());
		add(statusLabel1);
		statusLabel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	}
	public void setStatusText(String msg){
		statusLabel1.setText(msg);
	}
}
