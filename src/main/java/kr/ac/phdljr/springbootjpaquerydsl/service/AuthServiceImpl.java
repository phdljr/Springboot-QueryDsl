package kr.ac.phdljr.springbootjpaquerydsl.service;

import kr.ac.phdljr.springbootjpaquerydsl.config.service.JwtService;
import kr.ac.phdljr.springbootjpaquerydsl.domain.User;
import kr.ac.phdljr.springbootjpaquerydsl.dto.AuthResponse;
import kr.ac.phdljr.springbootjpaquerydsl.dto.LoginRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponse authenticate(LoginRequestDto loginRequestDto) {
        User user = User.builder()
                .email(loginRequestDto.getEmail())
                .password(loginRequestDto.getPassword())
                .build();
        // 해당 사용자가 로그인했는지 정보를 담고있는 AuthenticationManager
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );
        return new AuthResponse(jwtService.generateToken(user));
    }
}
