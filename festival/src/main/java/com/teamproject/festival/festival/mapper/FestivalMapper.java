package com.teamproject.festival.festival.mapper;

import com.teamproject.festival.festival.dto.FestivalDetailDto;
import com.teamproject.festival.festival.dto.FestivalListDto;
import com.teamproject.festival.festival.dto.FestivalMainDto;
import com.teamproject.festival.festival.dto.FestivalReviewDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FestivalMapper {

    List<FestivalMainDto> festivalMainList(Map map);

    //페스티벌 리스트
    List<FestivalListDto> festivalList();

    //페스티벌 디테일
    FestivalDetailDto festivalDetail(Long ftId);

    //페스티벌 리뷰
    int festivalReview(FestivalReviewDto festivalReviewDto);
}
