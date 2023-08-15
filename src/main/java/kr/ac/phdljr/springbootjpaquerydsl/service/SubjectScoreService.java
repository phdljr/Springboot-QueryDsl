package kr.ac.phdljr.springbootjpaquerydsl.service;

import kr.ac.phdljr.springbootjpaquerydsl.dto.SubjectScoreResponse;

import java.util.List;

public interface SubjectScoreService {
    List<SubjectScoreResponse> findScoresByStudent(Long studentId);
}
