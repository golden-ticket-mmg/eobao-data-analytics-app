package com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.data.ScreenTimes;
import com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.repo.ScreentimesRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Service
@Slf4j
public class DataPopulator {

    @Autowired
    private ScreentimesRepository screentimesRepository;

    @PostConstruct
    @SneakyThrows
    public void init() {
        log.info("Pre-population screen times data ...");
        InputStream in
                = this.getClass().getClassLoader().getResourceAsStream("screentimes.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        ScreenTimes screenTimes = mapper.readValue(in, ScreenTimes.class);
        log.info("ScreenTimes={} loaded", screenTimes.getScreentimes().size());
        screenTimes.getScreentimes().stream().forEach(c -> screentimesRepository.save(c));
    }
}
