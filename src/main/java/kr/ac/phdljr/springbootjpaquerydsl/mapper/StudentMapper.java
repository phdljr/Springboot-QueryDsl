package kr.ac.phdljr.springbootjpaquerydsl.mapper;

import kr.ac.phdljr.springbootjpaquerydsl.domain.Student;
import kr.ac.phdljr.springbootjpaquerydsl.dto.StudentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper extends EntityMapper<StudentResponseDto, Student>{
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
}
