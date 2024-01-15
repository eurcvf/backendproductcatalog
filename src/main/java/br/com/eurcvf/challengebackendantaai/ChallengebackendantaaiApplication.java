package br.com.eurcvf.challengebackendantaai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ChallengebackendantaaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengebackendantaaiApplication.class, args);
	}

}
