package rockpaperscissorsws.domain;

public enum ThrowSelection {
	
	ROCK,
	PAPER,
	SCISSORS;
	
	/**
	 * Checks this {@link ThrowSelection} enum value against another
	 * to determine the winner of the round of throws
	 * 
	 * @param other
	 * 		The other throw
	 * @return
	 */
	public RoundStatus determineWinner(final ThrowSelection other) {
		
		if (this.equals(other)) {
			return RoundStatus.DRAW;
		}

		if (this == ROCK) {
			return handleHumanThrowsRock(other);

		} else if (this == PAPER) {
			return handleHumanThrowsPaper(other);

		} else {
			return handleHumanThrowsScissors(other);
		}
	}

	/**
	 * Determines the {@link RoundStatus} when the human throws Rock
	 * 
	 * @param other
	 * 		The other throw
	 * @return
	 * 		The outcome of the play
	 */
	private RoundStatus handleHumanThrowsRock(final ThrowSelection other) {
		if (other == PAPER) {
			return RoundStatus.LOSE;
			
		} else {
			return RoundStatus.WIN;
		}
	}

	/**
	 * Determines the {@link RoundStatus} when the human throws Paper
	 * 
	 * @param other
	 * 		The other throw
	 * @return
	 * 		The outcome of the play
	 */
	private RoundStatus handleHumanThrowsPaper(final ThrowSelection other) {
		if (other == SCISSORS) {
			return RoundStatus.LOSE;
			
		} else {
			return RoundStatus.WIN;
		}
	}

	/**
	 * Determines the {@link RoundStatus} when the human throws Scissors
	 * 
	 * @param other
	 * 		The other throw
	 * @return
	 * 		The outcome of the play
	 */
	private RoundStatus handleHumanThrowsScissors(final ThrowSelection other) {
		if (other == ROCK) {
			return RoundStatus.LOSE;
			
		} else {
			return RoundStatus.WIN;
		}
	}
}