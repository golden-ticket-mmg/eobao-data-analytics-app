package com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.service;

import com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.data.ScreenTime;

import java.util.List;

public interface ScreentimeDetailsService {

    ScreenTime findByArn(String arn);

    List<ScreenTime> findAll();
}
