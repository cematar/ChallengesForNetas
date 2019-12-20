package com.netas.challenge1.challenge1;


import com.netas.challenge1.challenge1.Parsers.ParseJson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Challenge1Application  {


	public static void main(String[] args) {

		SpringApplication.run(Challenge1Application.class, args);

		ParseJson parseJson = new ParseJson();
		parseJson.readJson("devices.json");

	}
}
