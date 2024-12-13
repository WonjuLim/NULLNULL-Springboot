package com.teamproject.festival.festival.service;

import com.teamproject.festival.festival.dto.FestivalDetailDto;
import com.teamproject.festival.festival.dto.FestivalListDto;
import com.teamproject.festival.festival.dto.FestivalListDto;
import com.teamproject.festival.festival.mapper.FestivalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FestivalListService {

    @Autowired
    private FestivalMapper festivalMapper;

    public List<FestivalListDto> festivalList(){
        return festivalMapper.festivalList();
    }
}
