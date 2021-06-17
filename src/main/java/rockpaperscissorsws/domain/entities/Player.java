package rockpaperscissorsws.domain.entities;

import lombok.Getter;
import rockpaperscissorsws.persistence.PersistencePlayer;
import rockpaperscissorsws.persistence.PersistencePlayerRepository;

public class Player {

	@Getter
	private int currentScore;

	@Getter
	private int longestWinningStreak;

	@Getter
	private String playerId;

	private final PersistencePlayerRepository persistenceRepo;
	
	public Player(
			final PersistencePlayer persistenceEntity,
			final PersistencePlayerRepository persistenceRepo) {

		this.currentScore = persistenceEntity.getCurrentScore();
		this.longestWinningStreak = persistenceEntity.getLongestWinningStreak();
		this.playerId = persistenceEntity.getPlayerId();
		
		this.persistenceRepo = persistenceRepo;
	}
	
	/**
	 * Updates the Player's internals following a win
	 */
	public void recordWin() {
		
		currentScore++;
		longestWinningStreak++;
		
		save();
	}

	/**
	 * Updates the Player's internals following a loss
	 */
	public void recordLoss() {

		currentScore--;
		longestWinningStreak = 0;

		save();
	}

	/**
	 * Maps this entity to a persistence domain object and executes the save operation
	 */
	private void save() {

		final PersistencePlayer persistenceEntity = persistenceRepo.findByPlayerId(playerId)
												     		       .orElseGet(() -> {
												     		    	   final PersistencePlayer p = new PersistencePlayer();
												     		    	   p.setPlayerId(playerId);
												     		    	   return p;
												     		       });
		
		persistenceEntity.setCurrentScore(currentScore);
		persistenceEntity.setLongestWinningStreak(longestWinningStreak);
		persistenceEntity.setPlayerId(playerId);
		
		persistenceRepo.save(persistenceEntity);
	}
}