package com.example.week05;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByIdAndUsername(Long id, String username) ;

    Optional<User> findUserById(Long id);



//    JPQL
    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    Optional<User> jpqlGetUser(String username, String passwords);

//    Native Query
    @Query(value = "SELECT * FROM users WHERE username = ?1 AND password = ?2", nativeQuery = true)
    Optional<User> nativeQueryGetUser(String username, String password);
}
