package com.monkmind.digicampus.configurations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeTableConfig {
    private int maxPeriod;
    private int maxDays;
    public TimeTableConfig(){
        this.maxPeriod = 7;
        this.maxDays = 5;
    }
}
