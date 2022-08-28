package com.example.fides.Repository;

import com.example.fides.Entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsByUserId(String userId);

    Optional<User> findByUserId(String userId);

}
