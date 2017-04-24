package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.EditorModel;
import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;

public class AppFrame extends JFrame {
	/**
	 * Main program frame
	 */
	private static final long serialVersionUID = 1L;
	private MenuBar menuBar = new MenuBar();
	private ToolBar toolbar = new ToolBar(this);
	private EditorPanel editorPanel = new EditorPanel();
	private StatusBar statusBar = new StatusBar();
	private GameEngine gameEngine;
	private SimplePlayer player;
	private int bet;

	public AppFrame(GameEngine gameEngine) {
		super("SADI Assignment 1");
		setLayout(new BorderLayout());
		setJMenuBar(menuBar);
		this.add(toolbar, BorderLayout.NORTH);
		this.add(editorPanel, BorderLayout.CENTER);
		this.add(statusBar, BorderLayout.SOUTH);
		this.gameEngine = gameEngine;
		setVisible(true);
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setGameEnginePlayer(SimplePlayer player) {
		gameEngine.addPlayer(player);
	}

	public void getPlayerName() {
		if(this.player != null)
			System.out.println(player.getPlayerName());
	}

	public SimplePlayer getPlayer() {
		return player;
	}

	public void setPlayer(SimplePlayer player) {
		this.player = player;
	}

	public GameEngine getGameEngine(){
		return gameEngine;
	}
	public void displayErrorMessage(String message){
		JOptionPane.showMessageDialog(this, message);
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
	public EditorPanel getEditorPanel() {
		return editorPanel;
	}
}
