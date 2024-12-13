package com.teamproject.festival.festival.service;

import com.teamproject.festival.dto.FestivalReviewDto;
import com.teamproject.festival.mapper.FestivalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FestivalReviewService {

    @Autowired
    private FestivalMapper festivalMapper;

    public int festivalReview(FestivalReviewDto festivalReviewDto){

        return festivalMapper.festivalReview(festivalReviewDto);
    }
}
