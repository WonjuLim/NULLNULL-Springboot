    package com.teamproject.festival.gather.service;

    import com.teamproject.festival.gather.dto.GatherDto;
    import com.teamproject.festival.gather.dto.GatherImgDto;
    import com.teamproject.festival.gather.form.GatherForm;
    import com.teamproject.festival.gather.mapper.GatherMapper;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;
    import org.springframework.web.multipart.MultipartFile;

    import java.util.List;
    import java.util.Map;

    @Service
    @Transactional(rollbackFor = Exception.class) // 예외 발생 시 롤백
    public class GatherService {

        @Autowired
        private GatherMapper gatherMapper;

        @Autowired
        private GatherImgService gatherImgService;

        public String gatherInsert (GatherForm gatherForm, List<MultipartFile> gatherImgFileList) throws Exception {

            GatherDto gatherDto = makeGather(gatherForm); // form 을 dto 으로 변환

            gatherMapper.gatherInsert(gatherDto); // 축제 등록

            // 이미지 등록
            for (int i=0; i< gatherImgFileList.size(); i++) {
                GatherImgDto gatherImgDto = new GatherImgDto();
                // 축제 이미지에 ID만 먼저 등록
                gatherImgDto.setGatherId(gatherImgDto.getGatherId());

                gatherImgService.saveGatherImg(gatherImgDto, gatherImgFileList.get(i));
            }
            return gatherDto.getGatherId();
        }

        public int gatherImgInsert(GatherImgDto gatherImgDto) {
            return gatherMapper.gatherImgInsert(gatherImgDto);
        }

        public List<GatherDto> gatherListAll() {
            return gatherMapper.gatherListAll();
        }

        // 축제 검색 후 폼에 나타내기
        public GatherForm getGatherDtl(String gatherId) {
            // 축제 조회
            GatherDto gatherDto = gatherMapper.gatherSelect(gatherId);

            System.out.println(gatherDto);

            if (gatherDto == null) { // 축제가 존재하지 않으면 NullPointerException 을 발생 시킨다
                throw new NullPointerException("모집중인 축제가 없습니다.");
            }

            // 읽어온 내용을 폼의 형식으로 변환
            GatherForm gatherForm = makeGatherForm(gatherDto);
            // 이미지 설정
            gatherForm.setGatherImgList(gatherMapper.gatherImgSelect(gatherId));
            // 폼의 형태로 리턴
            return gatherForm;
        }

        // 축제 내용 수정 및 업데이트
        public String updateGather (GatherForm gatherForm, List<MultipartFile> gatherImgFileList) throws Exception {
            GatherDto gatherDto = makeGather(gatherForm);

            int result = gatherMapper.gatherUpdate(gatherDto);
            List<Long> gatherImgIds = gatherForm.getGatherImgIds();

            for (int i=0; i<gatherImgFileList.size(); i++) {
                GatherImgDto gatherImgDto = new GatherImgDto();
                gatherImgService.gatherImgUpdate(gatherImgIds.get(i), gatherImgFileList.get(i));
            }
            return gatherDto.getGatherId();
        }

        private GatherDto makeGather(GatherForm gatherForm) {
            GatherDto gatherDto = new GatherDto();
            gatherDto.setGatherId(gatherForm.getId());
            gatherDto.setGtTitle(gatherForm.getGtTitle());
            gatherDto.setGtRgDate(gatherForm.getGtRgDate());
            gatherDto.setPreferGender(gatherForm.getPreferGender());
            gatherDto.setPreferAge(gatherForm.getPreferAge());

            gatherDto.setGtCount(gatherForm.getGtCount());
            gatherDto.setGtImg(gatherForm.getGtImg());

            return gatherDto;
        }

        private GatherForm makeGatherForm(GatherDto gatherDto) {
            GatherForm gatherForm = new GatherForm();
            gatherForm.setId(gatherDto.getGatherId());
            gatherForm.setGtTitle(gatherDto.getGtTitle());
            gatherForm.setGtRgDate(gatherDto.getGtRgDate());
            gatherForm.setPreferGender(gatherDto.getPreferGender());
            gatherForm.setPreferAge(gatherDto.getPreferAge());
            gatherDto.setGtCount(gatherDto.getGtCount());

            return gatherForm;
        }

    }
