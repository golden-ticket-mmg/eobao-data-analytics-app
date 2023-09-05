package com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.service;

import com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.data.ScreenTime;
import com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.repo.ScreentimesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ScreentimeDetailsServiceImpl implements ScreentimeDetailsService {

    private ScreentimesRepository screentimesRepository;

    public ScreentimeDetailsServiceImpl(ScreentimesRepository screentimesRepository) {
        this.screentimesRepository = screentimesRepository;
    }
    @Override
    public List<ScreenTime> findAll() {
        log.info("Looking for all ScreenTime");
        List<ScreenTime> screenTimes = screentimesRepository.findAll();
        log.info("Found a total of {} screen times", screenTimes.size());
        return screenTimes;
    }

    @Override
    public ScreenTime findByArn(String arn) {
        log.info("Looking for ScreenTime by ARN {} in repo", arn);
        Optional<ScreenTime> optCompany = screentimesRepository.findById(arn);
        if (optCompany.isPresent()) {
            log.info("Found for ARN {} company {}", arn, optCompany.get());
            return optCompany.get();
        }
        throw new DataAnalyticsException(
                String.format("No screen time record found for arn=%s", arn));
    }
}
