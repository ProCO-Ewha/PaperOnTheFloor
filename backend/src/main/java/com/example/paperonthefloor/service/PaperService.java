package com.example.paperonthefloor.service;

import com.example.paperonthefloor.domain.Paper;
import com.example.paperonthefloor.repository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PaperService {
    @Autowired
    private PaperRepository paperRepository;

    // 작성
    @Transactional
    public Long write(Paper paper) {
        paperRepository.save(paper);
        return paper.getId();
    }
    // 조회
    public Paper getDiaryDetails(Long paperId) {
        return paperRepository.findOne(paperId);
    }
    // 일별 랜덤 조회
    public Paper getPapersByDate(int year, int month, int day) {
        List<Paper> papers = paperRepository.findDiariesByIdAndDate(year, month, day);
        if (papers == null || papers.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(papers.size());
        return papers.get(randomIndex);
//        List<Paper> papersOnTheFloor = new ArrayList<>();
//
//        if (papers.size() > 10) {
//            List<Integer> indexes = new ArrayList<>();
//            for (int i = 0; i < papers.size(); i++) {
//                indexes.add(i);
//            }
//            Collections.shuffle(indexes);
//            for (int i = 0; i < 10; i++) {
//                papersOnTheFloor.add(papers.get(indexes.get(i)));
//            }
//        } else {
//            papersOnTheFloor.addAll(papers);
//        }
//
//        return papersOnTheFloor;

    }
}
