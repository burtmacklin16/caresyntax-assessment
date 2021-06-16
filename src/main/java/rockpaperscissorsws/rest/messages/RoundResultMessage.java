package rockpaperscissorsws.rest.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rockpaperscissorsws.domain.RoundStatus;
import rockpaperscissorsws.domain.PlaySelection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoundResultMessage {

	private RoundStatus resultOfRound;;

	private PlaySelection humanPlayerChoice;
	private PlaySelection houseChoice;
	
	private int currentScore;
}