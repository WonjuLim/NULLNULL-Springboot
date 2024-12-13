package com.teamproject.festival.gather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatherSearchDto {

    private String gtTitle;

    private String gatherId;

    // 축제 아이디
    private String ftId;

    // 예정일
    private Date gtMtdate;

    // 선호 성별
    private String preferGender;

    // 선호 연령대
    private String preferAge;


    // 축제명 도는 축제에 대한 상세 설명
    private String searchBy;

    // 검색어
    private String SearchText;
}
