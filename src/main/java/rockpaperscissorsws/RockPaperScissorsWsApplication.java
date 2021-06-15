package rockpaperscissorsws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
	scanBasePackageClasses = ControllerComponentScanTarget.class
)
public class RockPaperScissorsWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockPaperScissorsWsApplication.class, args);
	}
}