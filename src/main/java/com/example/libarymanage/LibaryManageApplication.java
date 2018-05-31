package com.example.libarymanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.libarymanage"})
public class LibaryManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibaryManageApplication.class, args);
	}
}
