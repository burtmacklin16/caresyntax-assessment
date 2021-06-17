package rockpaperscissorsws.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class PersistencePlayer {
	
	@Id
	private String id;
	
	@Version
	private Long version;

	private int currentScore;
	private int longestWinningStreak;
	private String playerId;
}