package kr.ac.phdljr.springbootjpaquerydsl.repository.querydsl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.ac.phdljr.springbootjpaquerydsl.domain.QScore;
import kr.ac.phdljr.springbootjpaquerydsl.domain.QStudent;
import kr.ac.phdljr.springbootjpaquerydsl.dto.SubjectScoreResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SubjectScoreCustomImpl implements SubjectScoreCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SubjectScoreResponse> findScoresByStudent(Long studentId) {
        QStudent st = QStudent.student;
        QScore sc = QScore.score1;

        JPAQuery<Tuple> query = jpaQueryFactory.select(st.studentId, st.name, st.age, sc.subject, sc.score)
                .from(st)
                .join(sc)
                .on(st.studentId.eq(sc.scoreId))
                .where(st.studentId.eq(studentId))
                .orderBy(st.studentId.desc());

        // Lazy Loading 사용 안하게 함
        return query.fetchJoin().fetch().stream().map(tuple -> SubjectScoreResponse.builder()
                    .studentId(tuple.get(st.studentId))
                    .name(tuple.get(st.name))
                    .age(tuple.get(st.age))
                    .subject(tuple.get(sc.subject))
                    .score(tuple.get(sc.score))
                .build()).toList();
    }
}
