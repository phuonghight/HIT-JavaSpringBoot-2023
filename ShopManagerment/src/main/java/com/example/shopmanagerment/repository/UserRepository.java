package com.example.shopmanagerment.repository;

import com.example.shopmanagerment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByUsername(String username);

    public List<User> findUsersByFullNameContaining(String name);

    @Query("SELECT u FROM User u WHERE u.fullName LIKE %?1%")
    public List<User> searchByUsername(String name);
}
