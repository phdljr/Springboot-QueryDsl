package kr.ac.phdljr.springbootjpaquerydsl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestDto {
    private String email;
    private String password;
}
