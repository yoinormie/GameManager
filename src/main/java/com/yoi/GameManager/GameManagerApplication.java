package com.yoi.GameManager;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameManagerApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

//
//		System.out.println("URL --> " + dotenv.get("DB_URL"));
//		System.out.println("pssw --> " + dotenv.get("DB_PASSWORD"));
//		System.out.println("user --> " + dotenv.get("DB_USER"));
		SpringApplication.run(GameManagerApplication.class, args);
	}

}
