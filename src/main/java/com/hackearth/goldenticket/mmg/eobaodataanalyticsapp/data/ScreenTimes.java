package com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreenTimes {

    List<ScreenTime> screentimes;
}
