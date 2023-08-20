package kr.ac.phdljr.springbootjpaquerydsl.mapper;

import kr.ac.phdljr.springbootjpaquerydsl.domain.Student;
import kr.ac.phdljr.springbootjpaquerydsl.dto.StudentResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StudentMapperTest {

    @Test
    public void structMapper_toDto_변환() {
        Long id = 1L;
        Integer age = 10;
        String name = "테스트";

        Student student = Student.builder()
                .studentId(id)
                .age(age)
                .name(name)
                .build();

        StudentResponseDto dto = StudentMapper.INSTANCE.toDto(student);

        log.info("{}", dto);
        assertThat(dto.getAge()).isEqualTo(age);
        assertThat(dto.getName()).isEqualTo(name);
    }

    @Test
    public void structMapper_toEntity_변환() {
        Long id = 1L;
        Integer age = 10;
        String name = "테스트";

        StudentResponseDto dto = StudentResponseDto.builder()
                .age(age)
                .name(name)
                .build();

        Student student = StudentMapper.INSTANCE.toEntity(dto);
        student.setStudentId(id);

        log.info("{}", student);
        assertThat(student.getStudentId()).isEqualTo(id);
        assertThat(student.getAge()).isEqualTo(age);
        assertThat(student.getName()).isEqualTo(name);
    }
}
