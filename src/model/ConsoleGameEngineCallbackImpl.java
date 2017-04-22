package model;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import model.interfaces.PlayingCard;

public class ConsoleGameEngineCallbackImpl implements GameEngineCallback {

	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) {
		System.out.println(player.getPlayerName()+"'s next card is "
				+ card.getValue()+ " of "+card.getSuit());
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void result(Player player, int result, GameEngine engine) {
		System.out.println(player.getPlayerName()+"'s hand worth "+result);
		System.out.println();
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) {
		System.out.println("Houses' next card is "
				+ card.getValue()+ " of "+card.getSuit());
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void houseResult(int result, GameEngine engine) {
		System.out.println("House's hand worth "+result);
	}

}
