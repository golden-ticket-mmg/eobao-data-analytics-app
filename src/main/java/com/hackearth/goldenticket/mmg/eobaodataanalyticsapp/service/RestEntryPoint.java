package com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.service;

import com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.data.ScreenTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("data-analytics")
@Slf4j
public class RestEntryPoint {

    private ScreentimeDetailsService screentimeDetailsService;

    public RestEntryPoint(ScreentimeDetailsService screentimeDetailsService) {
        this.screentimeDetailsService = screentimeDetailsService;
    }

    @GetMapping("/{arn}")
    public ScreenTime getCompany(@PathVariable String arn) {
        log.info("Looking for screen time by ARN {}", arn);
        ScreenTime company = screentimeDetailsService.findByArn(arn);
        log.info("For ARN {} found screen time {}", arn, company);
        return company;
    }

}