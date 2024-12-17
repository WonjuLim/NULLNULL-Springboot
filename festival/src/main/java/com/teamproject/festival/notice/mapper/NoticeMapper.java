package com.teamproject.festival.notice.mapper;

import com.teamproject.festival.notice.dto.NoticeDto;
import com.teamproject.festival.notice.dto.NoticeMainDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {

    // 공지사항 전체 출력
    List<NoticeDto> noticeListAll(Map map);

    List<NoticeMainDto> noticeMainSelect(Map map);

    int countNotice(Map map);

    NoticeDto noticeDetail(String noId);

    int updateCount(String noId);

    int noticeInsert(NoticeDto noticeDto);

    String findUserId(String noId);

    int noticeDelete(String noId);
}
