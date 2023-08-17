package kr.ac.phdljr.springbootjpaquerydsl.repository.querydsl;

import kr.ac.phdljr.springbootjpaquerydsl.domain.Tokens;

import java.util.List;

public interface TokenRepositoryCustom {
    List<Tokens> findAllValidTokenByUsername(String userName);
}
