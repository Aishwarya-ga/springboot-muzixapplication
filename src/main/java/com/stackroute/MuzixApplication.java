package com.stackroute;

import com.stackroute.domain.Muzix;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class MuzixApplication {
	@Autowired
	MuzixRepository muzixRepository;
	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);
	}

}

