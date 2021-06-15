package rockpaperscissorsws;

import lombok.Data;

@Data
public class PlayerMessage {
	
	private String playerId;
	private int longestWinningSequence;
}