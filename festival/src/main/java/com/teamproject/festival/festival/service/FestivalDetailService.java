package com.teamproject.festival.festival.service;

import com.teamproject.festival.controller.FestivalController;
import com.teamproject.festival.dto.FestivalDetailDto;
import com.teamproject.festival.mapper.FestivalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FestivalDetailService {

    @Autowired
    private FestivalMapper festivalMapper;

    public FestivalDetailDto getFestivalDetail(Long ftId){

        FestivalDetailDto festivalDetailDto = festivalMapper.festivalDetail(ftId);

        return festivalDetailDto;
    }
}
