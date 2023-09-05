package com.hackearth.goldenticket.mmg.eobaodataanalyticsapp.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Duration;
import java.time.LocalDate;

@Entity
@Table(name = "screentimes")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScreenTime {
    @Id
    private String arn;

    private String customerName;

    @JsonFormat(pattern="dd-MMM-yyyy")
    private LocalDate appStartDate;

    private String screenName;

    private Long timeSpentOnCurrentScreen;

    private Long timeSpentSinceStart;

    private boolean thresholdExceeded;

    private boolean needsInvestigation;

}
