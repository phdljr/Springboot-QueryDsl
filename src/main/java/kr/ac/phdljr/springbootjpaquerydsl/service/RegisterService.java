package kr.ac.phdljr.springbootjpaquerydsl.service;

import kr.ac.phdljr.springbootjpaquerydsl.dto.RegisterRequestDto;

public interface RegisterService {
    boolean register(RegisterRequestDto registerRequestDto);
}
