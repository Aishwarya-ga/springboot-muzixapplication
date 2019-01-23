package com.stackroute.controller;

import com.stackroute.domain.Muzix;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

@Controller
@PropertySource("classpath:property.properties")
public class CommandLine implements CommandLineRunner {
    private int trackId;
    private String trackName;
    private String comments;
    @Autowired
    MuzixRepository muzixRepository;
    @Autowired
    Environment env;

    @Override
    public void run(String... args) throws Exception {
        Muzix muzix = new Muzix(Integer.parseInt(env.getProperty("trackId")),env.getProperty("trackName"),env.getProperty("comments"));
		muzixRepository.save(muzix);
    }
}
