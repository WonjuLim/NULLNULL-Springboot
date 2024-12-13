package com.teamproject.festival.gather.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 축제 동행 리스트
public class GatherDto {

    private String gatherId;
    // 동행 아이디

    private String gtTitle;
    // 제목

    private LocalDateTime gtRgDate;
    // 등록일

    private String preferGender;
    // 선호 성별

    private String preferAge;
    // 선호 연령

    private String gtImg;
    // 이미지

    private Integer gtCount;
    // 조회수

    private String userId;
}
