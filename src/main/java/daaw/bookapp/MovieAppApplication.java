package daaw.bookapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class MovieAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieAppApplication.class, args);
	}
}