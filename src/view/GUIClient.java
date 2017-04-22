package view;

import java.util.Deque;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.PlayingCard;

public class GUIClient {
	public static void main(String[] args) {
		new AppFrame();
		final GameEngine gameEngine = new GameEngineImpl();
		Deque<PlayingCard> shuffledDeck = gameEngine.getShuffledDeck();

		
	
	}

}
