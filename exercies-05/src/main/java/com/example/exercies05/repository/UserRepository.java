package com.example.exercies05.repository;

import com.example.exercies05.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value = "SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    @Query(value = "SELECT * FROM user u WHERE u.username = ?1 AND u.password = ?2", nativeQuery = true)
    Optional<User> getUserByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM user u WHERE u.username = ?1", nativeQuery = true)
    Optional<User> getUserByUsername(String username);
}
