package model;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.AppFrame;

public class GameEngineCallbackImpl implements GameEngineCallback {
	private AppFrame appFrame;

	public GameEngineCallbackImpl(AppFrame appFrame) {
		this.appFrame = appFrame;
	}

	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		appFrame.getEditorPanel()
				.addToTextArea(player.getPlayerName() + "'s next card is " + card.getValue() + " of " + card.getSuit());
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		appFrame.getEditorPanel().addToTextArea(
				player.getPlayerName() + " has busted with card " + card.getValue() + " of " + card.getSuit());

	}

	@Override
	public void result(Player player, int result, GameEngine engine) {
		appFrame.getEditorPanel().addToTextArea("\n" + player.getPlayerName() + "'s hand is worth " + result + "\n");
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		appFrame.getEditorPanel().addToTextArea("Houses' next card is " + card.getValue() + " of " + card.getSuit());
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		appFrame.getEditorPanel()
				.addToTextArea("House has busted with card " + card.getValue() + " of " + card.getSuit());

	}

	@Override
	public void houseResult(int result, GameEngine engine) {
		appFrame.getEditorPanel().addToTextArea("\n Houses' hand is worth " + result + "\n");
		int points = appFrame.getPlayer().getPoints();
		if(appFrame.getPlayer().getResult() > result){
			appFrame.getEditorPanel().addToTextArea(appFrame.getPlayer().getPlayerName()+
					" has WON Points are now "+(points+appFrame.getBet()*2));
		
		}
		else if(appFrame.getPlayer().getResult() < result){
			appFrame.getEditorPanel().addToTextArea(appFrame.getPlayer().getPlayerName()+
					" has LOST Points are now "+(appFrame.getPlayer().getPoints()));
		}
		else{
			appFrame.getEditorPanel().addToTextArea(appFrame.getPlayer().getPlayerName()+
					" has DRAWN Points are now "+(points+appFrame.getBet()));
		}
	}


}
