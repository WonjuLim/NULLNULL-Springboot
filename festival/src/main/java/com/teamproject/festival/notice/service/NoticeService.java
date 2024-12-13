package com.teamproject.festival.notice.service;

import com.teamproject.festival.notice.dto.NoticeDto;
import com.teamproject.festival.notice.dto.NoticeMainDto;
import com.teamproject.festival.notice.form.NoticeForm;
import com.teamproject.festival.notice.mapper.NoticeMapper;
import com.teamproject.festival.user.dto.UserDto;
import com.teamproject.festival.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private UserMapper userMapper;

    // 전체 출력
    public List<NoticeDto> noticeListAll(Map map) {
        return noticeMapper.noticeListAll(map);
    }

    // 개수 count
    public int countNotice(Map map) {
        return noticeMapper.countNotice(map);
    }

    // 메인에 공지사항 select
    public List<NoticeMainDto> noticeMainSelect(Map map) {
        return noticeMapper.noticeMainSelect(map);
    }

    // 공지사항 상세보기
    public NoticeDto noticeDetail(String noId) {

        NoticeDto noticeDto = noticeMapper.noticeDetail(noId);

        return noticeDto;
    }

    // 조회수 추가
    public void updateCount(String noId) {
        int updatedRows = noticeMapper.updateCount(noId);
        if (updatedRows == 0) {
            throw new RuntimeException("조회수 업데이트 실패: noId=" + noId);
        }
    }

    // 공지사항 작성
    public String noticeInsert(NoticeForm noticeForm, String id) {
        NoticeDto noticeDto = makeNotice(noticeForm);

        UserDto userDto = userMapper.loginUser(id);
        noticeDto.setRegId(userDto.getUserId());

        noticeMapper.noticeInsert(noticeDto);

        return noticeDto.getRegId();
    }

    public NoticeDto makeNotice(NoticeForm noticeForm) {
        NoticeDto noticeDto =new NoticeDto();
        noticeDto.setNoId(noticeForm.getRegId());
        noticeDto.setNoTitle(noticeForm.getNoTitle());
        noticeDto.setNoText(noticeForm.getNoText());
        noticeDto.setNoFile(noticeForm.getNoFile());

        return noticeDto;
    }
}
