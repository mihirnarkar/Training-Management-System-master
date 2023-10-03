package in.mindcraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "in.mindcraft")
public class TrainingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingServerApplication.class, args);
	}

}
