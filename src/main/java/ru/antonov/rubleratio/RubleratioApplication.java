package ru.antonov.rubleratio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RubleratioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RubleratioApplication.class, args);
	}

}
