package rockpaperscissorsws.service;

import java.time.Instant;
import java.util.Collection;
import java.util.Comparator;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import rockpaperscissorsws.domain.RoundStatus;
import rockpaperscissorsws.domain.entities.Player;
import rockpaperscissorsws.domain.values.RoundResult;
import rockpaperscissorsws.persistence.GameStats;
import rockpaperscissorsws.persistence.GameStatsRepository;

@Component
@RequiredArgsConstructor
public class GameReportingService implements IGameReportingService {
	
	private final GameStatsRepository gameStatsRepository;
	
	/**
	* @see rockpaperscissorsws.service.IGameReportingService#recordRound(rockpaperscissorsws.domain.values.RoundResult, rockpaperscissorsws.domain.entities.Player)
	*/
	@Override
	public void recordRound(
			final RoundResult result,
			final Player player) {
		
		if (roundShouldBeRecorded(result)) {
			
			final Collection<GameStats> gameStats = gameStatsRepository.findAll();
			
			if (streakShouldBeRecorded(player, gameStats)) {
				recordPlayerWinningStreak(player);
			}
		}
	}

	/**
	 * Checks the provided result to see if the round needs to be recorded
	 * 
	 * @param result
	 * 		The result of the round to check
	 * @return
	 * 		Whether or not the round needs to be recorded
	 */
	private boolean roundShouldBeRecorded(final RoundResult result) {
		return result.getResultOfRound().equals(RoundStatus.WIN);
	}

	/**
	 * Checks to see whether the provided player has broken the all time streak
	 * or if it is the first win to be recorded
	 * 
	 * @param player
	 * 		The {@link Player} entity with the streak
	 * @param gameStatsOptional
	 * 		The Optional of the persistence object representing the lifetime game stats
	 * @return
	 */
	private boolean streakShouldBeRecorded(final Player player, final Collection<GameStats> gameStats) {
		return gameStats.isEmpty() ||
				gameStats.stream()
						 .max(Comparator.comparing(GameStats::getRecordedTimestamp))
						 .get()
						 .getLongestWinningStreak() < player.getLongestWinningStreak();
	}

	/**
	 * Creates a new {@link GameStats} persistence object containing the
	 * player's id and longest win streak
	 * 
	 * @param player
	 * 		The {@link Player} entity with the streak
	 */
	private void recordPlayerWinningStreak(final Player player) {

		final GameStats newGameStats = new GameStats();

		newGameStats.setLongestWinningStreak(player.getLongestWinningStreak());
		newGameStats.setPlayerId(player.getPlayerId());
		newGameStats.setRecordedTimestamp(Instant.now());
		
		gameStatsRepository.save(newGameStats);
	}
}