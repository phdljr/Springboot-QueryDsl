package kr.ac.phdljr.springbootjpaquerydsl.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ac.phdljr.springbootjpaquerydsl.dto.SubjectScoreResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SubjectScoreCustomImpl implements SubjectScoreCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SubjectScoreResponse> findScoresByStudent(Long studentId) {

        return null;
    }
}
