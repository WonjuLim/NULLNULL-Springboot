package com.teamproject.festival.festival.form;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FestivalForm {

    private Integer ftId;
    private String ftName;
    private LocalDateTime ftStdate;
    private LocalDateTime ftEddate;
    private String ftText;
    private String ftHost;
    private String ftPhone;
    private String ftAddress;
    private String ftImg;
    private String ftLatitude;
    private String ftLongtitude;
}

