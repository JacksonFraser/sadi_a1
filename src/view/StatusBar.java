package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class StatusBar extends JPanel {
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
