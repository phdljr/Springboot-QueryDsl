package kr.ac.phdljr.springbootjpaquerydsl.service;

import kr.ac.phdljr.springbootjpaquerydsl.domain.User;
import kr.ac.phdljr.springbootjpaquerydsl.dto.RegisterRequestDto;
import kr.ac.phdljr.springbootjpaquerydsl.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean register(RegisterRequestDto registerRequestDto) {
        String email = registerRequestDto.getEmail();
        String password = passwordEncoder.encode(registerRequestDto.getPassword());

        User saveUser = userRepository.save(User.builder()
                .email(email)
                .password(password)
                .build());

        return saveUser == null ? false : true;
    }
}
