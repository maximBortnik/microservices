package com.microservices.authorization.server.repository;

import com.microservices.authorization.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author bortnik
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameCaseInsensitive(String username);
}
