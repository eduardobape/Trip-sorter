package com.eduardo.boardingcards;

import com.eduardo.transport.Train;

public class TrainBoardingCard extends BoardingCard {

	@Override
	public String showInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Take train ").append( ((Train)getTransport()).getTrainNumber() )
			.append(" from ").append(getDeparture().getCity()).append(" to ")
			.append(getDestination().getCity()).append(". Sit in seat ").append(getSeat())
			.append("\n");
		return sb.toString();
	}

}
