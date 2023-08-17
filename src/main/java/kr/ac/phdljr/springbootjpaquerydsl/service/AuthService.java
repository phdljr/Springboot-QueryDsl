package kr.ac.phdljr.springbootjpaquerydsl.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.phdljr.springbootjpaquerydsl.dto.AuthResponse;
import kr.ac.phdljr.springbootjpaquerydsl.dto.LoginRequestDto;

import java.io.IOException;

public interface AuthService {
    AuthResponse authenticate(LoginRequestDto loginRequestDto);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
