package model;

import model.interfaces.Player;

public class SimplePlayer implements Player {
	private String id;
	private String name;
	private int points, bet, result;

	public SimplePlayer(String id, String name, int points) {
		this.id = id;
		this.name = name;
		this.points = points;
	}

	@Override
	public String getPlayerName() {
		return name;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.name = playerName;
		
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
		
	}

	@Override
	public String getPlayerId() {
		return id;
	}

	@Override
	public boolean placeBet(int bet) {
		if(bet > this.getPoints())
			return false;
		this.bet = bet;	
		this.setPoints(this.getPoints()-bet);
		return true;
	}

	@Override
	public int getBet() {
		// TODO Auto-generated method stub
		return bet;
	}

	@Override
	public void resetBet() {
		bet = 0;
	}

	@Override
	public int getResult() {
		return result;
	}

	@Override
	public void setResult(int result) {
		this.result = result;
	}

}
