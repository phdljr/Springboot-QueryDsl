package kr.ac.phdljr.springbootjpaquerydsl.mapper;

import javax.annotation.processing.Generated;
import kr.ac.phdljr.springbootjpaquerydsl.domain.Student;
import kr.ac.phdljr.springbootjpaquerydsl.dto.StudentResponseDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-27T21:39:41+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toEntity(StudentResponseDto dto) {
        if ( dto == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.name( dto.getName() );
        student.age( dto.getAge() );

        return student.build();
    }

    @Override
    public StudentResponseDto toDto(Student Entity) {
        if ( Entity == null ) {
            return null;
        }

        StudentResponseDto.StudentResponseDtoBuilder studentResponseDto = StudentResponseDto.builder();

        studentResponseDto.name( Entity.getName() );
        studentResponseDto.age( Entity.getAge() );

        return studentResponseDto.build();
    }
}
