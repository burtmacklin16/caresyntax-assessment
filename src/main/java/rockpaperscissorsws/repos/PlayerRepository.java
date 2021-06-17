package rockpaperscissorsws.repos;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rockpaperscissorsws.domain.entities.Player;
import rockpaperscissorsws.persistence.PersistencePlayer;
import rockpaperscissorsws.persistence.PersistencePlayerRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlayerRepository implements IPlayerRepository {
	
	private final PersistencePlayerRepository persistenceRepo;
	
	/**
	* @see rockpaperscissorsws.repos.IPlayerRepository#createNewPlayer(java.lang.String)
	*/
	@Override
	public Player createNewPlayer(final String playerId) {
		
		final PersistencePlayer persistenceEntity = new PersistencePlayer();
		persistenceEntity.setPlayerId(playerId);
		
		persistenceRepo.save(persistenceEntity);
		
		return mapPersistenceEntityToDomain(persistenceEntity);
	}

	/**
	* @see rockpaperscissorsws.repos.IPlayerRepository#retrievePlayerById(java.lang.String)
	*/
	@Override
	public Player retrievePlayerById(final String playerId) {
		
		final PersistencePlayer persistenceEntity = persistenceRepo.findByPlayerId(playerId)
												     		       .orElseGet(() -> {
												     		    	   final PersistencePlayer p = new PersistencePlayer();
												     		    	   p.setPlayerId(playerId);
												     		    	   return p;
												     		       });
		
		log.debug("Found Player. Object is {}", persistenceEntity.toString());
		
		return mapPersistenceEntityToDomain(persistenceEntity);
	}

	/**
	 * Invokes the required constructor for transforming the persistence domain object into
	 * a proper business domain entity
	 * 
	 * @param persistenceEntity
	 * 		The persistence entity to map
	 * @return
	 * 		A well formed {@link Player} domain entity
	 */
	private Player mapPersistenceEntityToDomain(final PersistencePlayer persistenceEntity) {
		return new Player(persistenceEntity, persistenceRepo);
	}
}