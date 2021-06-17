package rockpaperscissorsws.domain.commands;

import lombok.Builder;
import lombok.Value;
import rockpaperscissorsws.domain.ThrowSelection;

@Value
@Builder
public class PlayRoundCommand {

	private final String playerId;
	private final ThrowSelection humanPlayerChoice;
	private final ThrowSelection houseChoice;
}