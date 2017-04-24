package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.AddPlayerController;

public class CreatePlayerFrame extends JFrame {

	/**
	 * Frame used to add player
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<Integer> cBox;
	private JPanel panel;
	private JTextField name;
	private AppFrame appFrame;

	public CreatePlayerFrame(AppFrame appframe) {
		super("Create Player");
		setLayout(new BorderLayout());
		setBounds(200, 150, 400, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(null);
		setContentPane(panel);
		this.setAppFrame(appframe);

		JLabel pName = new JLabel("Player Name");
		pName.setBounds(10, 10, 150, 25);
		panel.add(pName);

		name = new JTextField(20);
		name.setBounds(200, 10, 160, 25);
		panel.add(name);

		JLabel pPoints = new JLabel("Choose Points");
		pPoints.setBounds(10, 40, 150, 25);
		panel.add(pPoints);

		cBox = new JComboBox<>();
		cBox.addItem(400);
		cBox.addItem(600);
		cBox.addItem(800);
		cBox.addItem(1000);

		cBox.setBounds(200, 40, 160, 25);
		panel.add(cBox);

		JButton createBtn = new JButton("Create");
		createBtn.setBounds(10, 80, 150, 25);
		panel.add(createBtn);
		createBtn.addActionListener(new AddPlayerController(this));
		setVisible(true);
	}

	public String getName() {
		return this.name.getText();
	}

	public int getPoints() {
		int points = Integer.parseInt(cBox.getSelectedItem().toString());
		return points;
	}

	public AppFrame getAppFrame() {
		return appFrame;
	}

	public void setAppFrame(AppFrame appFrame) {
		this.appFrame = appFrame;
	}

	public void displayErrorMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
