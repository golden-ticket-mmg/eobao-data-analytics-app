package com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.service;

import com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.data.ScreenTime;

public interface ScreentimeDetailsService {

    ScreenTime findByArn(String arn);
}
