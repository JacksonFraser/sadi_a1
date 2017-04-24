package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.SimplePlayer;
import view.AppFrame;

public class PlaceBetController implements ActionListener {
	private AppFrame appFrame;

	public PlaceBetController(AppFrame appFrame) {
		this.appFrame = appFrame;
	}

	//Creates a new frame for placing a bet
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame d = new JFrame();
		d.setLayout(new BorderLayout());
		d.setBounds(200, 150, 400, 150);
		d.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		d.setContentPane(panel);

		JLabel pName = new JLabel("Bet Amount");
		pName.setBounds(10, 10, 150, 25);
		panel.add(pName);

		JTextField bet = new JTextField(20);
		bet.setBounds(100, 10, 160, 25);
		panel.add(bet);

		JButton createBtn = new JButton("Confirm");
		createBtn.setBounds(10, 50, 150, 25);
		panel.add(createBtn);
		d.setVisible(true);
		createBtn.addActionListener(new ActionListener() {
			
			//Sets the bet amount as long as certain conditions are met
			public void actionPerformed(ActionEvent e) {
				if (!parseBet(bet)) {
					appFrame.displayErrorMessage("Invalid Bet Input");
					d.dispose();
				} else {
					int betInt = Integer.parseInt(bet.getText());
					if (appFrame.getPlayer() == null) {
						appFrame.displayErrorMessage("Please Create Player Before Placing Bet");
						d.dispose();
					} else if (betInt < 10 || betInt > appFrame.getPlayer().getPoints()) {
						appFrame.displayErrorMessage("Invalid Bet Amount");
						d.dispose();
					} else {
						appFrame.setBet(betInt);
						appFrame.getEditorPanel().addToTextArea("Bet amount has been set to "+betInt);
						d.dispose();
					}
				}
			}
		});
	}

	public boolean parseBet(JTextField bet) {
		try {
			Integer.parseInt(bet.getText());

		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

}
