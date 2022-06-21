package com.example.spring_boot_vue_js;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootVueJsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVueJsApplication.class, args);
		System.out.println("SPRING BOOT APP STARTEDD");
	}

}
