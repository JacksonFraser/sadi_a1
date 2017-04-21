package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.AddPlayerController;

public class CreatePlayerFrame extends JFrame {
	
	private Integer[] points ={400,600,800,1000};
	private JComboBox<Integer> cBox = new JComboBox<>(points);
	private JPanel panel = createPanel(cBox);
	private JButton btn = new JButton("Create");
	
	public CreatePlayerFrame() {
		super("Create Player");
		setLayout(new BorderLayout());
		setVisible(true);
		setBounds(200, 150, 400, 200);
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private JPanel createPanel(JComboBox<Integer> cBox) {
		JPanel panel = new JPanel();
		
		panel.setLayout(null);
		
		JLabel pName = new JLabel("Player Name");
		pName.setBounds(10, 10, 150, 25);
		panel.add(pName);
		
		JTextField pNameInput = new JTextField(20);
		pNameInput.setBounds(200, 10, 160, 25);
		panel.add(pNameInput);
		
		JLabel pPoints = new JLabel("Choose Points");
		pPoints.setBounds(10, 40, 150, 25);
		panel.add(pPoints);
		
		cBox.setBounds(200, 40, 160, 25);
		panel.add(cBox);
		
		JButton createBtn = new JButton("Create");
		createBtn.setBounds(10, 80, 150, 25);
		panel.add(createBtn);
		createBtn.addActionListener(new AddPlayerController() );
		return panel;
	}

}
