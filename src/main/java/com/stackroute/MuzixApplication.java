package com.stackroute;

import com.stackroute.domain.Muzix;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource("classpath:property.properties")
public class MuzixApplication implements ApplicationListener<ContextRefreshedEvent>,CommandLineRunner{
	@Value("4")
	private int trackId;
	@Value("${trackName}")
	private String trackName;
	@Value("By Ashwath")
	private String comments;

	@Autowired
	MuzixRepository muzixRepository;

	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(MuzixApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		Muzix muzix = new Muzix(trackId,trackName,comments);
		muzixRepository.save(muzix);
	}

	@Override
	public void run(String... args) throws Exception {
		Muzix muzix = new Muzix(Integer.parseInt(env.getProperty("trackId")),env.getProperty("trackName"),env.getProperty("comments"));
		muzixRepository.save(muzix);
	}
}

