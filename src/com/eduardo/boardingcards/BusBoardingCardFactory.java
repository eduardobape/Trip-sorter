package com.eduardo.boardingcards;

public class BusBoardingCardFactory implements BoardingCardFactory {

	@Override
	public BoardingCard createBoardingCard() {
		return new BusBoardingCard();
	}

}
