package rockpaperscissorsws.persistence;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class GameStats {
	
	@Id
	private String id;

	private int longestWinningStreak;
	private String playerId;
	private Instant recordedTimestamp;
}