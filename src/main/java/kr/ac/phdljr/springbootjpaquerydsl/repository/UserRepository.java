package kr.ac.phdljr.springbootjpaquerydsl.repository;

import kr.ac.phdljr.springbootjpaquerydsl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
