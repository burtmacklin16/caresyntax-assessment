package rockpaperscissorsws.domain.commands;

import lombok.Builder;
import lombok.Value;
import rockpaperscissorsws.domain.PlaySelection;

@Value
@Builder
public class PlayRoundCommand {

	private final PlaySelection humanPlayerChoice;
	private final PlaySelection houseChoice;
}