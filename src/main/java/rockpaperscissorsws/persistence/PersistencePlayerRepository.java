package rockpaperscissorsws.persistence;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersistencePlayerRepository extends MongoRepository<PersistencePlayer, String> {
	
	/**
	 * Attempts to retrieve a persistence player entity based on its unique identifier
	 * 
	 * @param playerId
	 * 		The unique identifier for the player
	 * @return
	 * 		An optional representing whether or not the player was retrieved
	 */
	Optional<PersistencePlayer> findByPlayerId(String playerId);
}