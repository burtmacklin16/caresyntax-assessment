package rockpaperscissorsws.service;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rockpaperscissorsws.domain.RoundStatus;
import rockpaperscissorsws.domain.ThrowSelection;
import rockpaperscissorsws.domain.commands.PlayRoundCommand;
import rockpaperscissorsws.domain.entities.Player;
import rockpaperscissorsws.domain.values.RoundResult;
import rockpaperscissorsws.repos.IPlayerRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class GameplayService implements IGameplayService {
	
	private final IPlayerRepository playerRepository;
	private final IGameReportingService gameReportingService;

	/**
	* @see rockpaperscissorsws.service.IGameplayService#playRound(rockpaperscissorsws.domain.commands.PlayRoundCommand)
	*/
	@Override
	public RoundResult playRound(final PlayRoundCommand command) {
		
		log.info("Attempting to play a round of RPS with inputs {}", command.toString());
		
		final Player humanPlayer = playerRepository.retrievePlayerById(command.getPlayerId());
		
		final RoundStatus status = determineStatusBasedOnThrows(command.getHumanPlayerChoice(),
				                                                command.getHouseChoice());
		
		if (status.equals(RoundStatus.WIN)) {
			humanPlayer.recordWin();
			
		} else if (status.equals(RoundStatus.LOSE)) {
			humanPlayer.recordLoss();
		} 
		
		final RoundResult result = RoundResult.builder()
				.currentScore(humanPlayer.getCurrentScore())
				.houseChoice(command.getHouseChoice())
				.humanPlayerChoice(command.getHumanPlayerChoice())
				.resultOfRound(status)
				.build();
		
		gameReportingService.recordRound(result, humanPlayer);
		
		return result;
	}

	/**
	 * Determines the outcome of the round based on the throws
	 * by both the human and the house
	 * 
	 * @param humanPlayerChoice
	 * 		The human's throw
	 * @param houseChoice
	 * 		The house's throw
	 * @return
	 * 		The result of the round
	 */
	private RoundStatus determineStatusBasedOnThrows(
			final ThrowSelection humanPlayerChoice,
			final ThrowSelection houseChoice) {
		
		return humanPlayerChoice.determineWinner(houseChoice);
	}
}