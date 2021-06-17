package rockpaperscissorsws.repos;

import rockpaperscissorsws.domain.entities.Player;

public interface IPlayerRepository {

	/**
	 * Creates a new Player entity with the provided player id
	 * 
	 * @param playerId
	 * 		The unique identifier of the new player to create
	 * @return 
	 * 		A new {@link Player} entity object
	 */
	Player createNewPlayer(String playerId);

	/**
	 * Retrieves the Player entity by its unique id
	 * 
	 * @param playerId
	 * 		The unique identifier of the player to retrieve
	 * @return
	 * 		A {@link Player} entity object
	 */
	Player retrievePlayerById(String playerId);
}