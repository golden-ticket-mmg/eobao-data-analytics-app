package com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.service;

import com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.data.ScreenTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("data-analytics")
@Slf4j
public class RestEntryPoint {

    private ScreentimeDetailsService screentimeDetailsService;

    public RestEntryPoint(ScreentimeDetailsService screentimeDetailsService) {
        this.screentimeDetailsService = screentimeDetailsService;
    }

    @GetMapping("/screentime/all")
    public List<ScreenTime> getScreenTimes() {
        log.info("Looking for all screen times");
        List<ScreenTime> screenTimes = screentimeDetailsService.findAll();
        log.info("Found a total of {} screen times", screenTimes.size());
        return screenTimes;
    }

    @GetMapping("/screentime/{arn}")
    public ScreenTime getScreenTime(@PathVariable String arn) {
        log.info("Looking for screen time by ARN {}", arn);
        ScreenTime screentime = screentimeDetailsService.findByArn(arn);
        log.info("For ARN {} found screen time {}", arn, screentime);
        return screentime;
    }

}