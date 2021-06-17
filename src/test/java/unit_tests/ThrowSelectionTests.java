package unit_tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import rockpaperscissorsws.domain.RoundStatus;
import rockpaperscissorsws.domain.ThrowSelection;

@ExtendWith(MockitoExtension.class)
public class ThrowSelectionTests {

	@Test
	public void confirmPaperBeatsRock() {
		assertEquals(RoundStatus.WIN, ThrowSelection.PAPER.determineWinner(ThrowSelection.ROCK));
	}

	@Test
	public void confirmPaperLosesToScissors() {
		assertEquals(RoundStatus.LOSE, ThrowSelection.PAPER.determineWinner(ThrowSelection.SCISSORS));
	}

	@Test
	public void confirmPaperDrawsAgainstPaper() {
		assertEquals(RoundStatus.DRAW, ThrowSelection.PAPER.determineWinner(ThrowSelection.PAPER));
	}

	@Test
	public void confirmRockBeatsScissors() {
		assertEquals(RoundStatus.WIN, ThrowSelection.ROCK.determineWinner(ThrowSelection.SCISSORS));
	}

	@Test
	public void confirmRockLosesToPaper() {
		assertEquals(RoundStatus.LOSE, ThrowSelection.ROCK.determineWinner(ThrowSelection.PAPER));
	}

	@Test
	public void confirmRockDrawsAgainstRock() {
		assertEquals(RoundStatus.DRAW, ThrowSelection.ROCK.determineWinner(ThrowSelection.ROCK));
	}

	@Test
	public void confirmScissorsBeatsPaper() {
		assertEquals(RoundStatus.WIN, ThrowSelection.SCISSORS.determineWinner(ThrowSelection.PAPER));
	}

	@Test
	public void confirmScissorsLosesToRock() {
		assertEquals(RoundStatus.LOSE, ThrowSelection.SCISSORS.determineWinner(ThrowSelection.ROCK));
	}

	@Test
	public void confirmScissorsDrawsAgainstScissors() {
		assertEquals(RoundStatus.DRAW, ThrowSelection.SCISSORS.determineWinner(ThrowSelection.SCISSORS));
	}
}