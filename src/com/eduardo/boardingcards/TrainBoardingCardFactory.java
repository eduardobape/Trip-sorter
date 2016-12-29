package com.eduardo.boardingcards;

public class TrainBoardingCardFactory implements BoardingCardFactory {

	@Override
	public BoardingCard createBoardingCard() {
		return new TrainBoardingCard();
	}

}
