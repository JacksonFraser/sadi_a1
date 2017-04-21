package model;

import java.util.EnumMap;

import model.interfaces.PlayingCard;

public class PlayingCardImpl implements PlayingCard {
	private Suit suit;
	private Value val;
	public PlayingCardImpl(Value val, Suit suit) {
		this.suit = suit;
		this.val = val;
	}

	@Override
	public Suit getSuit() {

		return suit;
	}

	@Override
	public Value getValue() {
		return val;
	}

	@Override
	public int getScore() {
		switch (this.val) {
		case Ace:
			return 1;
		case Two:
			return 2;
		case Three:
			return 3;
		case Four:
			return 4;
		case Five:
			return 5;
		case Six:
			return 6;
		case Seven:
			return 7;
		case Eight:
			return 8;
		case Nine:
			return 9;
		case Ten:
			return 10;
		case Jack:
			return 10;
		case Queen:
			return 10;
		case King:
			return 10;
		default:
			return 0;
		}
	}

}
