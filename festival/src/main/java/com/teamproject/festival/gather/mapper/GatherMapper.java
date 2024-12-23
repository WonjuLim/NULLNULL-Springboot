package com.teamproject.festival.gather.mapper;

import com.teamproject.festival.gather.dto.GatherImgDto;
import com.teamproject.festival.gather.dto.GatherDto;
import com.teamproject.festival.gather.dto.GatherSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GatherMapper {

    int gatherInsert(GatherDto gatherDto);

    List<GatherDto> gatherListAll();

    void gatherGtCount(String gatherId);

    // 눌렀을 때 해당 동행목록을 보임
    GatherDto gatherSelect(String gatherId);



    List<GatherSearchDto> gatherListPage(Map map);

    int countGather(Map map);

    int gatherUpdate(GatherDto gatherDto);

    int gatherDelete(String gatherId);



    // 이미지 부분

    int gatherImgInsert(GatherImgDto gatherImgDto);

    GatherImgDto gatherImgIdSelect(Long gatherImgId);

    int gatherImgUpdate(GatherImgDto gatherImgDto);


}
