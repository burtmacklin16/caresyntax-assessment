package rockpaperscissorsws.domain.values;

import lombok.Builder;
import lombok.Value;
import rockpaperscissorsws.domain.ThrowSelection;
import rockpaperscissorsws.domain.RoundStatus;

@Value
@Builder
public class RoundResult {

	private final RoundStatus resultOfRound;;

	private final ThrowSelection humanPlayerChoice;
	private final ThrowSelection houseChoice;
	
	private final int currentScore;
}