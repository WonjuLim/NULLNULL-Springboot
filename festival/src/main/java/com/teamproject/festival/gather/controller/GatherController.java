package com.teamproject.festival.gather.controller;

import com.teamproject.festival.gather.dto.GatherDto;
import com.teamproject.festival.gather.dto.GatherSearchDto;
import com.teamproject.festival.gather.form.GatherForm;
import com.teamproject.festival.gather.service.GatherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Controller
public class GatherController {

    @Autowired
    private GatherService gatherService;

    // gather/gatherList << 메인 페이지에서 '같이가요 축제'
    @GetMapping("/gather/gatherList")
    public String gatherList(Model model) {
        List<GatherDto> gatherList = gatherService.gatherListAll();
        model.addAttribute("gatherList", gatherList);
//        model.addAttribute("gatherForm", new GatherForm());
        return "/gather/gatherForm";
    }

    @PostMapping("/gather/gatherList")
    public String gatherNew(@Valid GatherForm gatherForm, BindingResult bindingResult, Model model, @RequestParam("gatherImgFile")List<MultipartFile> gatherImgFileList) {
        if (bindingResult.hasErrors()) {
            return "gather/gatherForm";
        }

        if (gatherImgFileList.get(0).isEmpty() && gatherForm.getId() == null) {
            model.addAttribute("errorMessage", "축제 사진은 필수 입니다.");
            return "gather/gatherForm";
        }

        try {
            gatherService.gatherInsert(gatherForm, gatherImgFileList);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "축제 등록 중 오류가 발생하였습니다");
            return "gather/gatherForm";
        }
        return "redirect:/";
    }

    @GetMapping("/gather/gatherList/{gatherId}")
    public String gatherDtl(@PathVariable("gatherId")String gatherId, Model model) {
        try {
            GatherForm gatherForm = gatherService.getGatherDtl(gatherId);
            model.addAttribute("gatherForm", gatherForm);
        } catch (NullPointerException e) {
            model.addAttribute("errorMessage", "존재하지 않는 축제입니다.");
            model.addAttribute("gatherForm", new GatherForm());
        }
        return "gather/gatherForm";
    }

    @PostMapping("/gather/gatherList/{gatherId}")
    public String gatherUpdate(@Valid GatherForm gatherForm, BindingResult bindingResult, @RequestParam("gatherImgFile") List<MultipartFile> gatherImgFileList, Model model) {
        if(bindingResult.hasErrors()) {
            return "gather/gatherForm";
        }

        if (gatherImgFileList.get(0).isEmpty() && gatherForm.getUserId() == null) {
            model.addAttribute("errorMessage", "축제 사진은 필수 입니다.");
        }

        try {
            gatherService.updateGather(gatherForm, gatherImgFileList);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "축제 등록 중 오류가 발생 하였습니다.");
            e.printStackTrace();
            return "gather/gatherForm";
        }
        return "redirect:/";
    }

    @GetMapping("/gather/{gatherId}")
    public String gatherDtl(Model model, @PathVariable("gatherId") String gatherId) {
        GatherForm gatherForm = gatherService.getGatherDtl(gatherId);
        model.addAttribute("gather", gatherForm);

        return "gather/gatherDetail";
    }



}