package io.redgroul.sbcrudport.repository;

import io.redgroul.sbcrudport.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
