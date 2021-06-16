package rockpaperscissorsws.service;

import rockpaperscissorsws.domain.commands.PlayRoundCommand;
import rockpaperscissorsws.domain.values.RoundResult;

public interface IGameplayService {

	/**
	 * Executes a round of RPS using the provided {@link PlayRoundCommand} as its
	 * inputs. Returns a {@link RoundResult} object representing the outcome of
	 * the round
	 * 
	 * @param playRoundCommand 
	 * 		The input command containing information about the player's throws
	 * @return
	 * 		An object containing the details of the result of the round
	 */
	RoundResult playRound(PlayRoundCommand playRoundCommand);
}