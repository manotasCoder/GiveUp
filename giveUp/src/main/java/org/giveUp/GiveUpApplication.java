package org.giveUp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class GiveUpApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GiveUpApplication.class, args);
	}

}
