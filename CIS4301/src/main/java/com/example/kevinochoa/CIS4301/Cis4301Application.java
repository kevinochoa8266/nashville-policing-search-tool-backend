package com.example.kevinochoa.CIS4301;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.example.kevinochoa.CIS4301.NashvillePolicing"})
public class Cis4301Application{

	public static void main(String[] args) {
		SpringApplication.run(Cis4301Application.class, args);
	}

}