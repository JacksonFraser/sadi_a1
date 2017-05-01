package view;


import model.GameEngineCallbackImpl;
import model.GameEngineImpl;
import model.interfaces.GameEngine;

public class GUIClient {
	public static void main(String[] args) {
		final GameEngine gameEngine = new GameEngineImpl();
		AppFrame appFrame = new AppFrame(gameEngine);
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl(appFrame));

		
	
	}

}
