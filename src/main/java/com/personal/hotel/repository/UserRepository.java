package com.personal.hotel.repository;

import com.personal.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public Optional<User> findByUsername(String username);
}
