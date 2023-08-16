package kr.ac.phdljr.springbootjpaquerydsl.service;

import kr.ac.phdljr.springbootjpaquerydsl.domain.User;

public interface AuthService {
    User authenticate(User user);
}
