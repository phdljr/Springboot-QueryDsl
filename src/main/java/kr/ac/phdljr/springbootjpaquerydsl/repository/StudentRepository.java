package kr.ac.phdljr.springbootjpaquerydsl.repository;

import kr.ac.phdljr.springbootjpaquerydsl.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
