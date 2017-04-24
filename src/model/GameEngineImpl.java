package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import model.interfaces.PlayingCard.Suit;
import model.interfaces.PlayingCard.Value;

public class GameEngineImpl implements GameEngine {
	private List<Player> playerList = new ArrayList<>();
	private Deque<PlayingCard> deck = getShuffledDeck();
	private int dealerResult = 0;
	private GUIGameEngineCallbackImpl gec;

	@Override
	public void dealPlayer(Player player, int delay) {
		int handTotal = 0;
		PlayingCard card;
		while (handTotal <= BUST_LEVEL) {
			try {
	            Thread.sleep(delay);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
			if (deck.size() == 0)
				deck = getShuffledDeck();
			card = deck.pop();

			if (handTotal + card.getScore() <= BUST_LEVEL) {
				handTotal += card.getScore();
				gec.nextCard(player, card, this);
			} else {
				gec.bustCard(player, card, this);
				player.setResult(handTotal);
				handTotal += card.getScore();
			}
		}
		gec.result(player, player.getResult(), this);
	}

	@Override
	public void dealHouse(int delay) {
		int handTotal = 0, result = 0;
		PlayingCard card;

		while (handTotal <= BUST_LEVEL) {
			try {
	            Thread.sleep(delay);
	         } catch (Exception e) {
	            System.out.println(e);
	         }
			if (deck.size() == 0)
				deck = getShuffledDeck();
			card = deck.pop();
			if (handTotal + card.getScore() <= BUST_LEVEL) {
				handTotal += card.getScore();
				gec.nextHouseCard(card, this);
			} else {
				gec.houseBustCard(card, this);
				dealerResult = handTotal;
				handTotal += card.getScore();
			}
		}
		gec.houseResult(dealerResult, this);

	}

	@Override
	public void addPlayer(Player player) {
		if (playerList.size() == 0)
			playerList.add(player);
		if (playerList.contains(player))
			return;
		else
			playerList.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		for (Player player : playerList) {
			if (player.getPlayerId().equals(id)) {
				return player;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		if (playerList.remove(player))
			return true;
		return false;
	}

	@Override
	public void calculateResult() {
		dealHouse(1000);
		for (Player player : playerList) {
			//If player wins
			if (player.getResult() > dealerResult) {
				player.setPoints(player.getPoints() + player.getBet() * 2);
				gec.endRoundPointsUpdate(player, "WON");
				//If it is a draw
			} else if (player.getResult() == dealerResult) {
				player.setPoints(player.getPoints() + player.getBet());
				gec.endRoundPointsUpdate(player, "DRAWN");
			} else {
				gec.endRoundPointsUpdate(player, "LOST");
				//if player loses do nothing
			}
		}

	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallBack) {
		gec = (GUIGameEngineCallbackImpl) gameEngineCallBack;
	}

	@Override
	public void removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Player> getAllPlayers() {
		Collection<Player> players = new LinkedList<>();
		for (Player player : playerList) {
			players.add(player);
		}
		return players;
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		player.placeBet(bet);
		return true;
	}

	@Override
	public Deque<PlayingCard> getShuffledDeck() {
		List<PlayingCard> cardsList = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Value val : Value.values()) {
				PlayingCardImpl card = new PlayingCardImpl(val, suit);
				cardsList.add(card);
			}
		}
		Collections.shuffle(cardsList);
		deck = new ArrayDeque<>(cardsList);

		return deck;
	}

}
