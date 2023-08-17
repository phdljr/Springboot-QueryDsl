package kr.ac.phdljr.springbootjpaquerydsl.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.phdljr.springbootjpaquerydsl.config.service.JwtService;
import kr.ac.phdljr.springbootjpaquerydsl.domain.TokenType;
import kr.ac.phdljr.springbootjpaquerydsl.domain.Tokens;
import kr.ac.phdljr.springbootjpaquerydsl.domain.User;
import kr.ac.phdljr.springbootjpaquerydsl.dto.AuthResponse;
import kr.ac.phdljr.springbootjpaquerydsl.dto.LoginRequestDto;
import kr.ac.phdljr.springbootjpaquerydsl.repository.TokenRepository;
import kr.ac.phdljr.springbootjpaquerydsl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
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
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveToken(user,jwtToken);
        return new AuthResponse(jwtToken, refreshToken);
    }

    private void revokeAllUserTokens(User user){
        List<Tokens> validTokens = tokenRepository.findAllValidTokenByUsername(user.getEmail());
        if(!validTokens.isEmpty()){
            validTokens.forEach(t->{
                t.setExpired(true);
                t.setRevoked(true);
            });
        }
        tokenRepository.saveAll(validTokens);
    }

    private void saveToken(User user, String jwtToken){
        Tokens token = Tokens.builder()
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .username(user.getUsername())
                .build();
        tokenRepository.save(token);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if(userEmail != null){
            User user = userRepository.findByEmail(userEmail).get();
            if(jwtService.isTokenValid(refreshToken, user)){
                String accessToken = jwtService.generateToken(user);
                AuthResponse authResponse = new AuthResponse(accessToken, refreshToken);
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
