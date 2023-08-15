package kr.ac.phdljr.springbootjpaquerydsl.service;

import kr.ac.phdljr.springbootjpaquerydsl.dto.SubjectScoreResponse;
import kr.ac.phdljr.springbootjpaquerydsl.repository.SubjectScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectScoreServiceImpl implements SubjectScoreService{
    private final SubjectScoreRepository subjectScoreRepository;

    @Override
    public List<SubjectScoreResponse> findScoresByStudent(Long studentId) {
        return subjectScoreRepository.findScoresByStudent(studentId);
    }
}
