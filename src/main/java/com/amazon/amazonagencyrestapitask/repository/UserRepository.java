package com.amazon.amazonagencyrestapitask.repository;

import com.amazon.amazonagencyrestapitask.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByEmail(String email);
}
