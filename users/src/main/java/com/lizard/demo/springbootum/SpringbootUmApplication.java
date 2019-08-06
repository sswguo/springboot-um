package com.lizard.demo.springbootum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.lizard.demo.springbootum"})
public class SpringbootUmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootUmApplication.class, args);
	}

}
