package kr.ac.phdljr.springbootjpaquerydsl.repository;

import kr.ac.phdljr.springbootjpaquerydsl.domain.Tokens;
import kr.ac.phdljr.springbootjpaquerydsl.repository.querydsl.TokenRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Tokens, Long>, TokenRepositoryCustom {
    Optional<Tokens> findByToken(String token);
}
