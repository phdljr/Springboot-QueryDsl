package kr.ac.phdljr.springbootjpaquerydsl.repository;

import kr.ac.phdljr.springbootjpaquerydsl.domain.Score;
import kr.ac.phdljr.springbootjpaquerydsl.repository.querydsl.SubjectScoreCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectScoreRepository extends JpaRepository<Score, Long>, SubjectScoreCustom {
}
