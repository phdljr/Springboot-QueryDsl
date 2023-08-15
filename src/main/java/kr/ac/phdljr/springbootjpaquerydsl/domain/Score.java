package kr.ac.phdljr.springbootjpaquerydsl.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;
    private String subject;
    private Long score;

    @ManyToOne
    private Student student;
}
