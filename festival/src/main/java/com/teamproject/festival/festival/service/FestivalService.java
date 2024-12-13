package com.teamproject.festival.festival.service;

import com.teamproject.festival.festival.dto.FestivalDetailDto;
import com.teamproject.festival.festival.dto.FestivalListDto;
import com.teamproject.festival.festival.dto.FestivalMainDto;
import com.teamproject.festival.festival.dto.FestivalReviewDto;
import com.teamproject.festival.festival.mapper.FestivalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FestivalService {

    @Autowired
    private FestivalMapper festivalMapper;

    // 메인페이지에 있는 축제 리스트
    public List<FestivalMainDto> festivalMainList(Map map) {
        return festivalMapper.festivalMainList(map);
    }

    public List<FestivalListDto> festivalList(){
        return festivalMapper.festivalList();
    }

    public FestivalDetailDto getFestivalDetail(Long ftId){

        FestivalDetailDto festivalDetailDto = festivalMapper.festivalDetail(ftId);

        return festivalDetailDto;
    }

    public int festivalReview(FestivalReviewDto festivalReviewDto){

        return festivalMapper.festivalReview(festivalReviewDto);
    }
}
