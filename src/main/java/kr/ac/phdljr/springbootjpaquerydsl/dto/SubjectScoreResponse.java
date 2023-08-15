package kr.ac.phdljr.springbootjpaquerydsl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectScoreResponse {
    private Long studentId;
    private String name;
    private Integer age;
    private String subject;
    private Integer score;
}
