package com.teamproject.festival.gather.mapper;

import com.teamproject.festival.gather.dto.GatherImgDto;
import com.teamproject.festival.gather.dto.GatherDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GatherMapper {

    int gatherInsert(GatherDto gatherDto);

    int gatherImgInsert(GatherImgDto gatherImgDto);

    List<GatherDto> gatherListAll();

    GatherDto gatherSelect(String gatherId);

    List<GatherImgDto> gatherImgSelect(String gatherId);

    GatherImgDto gatherImgIdSelect(Long gatherImgId);

    int gatherUpdate(GatherDto gatherDto);

    int gatherImgUpdate(GatherImgDto gatherImgDto);

    List<GatherDto> gatherListPage(Map map);

    List<GatherDto> mainSelect(Map map);

    int countGatherList(Map map);
}
