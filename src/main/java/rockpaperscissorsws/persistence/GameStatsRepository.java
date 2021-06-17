package rockpaperscissorsws.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameStatsRepository extends MongoRepository<GameStats, Long> {
	
}