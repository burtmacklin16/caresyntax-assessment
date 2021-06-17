package rockpaperscissorsws.service;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rockpaperscissorsws.domain.RoundStatus;
import rockpaperscissorsws.domain.ThrowSelection;
import rockpaperscissorsws.domain.commands.PlayRoundCommand;
import rockpaperscissorsws.domain.values.RoundResult;

@Component
@Slf4j
public class GameplayService implements IGameplayService {

	/**
	* @see rockpaperscissorsws.service.IGameplayService#playRound(rockpaperscissorsws.domain.commands.PlayRoundCommand)
	*/
	@Override
	public RoundResult playRound(final PlayRoundCommand command) {
		
		log.info("Attempting to play a round of RPS with inputs {}", command.toString());
		
		final RoundStatus status = determineStatusBasedOnThrows(command.getHumanPlayerChoice(),
				                                                command.getHouseChoice());
		
		if (status.equals(RoundStatus.WIN)) {
			addPointToPlayerScore();
			
		} else if (status.equals(RoundStatus.LOSE)) {
			removePointToPlayerScore();
		} 

		updateLongestSteakBasedOnStatus(status);

		return RoundResult.builder()
				.currentScore(getPlayerCurrentScore())
				.houseChoice(command.getHouseChoice())
				.humanPlayerChoice(command.getHumanPlayerChoice())
				.resultOfRound(status)
				.build();
	}

	private RoundStatus determineStatusBasedOnThrows(
			final ThrowSelection humanPlayerChoice,
			final ThrowSelection houseChoice) {
		
		return humanPlayerChoice.determineWinner(houseChoice);
	}

	private void addPointToPlayerScore() {
		// TODO Auto-generated method stub
		
	}

	private void removePointToPlayerScore() {
		// TODO Auto-generated method stub
		
	}

	private void updateLongestSteakBasedOnStatus(RoundStatus status) {
		// TODO Auto-generated method stub
		
	}

	private int getPlayerCurrentScore() {
		// TODO Auto-generated method stub
		return 0;
	}
}