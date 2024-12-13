package com.teamproject.festival.festival.controller;

import com.teamproject.festival.festival.dto.FestivalDetailDto;
import com.teamproject.festival.festival.dto.FestivalListDto;
import com.teamproject.festival.festival.dto.FestivalMainDto;
import com.teamproject.festival.festival.service.FestivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Controller
public class FestivalController {

    @Autowired
    private FestivalService festivalService;

    @GetMapping("/festival")
    public List<FestivalMainDto> festivalList(Map map) {
        return festivalService.festivalMainList(map);
    }

    //페스티벌 리스트
    @GetMapping("/festival")
    public String festivalList(Model model){

        List<FestivalListDto> festival = festivalService.festivalList();

        model.addAttribute("festival", festival);


        return "festival/festivalList";
    }

    //페스티벌 디테일
    @GetMapping("/detail/{ftId}")
    public String festivalDtl(Model model, @PathVariable("ftId")Long ftId){

        FestivalDetailDto festivalDetailDto = festivalService.getFestivalDetail(ftId);

        model.addAttribute("festivalDetail", festivalDetailDto);


        return "festival/festivalDetail";
    }

//    @GetMapping("/detail")
//    public String festivalRv(){
//
//        festivalReviewService.festivalReview(festivalReviewDto);
//
//        //model.addAttribute("festivalReview",);
//
//        return "festival/festivalDetail";
//    }
}
