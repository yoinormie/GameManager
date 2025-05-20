package com.yoi.GameManager;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GameManagerApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		SpringApplication.run(GameManagerApplication.class, args);
	}

}
