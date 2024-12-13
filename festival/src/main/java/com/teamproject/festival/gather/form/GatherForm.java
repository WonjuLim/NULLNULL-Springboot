package com.teamproject.festival.gather.form;

import com.teamproject.festival.gather.dto.GatherImgDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GatherForm {

    private String id;

    private String userId;
    // 회원 아이디

    @NotBlank(message = "제목은 필수 입력 값 입니다.")
    private String gtTitle;
    // 제목

    private LocalDateTime gtRgDate;
    // 등록일

    @NotBlank(message = "선호 성별은 필수 입력 입니다.")
    private String preferGender;
    // 선호 성별

    @NotBlank(message = "선호 연령은 필수 입력 입니다.")
    private String preferAge;
    // 선호 연령

    private String gtImg;
    // 축제 사진

    private Integer gtCount;

    private List<GatherImgDto> gatherImgList = new ArrayList<>();

    private List<Long> gatherImgIds = new ArrayList<>();

}
