package cz.zcu.marekvidlak.piggybank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * It's a Spring Boot application
 */
@SpringBootApplication
public class PiggyBankApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PiggyBankApplication.class, args);
	}

}
