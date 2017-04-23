package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
	private GameEngineCallback gec;
	@Override
	public void dealPlayer(Player player, int delay) {
		int handTotal = 0;
		PlayingCard card;
		while (handTotal < BUST_LEVEL) {
			if(deck.size() == 0)
				deck = getShuffledDeck();
			card = deck.pop();
			
			if (handTotal + card.getScore() >= BUST_LEVEL) {
				player.setResult(handTotal);
				gec.bustCard(player, card, this);
			}
			handTotal += card.getScore();
			gec.nextCard(player, card, this);
		}
		gec.result(player, player.getResult(), this);
	}

	@Override
	public void dealHouse(int delay) {
		int handTotal = 0, result = 0;
		PlayingCard card;

		while (handTotal < BUST_LEVEL) {
			if(deck.size() == 0)
				deck = getShuffledDeck();
			card = deck.pop();
			if (handTotal + card.getScore() > BUST_LEVEL){
				dealerResult = handTotal;
				gec.houseBustCard(card, this);
			}
			handTotal += card.getScore();
			gec.nextHouseCard(card, this);
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
		dealHouse(10);
		for (Player player : playerList) {
			if (player.getResult() > dealerResult) {
				System.out.println();
				System.out.print(player.getPlayerName()+" has won, points were "+player.getPoints());
				player.setPoints(player.getPoints() + player.getBet() * 2);
				System.out.print(" and are now "+player.getPoints()+"\n");
				System.out.println();
			} else if (player.getResult() == dealerResult) {
				System.out.println();
				System.out.print(player.getPlayerName()+" has drawn with house, points were "+player.getPoints());
				player.setPoints(player.getPoints() + player.getBet());
				System.out.print(" and are now "+player.getPoints()+"\n");
				System.out.println();
			} else {
				System.out.println();
				System.out.println(player.getPlayerName()+" has lost, points are now "+player.getPoints());
				System.out.println();
			}
		}

	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallBack) {
		gec = gameEngineCallBack;
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
