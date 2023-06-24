package com.example.jazs24260nbp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "NBP SERVICE REST API",
				version = "1.0",
				description = "This is application to save nbp rates.",
				contact = @Contact(
						name = "s24260",
						email = "s24260@pjwstk.edu.pl"
				)
		)
)
public class JazS24260NbpApplication {

	public static void main(String[] args) {
		SpringApplication.run(JazS24260NbpApplication.class, args);
	}

}
