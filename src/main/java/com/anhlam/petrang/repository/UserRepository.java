package com.anhlam.petrang.repository;

import com.anhlam.petrang.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findUserById(Long id);
}
