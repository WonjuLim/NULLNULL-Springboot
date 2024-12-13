package com.teamproject.festival.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FestivalDetailDto {

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
