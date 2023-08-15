package kr.ac.phdljr.springbootjpaquerydsl.repository.querydsl;

import kr.ac.phdljr.springbootjpaquerydsl.dto.SubjectScoreResponse;

import java.util.List;

public interface SubjectScoreCustom {
    List<SubjectScoreResponse> findScoresByStudent(Long studentId);
}
