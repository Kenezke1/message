package com.message.system.message_system.Repository;

import com.message.system.message_system.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Override
    Optional<User> findById(Integer integer);

    Optional<User> findByEmail(String email);
}
