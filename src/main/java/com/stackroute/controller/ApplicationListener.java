package com.stackroute.controller;

import com.stackroute.domain.Muzix;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;

@Controller
@PropertySource("classpath:property.properties")
public class ApplicationListener implements org.springframework.context.ApplicationListener<ContextRefreshedEvent> {
    @Value("4")
    private int trackId;
    @Value("${trackName}")
    private String trackName;
    @Value("By Ashwath")
    private String comments;

    @Autowired
    MuzixRepository muzixRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Muzix muzix = new Muzix(trackId,trackName,comments);
        muzixRepository.save(muzix);
    }
}
