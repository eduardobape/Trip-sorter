package com.eduardo.boardingcards;

public class AeroplaneBoardingCardFactory implements BoardingCardFactory {

	@Override
	public BoardingCard createBoardingCard() {
		return new AeroplaneBoardingCard();
	}

}
