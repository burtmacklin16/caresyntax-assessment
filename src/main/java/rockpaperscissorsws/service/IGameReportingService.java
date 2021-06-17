package rockpaperscissorsws.service;

import rockpaperscissorsws.domain.entities.Player;
import rockpaperscissorsws.domain.values.RoundResult;

public interface IGameReportingService {
	
	/**
	 * Records the result of the round and the player involved
	 * with the game
	 * 
	 * @param result
	 * 		The outcome of the round
	 * @param player
	 * 		The player involved in the round
	 */
	void recordRound(RoundResult result, Player player);
}