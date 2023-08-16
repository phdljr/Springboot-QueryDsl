package kr.ac.phdljr.springbootjpaquerydsl.controller;

import kr.ac.phdljr.springbootjpaquerydsl.domain.User;
import kr.ac.phdljr.springbootjpaquerydsl.dto.AuthResponse;
import kr.ac.phdljr.springbootjpaquerydsl.dto.LoginRequestDto;
import kr.ac.phdljr.springbootjpaquerydsl.dto.RegisterRequestDto;
import kr.ac.phdljr.springbootjpaquerydsl.service.AuthService;
import kr.ac.phdljr.springbootjpaquerydsl.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final RegisterService registerService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok(authService.authenticate(loginRequestDto));
    }

    @PostMapping("/register")
    public boolean register(@RequestBody RegisterRequestDto registerRequestDto) {
        return registerService.register(registerRequestDto);
    }
}
