package kr.ac.phdljr.springbootjpaquerydsl.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentResponseDto {
    private String name;
    private Integer age;
}
