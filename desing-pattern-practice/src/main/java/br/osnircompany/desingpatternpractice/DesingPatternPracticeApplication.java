package br.osnircompany.desingpatternpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesingPatternPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesingPatternPracticeApplication.class, args);
	}

}
