package rockpaperscissorsws.domain.values;

import lombok.Builder;
import lombok.Value;
import rockpaperscissorsws.domain.PlaySelection;
import rockpaperscissorsws.domain.RoundStatus;

@Value
@Builder
public class RoundResult {

	private final RoundStatus resultOfRound;;

	private final PlaySelection humanPlayerChoice;
	private final PlaySelection houseChoice;
	
	private final int currentScore;
}