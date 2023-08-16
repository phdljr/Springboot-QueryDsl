package kr.ac.phdljr.springbootjpaquerydsl.service;

import kr.ac.phdljr.springbootjpaquerydsl.dto.AuthResponse;
import kr.ac.phdljr.springbootjpaquerydsl.dto.LoginRequestDto;

public interface AuthService {
    AuthResponse authenticate(LoginRequestDto loginRequestDto);
}
