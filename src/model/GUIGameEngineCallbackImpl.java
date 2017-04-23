package model;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.AppFrame;

public class GUIGameEngineCallbackImpl implements GameEngineCallback {
	private AppFrame appFrame;

	public GUIGameEngineCallbackImpl(AppFrame appFrame) {
		this.appFrame = appFrame;
	}

	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		appFrame.getEditorPanel()
				.AddToTextArea(player.getPlayerName() + "'s next card is " + card.getValue() + " of " + card.getSuit());
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		appFrame.getEditorPanel().AddToTextArea(
				player.getPlayerName() + " has busted with card " + card.getValue() + " of " + card.getSuit());

	}

	@Override
	public void result(Player player, int result, GameEngine engine) {
		appFrame.getEditorPanel().AddToTextArea("\n" + player.getPlayerName() + "'s hand is worth " + result + "\n");
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		appFrame.getEditorPanel().AddToTextArea("Houses' next card is " + card.getValue() + " of " + card.getSuit());
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		appFrame.getEditorPanel()
				.AddToTextArea("House has busted with card " + card.getValue() + " of " + card.getSuit());

	}

	@Override
	public void houseResult(int result, GameEngine engine) {
		appFrame.getEditorPanel().AddToTextArea("\n Houses' hand is worth " + result + "\n");
	}

}
